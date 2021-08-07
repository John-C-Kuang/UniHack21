package covidController;

public interface ICovidControllerCitizen extends ICovidController {
  String queryPersonalInformation();

  String queryTravelHistory();

  String queryAdvice();

  String queryPermission();

  void registerInformation(String str);
}
