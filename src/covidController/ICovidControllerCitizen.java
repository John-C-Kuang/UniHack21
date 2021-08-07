package covidController;

import Person.IPerson;

public interface ICovidControllerCitizen extends ICovidController {
  String queryMedicalAdvice();

  boolean queryTravelPermission();

  String checkTravelHistoory(IPerson person);
  
}
