package view.user;

import covidController.ICovidControllerCitizen;
import covidModel.ICovidModelCitizen;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.swing.JTextField;

public class SimpleUserGUIView implements IUserGUiView {

  private ActionListener controller;
  private ICovidModelCitizen model;
  private JFrame frame;
  private JPanel mainPanel;
  private JPanel titlePanel;
  private JPanel outputPanel;
  private JPanel buttonPanel;
  private JPanel queryingPanel;
  private JPanel registerPanel;
  private JLabel outputLabel;
  private JTextField isContacted;
  private JTextField hasSymptomText;
  private JTextField fullyVaccText;
  private JTextField inQuarantineText;
  private Map<String, Runnable> actions;

  /**
   * Constructs an object of SimpleGovernmentGUI.
   * @throws IllegalArgumentException   if any of the given arguments is invalid.
   */
  public SimpleUserGUIView(ActionListener controller, ICovidModelCitizen model) {

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

    this.addActions();
  }

  private void addActions() {
    this.actions = new HashMap<>();
    ICovidControllerCitizen citizenCtr = (ICovidControllerCitizen) controller;
    this.actions.put("get_travel_history",
        () -> {this.outputLabel.setText(citizenCtr.queryTravelHistory());});
    this.actions.put("get_advice",
        () -> {
      this.outputLabel.setText(citizenCtr.queryAdvice());});
    this.actions.put("get_permission",
        () -> { this.outputLabel.setText(citizenCtr.queryPermission());});
    this.actions.put("upload_information", this::uploadUserInformation); // Query information
  }

  private void uploadUserInformation() {

    String result = this.inQuarantineText.getText() + " " + this.fullyVaccText.getText() + " "
        + this.isContacted.getText() + " " + this.hasSymptomText.getText() + " ";
    ICovidControllerCitizen contr = (ICovidControllerCitizen) this.controller;
    contr.registerInformation(result);
  }

  /**
   * Initializes the frame of the gui.
   */
  private void initFrame() {
    this.frame = new JFrame("Government COVID-19 Status Tracking");
    this.frame.setSize(900, 300);
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

    this.initRegisterPanel();

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

    JButton getInfectionChance = new JButton("建议 Advice");
    getInfectionChance.addActionListener(this.controller);
    getInfectionChance.setActionCommand("get_advice");
    this.queryingPanel.add(getInfectionChance);

    JButton getPersonInfoSummery = new JButton("外出许可 Permission");
    getPersonInfoSummery.addActionListener(this.controller);
    getPersonInfoSummery.setActionCommand("get_permission");
    this.queryingPanel.add(getPersonInfoSummery);

    this.buttonPanel.add(this.queryingPanel);
  }

  /**
   * Setup the registry Panel.
   */
  private void initRegisterPanel() {
    this.registerPanel = new JPanel();
    this.registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.PAGE_AXIS));

    this.registerPanel.setBorder(BorderFactory.createTitledBorder("登记信息 Upload Info (true/false)"));

    JPanel line3 = new JPanel();

    JLabel fullyVaccHint = new JLabel("是否完成疫苗接种 Are you fully vaccinated");
    line3.add(fullyVaccHint);
    this.fullyVaccText = new JTextField(5);
    line3.add(this.fullyVaccText);

    JLabel isContactedHint =
        new JLabel("是否和疑似确诊着密切接触 Had close contact with symptomatic individuals: ");
    line3.add(isContactedHint);
    this.isContacted = new JTextField(5);
    line3.add(this.isContacted);

    this.registerPanel.add(line3);

    JPanel line4 = new JPanel();

    JLabel inQuarantineHint = new JLabel("是否正在隔离 Are you in quarantine");
    line4.add(inQuarantineHint);
    this.inQuarantineText = new JTextField(5);
    line4.add(this.inQuarantineText);

    this.registerPanel.add(line4);

    JPanel line2 = new JPanel();

    JLabel hasSymptomHint = new JLabel("是否患有症状 Report COVID related symptoms");
    line2.add(hasSymptomHint);
    this.hasSymptomText = new JTextField(12);
    line2.add(this.hasSymptomText);

    JButton exportIndividualInformationSummary = new JButton("上传 Upload Information");
    exportIndividualInformationSummary.addActionListener(this.controller);
    exportIndividualInformationSummary.setActionCommand("upload_information");
    line2.add(exportIndividualInformationSummary);

    this.registerPanel.add(line2);




    this.buttonPanel.add(this.registerPanel);
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
  public void getNotified(String actionName) {
    if (actionName == null) {
      throw new IllegalArgumentException("Argument cannot be null.");
    }
    actions.get(actionName).run();
  }
}
