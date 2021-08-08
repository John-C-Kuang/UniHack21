package covidController;

import view.gov.IGovernmentGUIView;
import view.user.IUserGUiView;

public interface ICovidControllerCitizen extends ICovidController {
  String queryPersonalInformation();

  String queryTravelHistory();

  String queryAdvice();

  String queryPermission();

  void registerInformation(String str);

  void setView(IUserGUiView view);

}
