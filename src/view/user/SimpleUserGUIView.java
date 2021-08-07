package view.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleUserGUIView implements IUserGUiView {

  private ActionListener controller;
  private JFrame frame;
  private JPanel mainPanel;
  private JPanel titlePanel;
  private JPanel outputPanel;
  private JPanel buttonPanel;
  private JPanel queryingPanel;
  private JPanel registerPanel;
  private JLabel outputLabel;
  private JTextField firstNameText;
  private JTextField lastNameText;
  private JTextField idText;
  private JTextField travelHistoryText;
  private JTextField hasCovidText;
  private JTextField hasSymptomText;
  private JTextField fullyVaccText;
  private JTextField inQuarantineText;
  private JTextField testResultText;
  private JTextField ageText;
  private JTextField genderText;

  /**
   * Constructs an object of SimpleGovernmentGUI.
   * @throws IllegalArgumentException   if any of the given arguments is invalid.
   */
  public SimpleUserGUIView(ActionListener controller) {

    // Check the validity of arguments
//    if (controller == null) {
//      throw new IllegalArgumentException("Invalid argument passed.");
//    }

    // Initializes gui
    this.initFrame();

    this.initMainPanel();

    this.initTitlePanel();

    this.initOutputPanel();

    this.initButtonPanel();

    this.frame.pack();
    this.frame.setVisible(true);
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

    this.registerPanel.setBorder(BorderFactory.createTitledBorder("登记信息 Upload Info"));
    JPanel line1 = new JPanel();

    JLabel lastNameHint = new JLabel("姓 Last Name: ");
    line1.add(lastNameHint);
    this.lastNameText = new JTextField(5);
    line1.add(this.lastNameText);

    JLabel firstNameHint = new JLabel("名 First Name: ");
    line1.add(firstNameHint);
    this.firstNameText = new JTextField(5);
    line1.add(this.firstNameText);

    JLabel idHint = new JLabel("ID: ");
    line1.add(idHint);
    this.idText = new JTextField(5);
    line1.add(this.idText);
    this.registerPanel.add(line1);

    JPanel line2 = new JPanel();

    JLabel travelHistoryHint = new JLabel("出行记录 Travel History: ");
    line2.add(travelHistoryHint);
    this.travelHistoryText = new JTextField(12);
    line2.add(this.travelHistoryText);

    JLabel hasCovidHint = new JLabel("是否患有新冠 Are you Infected");
    line2.add(hasCovidHint);
    this.hasCovidText = new JTextField(3);
    line2.add(this.hasCovidText);

    this.registerPanel.add(line2);

    JPanel line3 = new JPanel();

    JLabel hasSymptomHint = new JLabel("是否患有症状 Report COVID related symptoms");
    line3.add(hasSymptomHint);
    this.hasSymptomText = new JTextField(5);
    line3.add(this.hasSymptomText);

    JLabel fullyVaccHint = new JLabel("是否完成疫苗接种 Are you fully vaccinated");
    line3.add(fullyVaccHint);
    this.fullyVaccText = new JTextField(5);
    line3.add(this.fullyVaccText);

    this.registerPanel.add(line3);

    JPanel line4 = new JPanel();

    JLabel inQuarantineHint = new JLabel("是否正在隔离 Are you in quarantine");
    line4.add(inQuarantineHint);
    this.inQuarantineText = new JTextField(5);
    line4.add(this.inQuarantineText);

    JLabel testPositiveHint = new JLabel("五天内新冠测试是否阳性 Test Positive within 5 days");
    line4.add(testPositiveHint);
    this.testResultText = new JTextField(5);
    line4.add(this.testResultText);

    this.registerPanel.add(line4);

    JPanel line5 = new JPanel();

    JLabel ageHint = new JLabel("年龄 Age");
    line5.add(inQuarantineHint);
    this.ageText = new JTextField(5);
    line5.add(this.ageText);

    JLabel genderHint = new JLabel("性别 Gender");
    line5.add(genderHint);
    this.genderText = new JTextField(5);
    line5.add(this.genderText);

    JButton exportIndividualInformationSummary = new JButton("上传 Upload Information");
    exportIndividualInformationSummary.addActionListener(this.controller);
    exportIndividualInformationSummary.setActionCommand("upload_information");
    line5.add(exportIndividualInformationSummary);

    this.registerPanel.add(line5);



    this.buttonPanel.add(this.registerPanel);
  }


}
