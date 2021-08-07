package Region;

import Person.IPerson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class for the IRegion Interface. This class extracts commonalities between classes
 * that implements methods in the IRegion Interface.
 */
public abstract class AbstractRegion implements IRegion {
  protected List<IPerson> population;
  protected List<IRegion> subRegions;
  protected IRegion superRegion;
  protected Map<IRegion, Integer> distanceToRegions;
  protected EContainmentApproach approach;

  /**
   * Constructor of AbstractRegion.
   *
   * @throws IllegalArgumentException if any argument is invalid
   */
  public AbstractRegion(List<IPerson> population,
      List<IRegion> subRegions, IRegion superRegion,
      Map<IRegion, Integer> distanceToRegions, EContainmentApproach approach) {

    if (population == null || subRegions == null || superRegion == null || approach == null) {
      throw new IllegalArgumentException("Invalid parameter passed");
    }

    this.population = population;
    this.subRegions = subRegions;
    this.superRegion = superRegion;
    this.distanceToRegions = distanceToRegions;
    this.approach = approach;
  }


  @Override
  public List<IPerson> queryPopulation() {
    return new ArrayList<>(this.population);
  }

  @Override
  public boolean queryPerson(IPerson person) {
    return population.contains(person);
  }

  @Override
  public List<IRegion> querySubRegions() {
    return new ArrayList<>(this.subRegions);
  }


  // hou mian zai override
  @Override
  public IRegion querySuperRegion() {
    if (this.superRegion == null) {
      return null;
    }

    /*
    return new AbstractRegion(this.superRegion.queryPopulation(),
            this.superRegion.querySubRegions(), this.superRegion.querySuperRegion(),
            this.superRegion.queryDistanceToRegions(), this.superRegion.queryApproach());*/
    return null;
  }

  @Override
  public Map<IRegion, Integer> queryDistanceToRegions() {
    return new HashMap<>(this.distanceToRegions);
  }

  @Override
  public EContainmentApproach queryApproach() {
    return this.approach;
  }

  @Override
  public void addPerson(IPerson person) {
    this.population.add(person);
  }

  @Override
  public IPerson deletePerson(IPerson person) {
    if (population.contains(person)) {
      population.remove(person);
    } else {
      throw new IllegalArgumentException("Cannot find this person!!!!!!!");
    }

    return person;
  }
}
