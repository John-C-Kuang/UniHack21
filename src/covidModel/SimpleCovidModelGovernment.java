package covidModel;

import Person.IPerson;
import Region.IRegion;

import java.util.ArrayList;
import java.util.List;

public class SimpleCovidModelGovernment implements ICovidModelGovernment {

  private List<ICovidModelCitizen> persons = new ArrayList<>();
  private List<IPerson> nameList;
  private IRegion region;

  public SimpleCovidModelGovernment(IRegion region) {

    this.nameList = region.queryPopulation();

    for (IPerson p : nameList) {
      persons.add(new SimpleCovidModelCitizen(p));
    }

    this.region = region;
  }

  @Override
  public String getCovidSituation() {
    String answer = "";
    List<Double> prs = new ArrayList<>();

    for (ICovidModelCitizen p : persons) {
      prs.add(p.getCovidProbability());
    }

    for (int i = 100; i > 0; i-=10) {

      answer = answer + "probability: " + Double.toString(i/100.0) + "  ->  " +
              "numbers: " + count(prs, i / 100.0, (i - 10) / 100.0)
      + "\\n";
    }

    return answer;
  }

  @Override
  public List<IRegion> queryTravelHistory(long id) {
    /*
    for (IPerson p : nameList) {
      if (p.queryID == id) {
        return p.queryTravelHistory();
      }
    }

    throw new IllegalArgumentException("Cannot find the person!"); */

    return null;
  }

  @Override
  public IPerson queryPersonalInformation(long id) {
    /*
    for (IPerson p : nameList) {
      if (p.queryID == id) {
        return p;
      }
    }

    throw new IllegalArgumentException("Cannot find the person!"); */

    return null;
  }

  private int count(List<Double> prs, double upperBound, double lowerBound) {
    int c = 0;

    for (double d : prs) {
      if (d < lowerBound && d >= upperBound) {
        c = c + 1;
      }
    }

    return c;
  }
}
