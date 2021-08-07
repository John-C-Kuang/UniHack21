package covidController;

import covidModel.ICovidModelGovernment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


public class SimpleCovidControllerGovernment implements ICovidControllerGovernment {
  ICovidModelGovernment model;

  SimpleCovidControllerGovernment(ICovidModelGovernment model) {
    this.model = model;
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
    return model.getCovidSituation();
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
    String filePath = "F:\\output.txt";
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
}
