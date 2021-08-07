package covidController;

import Person.IPerson;

public interface ICovidControllerCitizen {
  String queryMedicalAdvice();

  boolean queryTravelPermission();

  String checkTravelHistory(IPerson person);

}
