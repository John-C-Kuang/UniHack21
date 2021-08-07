package Region;

import Person.IPerson;

import java.util.List;
import java.util.Map;

public class SimpleRegion extends AbstractRegion {
  /**
   * Constructor of AbstractRegion.
   *
   * @param population
   * @param subRegions
   * @param superRegion
   * @param distanceToRegions
   * @param approach
   * @throws IllegalArgumentException if any argument is invalid
   */
  public SimpleRegion(List<IPerson> population, List<IRegion> subRegions, IRegion superRegion, Map<IRegion, Integer> distanceToRegions, EContainmentApproach approach) {
    super(population, subRegions, superRegion, distanceToRegions, approach);
  }

  @Override
  public IRegion querySuperRegion() {
    if (this.superRegion == null) {
      return null;
    }

    return new SimpleRegion(this.superRegion.queryPopulation(),
        this.superRegion.querySubRegions(), this.superRegion.querySuperRegion(),
        this.superRegion.queryDistanceToRegions(), this.superRegion.queryApproach());

  }
}
