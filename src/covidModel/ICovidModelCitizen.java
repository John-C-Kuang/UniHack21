package covidModel;

import Region.IRegion;

import java.util.ArrayList;
import java.util.List;

public interface ICovidModelCitizen extends ICovidModel {

  void updateTravelHistory(ArrayList<IRegion> regions);

  void updatePhysicalCondition(ArrayList<Boolean> info);

  List<IRegion> queryTravelingHistory();

  double getCovidProbability();
}
