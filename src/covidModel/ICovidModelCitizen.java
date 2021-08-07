package covidModel;

import Person.Address;
import Person.IPerson;
import Region.IRegion;

import java.util.ArrayList;
import java.util.List;

public interface ICovidModelCitizen extends ICovidModel {

  IPerson getPerson();

  void updateTravelHistory(IRegion regions);

  void updatePhysicalCondition(Boolean isQ, Boolean fullyV, Boolean isContact,
                               List<Boolean> info);

  List<Address> queryTravelingHistory();

  double getCovidProbability();

  public void updatePr();
}
