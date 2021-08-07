package covidModel;

import Person.IPerson;
import Region.IRegion;

import java.util.List;

public interface ICovidModelGovernment extends ICovidModel {

  String getCovidSituation();

  List<IRegion> queryTravelHistory(long id);

  IPerson queryPersonalInformation(long id);

}
