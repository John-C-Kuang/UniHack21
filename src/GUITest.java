import Person.Address;
import Person.IPerson;
import Person.SimplePerson;
import Region.EContainmentApproach;
import Region.IRegion;
import Region.SimpleRegion;
import covidController.ICovidControllerGovernment;
import covidController.SimpleCovidControllerGovernment;
import covidModel.ICovidModelGovernment;
import covidModel.SimpleCovidModelGovernment;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import view.gov.IGovernmentGUIView;
import view.gov.SimpleGovernmentGUI;
import view.user.SimpleUserGUIView;

public class GUITest {

  public static void main(String[] args) {
//    new SimpleGovernmentGUI(null);
    Address addr1 = new Address("Beijing");
    Address addr2 = new Address("Shanghai");
    IPerson person1 = new SimplePerson(001, "Kuang", "Chengyi",
        new ArrayList<>(Arrays.asList(addr1, addr2)), false, new ArrayList<>(),
        true, false, false, 20, "Male");
    Map<IRegion, Integer> map1 = new HashMap<>();
    IRegion simpleRegion1 = new SimpleRegion(new ArrayList<>(
        Arrays.asList(person1)), null, null, map1, EContainmentApproach.MILD);
    ICovidModelGovernment gov1 = new SimpleCovidModelGovernment(simpleRegion1);
    ICovidControllerGovernment cont1 = new SimpleCovidControllerGovernment(gov1, null);
    IGovernmentGUIView guiGov = new SimpleGovernmentGUI((ActionListener) cont1, gov1);
    cont1.setView(guiGov);

  }

}
