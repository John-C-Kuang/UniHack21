package covidController;

import covidModel.ICovidModelGovernment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import view.gov.IGovernmentGUIView;


public class SimpleCovidControllerGovernment implements ICovidControllerGovernment, ActionListener {
  private ICovidModelGovernment model;
  private IGovernmentGUIView view;

  public SimpleCovidControllerGovernment(ICovidModelGovernment model, IGovernmentGUIView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public String queryPersonalTravelHistory(long id) {
    return model.queryPersonalInformation(id).travelHistoryToString();
  }

  @Override
  public String queryPersonalInformation(long id) {
    return model.queryPersonalInformation(id).toString();
  }

  @Override
  public String getCovidSituation() {
    return null;
  }

  @Override
  public void printTravelHistory(long id) {
    fileWriter(this.queryPersonalTravelHistory(id));
  }

  @Override
  public void printCovidSituation() {
    fileWriter(this.getCovidSituation());
  }

  @Override
  public void printPersonalInformation(long id) {
    fileWriter(this.queryPersonalInformation(id));
  }

  private static void fileWriter(String content) {
    String filePath = "output.txt";
    FileWriter fwriter = null;

    try {
      fwriter = new FileWriter(filePath, true);
      fwriter.write(content);
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      try {
        fwriter.flush();
        fwriter.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  @Override
  public void setView(IGovernmentGUIView view) {
    this.view = view;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    if (e == null) {
      throw new IllegalArgumentException("ActionEvent cannot be null");
    }
    try {
      switch (e.getActionCommand()) {
        // Save section
        case "get_travel_history":
          this.view.getNotified("get_travel_history");
          break;
        case "get_chance_of_infection":
          this.view.getNotified("get_chance_of_infection");
          break;
        case "get_person_info_summary":
          this.view.getNotified("get_person_info_summary");
          break;
        case "export_travel_history":
          this.view.getNotified("export_travel_history");
          break;
        case "export_infection_report":
          this.view.getNotified("no_action");
          this.printCovidSituation();
          break;
        case "export_personal_info_summary":
          this.view.getNotified("export_personal_info_summary");
          break;
        default:
          throw new IllegalArgumentException("Unsupported command.");
      }
    } catch (RuntimeException exception) {
      this.view.showPopUp(exception.getMessage());
    }
  }



}
