package view.gov;

import Person.Address;
import covidController.ICovidControllerGovernment;
import covidModel.ICovidModelGovernment;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Represents a Simple gui for governmental use. Allows the user to track an individual's
 * travel history, chance of infection, personal information summery, etc.
 */
public class SimpleGovernmentGUI implements IGovernmentGUIView {

  private ICovidModelGovernment model;
  private ActionListener controller;
  private JFrame frame;
  private JPanel mainPanel;
  private JPanel titlePanel;
  private JPanel outputPanel;
  private JPanel buttonPanel;
  private JPanel queryingPanel;
  private JPanel exportPanel;
  private JLabel outputLabel;
  private Map<String, Runnable> actions;

  /**
   * Constructs an object of SimpleGovernmentGUI.
   * @throws IllegalArgumentException   if any of the given arguments is invalid.
   */
  public SimpleGovernmentGUI(ActionListener controller, ICovidModelGovernment model) {

    // Check the validity of arguments
    if (controller == null) {
      throw new IllegalArgumentException("Invalid argument passed.");
    }
    this.controller = controller;
    this.model = model;

    // Initializes gui
    this.initFrame();

    this.initMainPanel();

    this.initTitlePanel();

    this.initOutputPanel();

    this.initButtonPanel();

    this.frame.pack();
    this.frame.setVisible(true);

    this.addAction();
  }

  /**
   * Initializes the frame of the gui.
   */
  private void initFrame() {
    this.frame = new JFrame("Government COVID-19 Status Tracking");
    this.frame.setSize(1200, 300);
    this.frame.setLocation(200, 200);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setResizable(true);
    this.frame.setMinimumSize(new Dimension(600, 400));
    this.frame.setBackground(new Color(255, 250, 250));
  }

  /**
   * Setup the main Panel.
   */
  private void initMainPanel() {
    this.mainPanel = new JPanel();
    this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.PAGE_AXIS));
    this.frame.add(this.mainPanel);
  }

  /**
   * Setup the title Panel.
   */
  private void initTitlePanel() {
    this.titlePanel = new JPanel();
    this.titlePanel.setLayout(new FlowLayout());
    this.titlePanel.add(new JLabel("COVID-19 Status Tracker"));
    this.mainPanel.add(this.titlePanel);
  }

  /**
   * Setup the output Panel.
   */
  private void initOutputPanel() {
    this.outputPanel = new JPanel();
    this.outputPanel.setLayout(new FlowLayout());
    this.outputPanel.setBorder(BorderFactory.createTitledBorder("信息 Information"));
    this.outputLabel = new JLabel("");
    this.outputPanel.add(this.outputLabel);
    this.mainPanel.add(this.outputPanel);
  }

  /**
   * Setup the button Panel.
   */
  private void initButtonPanel() {
    this.buttonPanel = new JPanel();
    this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, BoxLayout.PAGE_AXIS));

    this.initQueryingPanel();

    this.initExportPanel();

    this.mainPanel.add(this.buttonPanel);
  }


  /**
   * Setup the querying Panel.
   */
  private void initQueryingPanel() {
    this.queryingPanel = new JPanel();
    this.queryingPanel.setLayout(new FlowLayout());

    this.queryingPanel.setBorder(BorderFactory.createTitledBorder("查询信息 Query Information"));

    JButton getTravelHistory = new JButton("行程 Travel History");
    getTravelHistory.addActionListener(this.controller);
    getTravelHistory.setActionCommand("get_travel_history");
    this.queryingPanel.add(getTravelHistory);

    JButton getInfectionChance = new JButton("感染率 Chance of Infection");
    getInfectionChance.addActionListener(this.controller);
    getInfectionChance.setActionCommand("get_chance_of_infection");
    this.queryingPanel.add(getInfectionChance);

    JButton getPersonInfoSummery = new JButton("个人信息 Information Summary");
    getPersonInfoSummery.addActionListener(this.controller);
    getPersonInfoSummery.setActionCommand("get_person_info_summary");
    this.queryingPanel.add(getPersonInfoSummery);

    this.buttonPanel.add(this.queryingPanel);
  }

  /**
   * Setup the export Panel.
   */
  private void initExportPanel() {
    this.exportPanel = new JPanel();
    this.exportPanel.setLayout(new FlowLayout());

    this.exportPanel.setBorder(BorderFactory.createTitledBorder("导出信息 Export Information"));

    JButton exportTravelHistory = new JButton("人员行程记录 Individual Travel History");
    exportTravelHistory.addActionListener(this.controller);
    exportTravelHistory.setActionCommand("export_travel_history");
    this.exportPanel.add(exportTravelHistory);

    JButton exportInfectionReport = new JButton("感染报告 COVID-19 Infection Report");
    exportInfectionReport.addActionListener(this.controller);
    exportInfectionReport.setActionCommand("export_infection_report");
    this.exportPanel.add(exportInfectionReport);

    JButton exportIndividualInformationSummary = new JButton("登记信息 Personal Information");
    exportIndividualInformationSummary.addActionListener(this.controller);
    exportIndividualInformationSummary.setActionCommand("export_personal_info_summary");
    this.exportPanel.add(exportIndividualInformationSummary);

    this.buttonPanel.add(this.exportPanel);
  }

  /**
   * Add Actions.
   */
  private void addAction() {
    this.actions = new HashMap<>();
    this.actions.put("get_travel_history", this::getTravelHistory);
    this.actions.put("get_chance_of_infection",
        () -> { this.outputLabel.setText(this.model.getCovidSituation()); });
    this.actions.put("get_person_info_summary", this::getPersonInfoSummary);
    this.actions.put("no_action", () -> {});
    this.actions.put("export_travel_history", this::exportTravelHistory);
    this.actions.put("export_personal_info_summary", this::exportPersonalInformation);
  }

  private void exportPersonalInformation() {
    ICovidControllerGovernment contr = (ICovidControllerGovernment) controller;
    contr.printPersonalInformation(Long.valueOf(this.showInteractivePopup("请输入PersonID: ")));
  }

  private void exportTravelHistory() {
    ICovidControllerGovernment contr = (ICovidControllerGovernment) controller;
    contr.printTravelHistory(Long.valueOf(this.showInteractivePopup("请输入PersonID: ")));
  }

  private void getTravelHistory() {
    String personIdStr = this.showInteractivePopup("请输入PersonID: ");
    long personId = Long.valueOf(personIdStr);
    this.outputLabel.setText(this.model.queryPersonalInformation(personId).travelHistoryToString());
  }

  private void getPersonInfoSummary() {
    String personIdStr = this.showInteractivePopup("请输入PersonID: ");
    long personId = Long.valueOf(personIdStr);
    this.outputLabel.setText(this.model.queryPersonalInformation(personId).toString());
  }



  /**
   * Display a popup window with a message.
   * @param message         the message to be shown
   * @throws IllegalArgumentException   if message is null
   */
  @Override
  public void showPopUp(String message) throws IllegalArgumentException {
    if (message == null) {
      throw new IllegalArgumentException("Message cannot be null.");
    }
    JOptionPane.showMessageDialog(null, message);
  }

  @Override
  public String showInteractivePopup(String question) throws IllegalArgumentException {
    if (question == null) {
      throw new IllegalArgumentException("Question cannot be null");
    }
    JFrame popupFrame = new JFrame();
    String result = JOptionPane.showInputDialog(popupFrame, question);
    return result;
  }

  @Override
  public void getNotified(String actionName) {
    if (actionName == null) {
      throw new IllegalArgumentException("actionName cannot be null.");
    }
    if (!actionName.equals("no_action")) {
      this.actions.get(actionName).run();
    }
  }
}
