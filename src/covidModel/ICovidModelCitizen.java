package covidModel;

import Region.IRegion;

import java.util.ArrayList;
import java.util.List;

import Person.IPerson;

public interface ICovidModelCitizen extends ICovidModel {

  void updateTravelHistory(ArrayList<IRegion> regions);

  void updatePhysicalCondition(ArrayList<Boolean> info);

  List<IRegion> queryTravelingHistory();

  double getCovidProbability();

  IPerson getPerson();
}
