package covidController;

import Person.IPerson;
import covidModel.ICovidModelCitizen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleCovidControllerCitizen implements ICovidControllerCitizen {
  ICovidModelCitizen model;
  IPerson person;
  Double pr;

  public SimpleCovidControllerCitizen(ICovidModelCitizen model) {
    this.model = model;
    this.person = model.getPerson();
    this.pr = model.getCovidProbability();
  }

  @Override
  public String queryPersonalInformation() {
    return person.toString();
  }

  @Override
  public String queryTravelHistory() {
    return person.travelHistoryToString();
  }

  @Override
  public String queryAdvice() {
    double pr = model.getCovidProbability();

    if (pr > 0.9) {
      return "Please go to ICU";
    } else if (pr > 0.7) {
      return "Please go to hospital";
    } else if (pr > 0.5) {
      return "Please stay at home for 2 week";
    } else if (pr > 0.3) {
      return "Please be careful!";
    }

    return "you are safe!";
  }

  @Override
  public String queryPermission() {
    double pr = model.getCovidProbability();

    if (pr > 0.5) {
      return "veto";
    } else {
      return "confirm";
    }
  }

  @Override
  public void registerInformation(String str) {
    List<String> strs = Arrays.asList(str.split(" "));
    List<Boolean> allInput = new ArrayList<>();
    List<Boolean> symptoms = new ArrayList<>();

    for (String s : strs) {
      allInput.add(stringToBoolean(s));
    }

    for (int i = 2; i < allInput.size(); i++) {
      symptoms.add(allInput.get(i));
    }

    model.updatePhysicalCondition(allInput.get(0), allInput.get(1), allInput.get(2),
            symptoms);

    model.updatePr();

    this.pr = model.getCovidProbability();
  }

  private boolean stringToBoolean(String str) {
    if (str.equals("true") || str.equals("yes")) {
      return true;
    } else if (str.equals("false") || str.equals("no")) {
      return false;
    }

    throw new IllegalArgumentException("Illegal input.");
  }
}
