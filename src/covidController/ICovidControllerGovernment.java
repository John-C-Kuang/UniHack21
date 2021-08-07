package covidController;

public interface ICovidControllerGovernment {
    String queryPersonalTravelHistory(long id);

    String queryPersonalInformation(long id);

    String getCovidSituation();

    void printTravelHistory(long id);

    void printCovidSituation();

    void printPersonalInformation();

}
