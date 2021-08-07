package covidController;

import view.gov.IGovernmentGUIView;

public interface ICovidControllerGovernment {
    String queryPersonalTravelHistory(long id);

    String queryPersonalInformation(long id);

    String getCovidSituation();

    void setView(IGovernmentGUIView view);

    void printTravelHistory(long id);

    void printCovidSituation();

    void printPersonalInformation(long id);

}
