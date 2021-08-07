package covidController;

import Person.IPerson;

public interface ICovidControllerGovernment {
    Long totalInfectionRate();

    IPerson personTravelHistory(IPerson person);

    boolean setTravelPermission(IPerson person);

    void addPerson(IPerson person);

    void delPerson(IPerson person);
    
}
