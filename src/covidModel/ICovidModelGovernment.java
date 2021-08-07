package covidModel;

import Person.Address;
import Person.IPerson;

import java.util.List;

public interface ICovidModelGovernment extends ICovidModel {

  String getCovidSituation();

  List<Address> queryTravelHistory(long id);

  IPerson queryPersonalInformation(long id);

}
