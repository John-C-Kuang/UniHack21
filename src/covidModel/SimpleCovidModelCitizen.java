package covidModel;

import Person.IPerson;
import Region.IRegion;

import java.util.ArrayList;
import java.util.IllegalFormatWidthException;
import java.util.List;

public class SimpleCovidModelCitizen implements ICovidModelCitizen {

  private IPerson person;
  private double probability;

  public SimpleCovidModelCitizen(IPerson person) {
    this.person = person;
    this.probability = 0;
  }

  @Override
  public void updateTravelHistory(ArrayList<IRegion> regions) {
    /* if (this.person.isQuarantine) {
    *    throw new IllegalStateException("The person is in quarantine!");
    *  } */

    if (regions == null) {
      throw new IllegalArgumentException("No new travel history!!!");
    }

    // this.person.updateTravelHistory(regions);

    updatePr();
  }

  @Override
  public void updatePhysicalCondition(ArrayList<Boolean> info) {
    // person.updatePhysicalCondition(info);

    updatePr();
  }

  public String queryMedicalAdvice() {
    if (probability > 1.0) {
      throw new IllegalArgumentException("Illegal data!!");
    }

    if (probability >= 0.9) {
      return "";
    } else if (probability >= 0.7) {

    } else if (probability >= 0.5) {

    } else if (probability >= 0.3) {

    } else if (probability >= 0) {

    }

    throw new IllegalArgumentException("Probability cannot less than 0!!");
  }

  @Override
  public List<IRegion> queryTravelingHistory() {
    // return person.queryTravelHistory;
    return null;
  }

  public boolean queryTravelPermission() {
    if (probability > 0.4) {
      return false;
    }

    return true;
  }

  @Override
  public double getCovidProbability() {
    return this.probability;
  }

  private void updatePr() {

  }
}
