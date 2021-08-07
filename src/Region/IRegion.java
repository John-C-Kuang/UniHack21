package Region;

import Person.IPerson;

import java.util.List;
import java.util.Map;

/**
 * Represents a region such as District, City, Province, and Nation.
 */
public interface IRegion {

  String getName();

  List<IPerson> queryPopulation();

  boolean queryPerson(IPerson person);

  List<IRegion> querySubRegions();

  IRegion querySuperRegion();

  Map<IRegion, Integer> queryDistanceToRegions();

  EContainmentApproach queryApproach();

  void addPerson(IPerson person);

  IPerson deletePerson(IPerson person);
}
