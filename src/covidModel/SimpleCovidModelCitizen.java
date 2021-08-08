package covidModel;

import Person.Address;
import Person.IPerson;
import Region.IRegion;

import java.util.ArrayList;
import java.util.List;

public class SimpleCovidModelCitizen implements ICovidModelCitizen {

  private IPerson person;
  private double probability;

  public SimpleCovidModelCitizen(IPerson person) {
    this.person = person;
    this.probability = 0;
  }

  @Override
  public IPerson getPerson() {
    return this.person;
  }

  @Override
  public void updateTravelHistory(IRegion region) {
    if (this.person.isQuarantine()) {
      throw new IllegalStateException("The person is in quarantine!");
    }

    if (region == null) {
      throw new IllegalArgumentException("No new travel history!!!");
    }

    this.person.addLocation(new Address(region.getName()));

    updatePr();
  }

  @Override
  public void updatePhysicalCondition(Boolean isQ, Boolean fullyV, Boolean isContact,
                                      List<Boolean> info) {
    if (isQ) {
      this.person.isQuarantine();
    }

    if (fullyV) {
      this.person.fullyVacced();
    }

    if (isContact) {
      this.person.confirmedContact();
    }

    person.setSymptoms(info);

    updatePr();
  }

  @Override
  public List<Address> queryTravelingHistory() {
    return person.getTravelHistory();
  }

  @Override
  public double getCovidProbability() {
    return this.probability;
  }

  public void updatePr() {
    probability = this.person.getDiagnosis();
  }
}
