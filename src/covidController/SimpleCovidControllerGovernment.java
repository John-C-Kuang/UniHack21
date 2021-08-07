package covidController;

import covidModel.ICovidModelGovernment;


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
    return null;
  }

  @Override
  public void printTravelHistory(long id) {

  }

  @Override
  public void printCovidSituation() {

  }

  @Override
  public void printPersonalInformation() {

  }
}
