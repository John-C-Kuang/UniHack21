package covidController;

public interface ICovidControllerCitizen extends ICovidController {
  String queryMedicalAdvice();

  boolean queryTravelPermission();
}
