import Person.Address;
import Person.IPerson;
import Person.SimplePerson;
import Region.EContainmentApproach;
import Region.IRegion;
import Region.SimpleRegion;
import covidController.ICovidControllerCitizen;
import covidController.ICovidControllerGovernment;
import covidController.SimpleCovidControllerCitizen;
import covidController.SimpleCovidControllerGovernment;
import covidModel.ICovidModelCitizen;
import covidModel.ICovidModelGovernment;
import covidModel.SimpleCovidModelCitizen;
import covidModel.SimpleCovidModelGovernment;
import java.awt.event.ActionListener;
import java.util.*;

import view.gov.IGovernmentGUIView;
import view.gov.SimpleGovernmentGUI;
import view.user.IUserGUiView;
import view.user.SimpleUserGUIView;

public class GUITest {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String command = scan.nextLine();

    if (command.equals("citizen")) {
      Address addr1 = new Address("Beijing");
      Address addr2 = new Address("Shanghai");
      IPerson person1 = new SimplePerson(001, "Duang", "hengji",
              new ArrayList<>(Arrays.asList(addr1, addr2)), false,
              new ArrayList<>(Arrays.asList(false, false, false, false, false, false,
                      false, false, false, false, true, false, true, true)),
              false, false, false, 20, "Male");
      ICovidModelCitizen userModel = new SimpleCovidModelCitizen(person1);
      ICovidControllerCitizen userContr = new SimpleCovidControllerCitizen(userModel, null);
      IUserGUiView userGui = new SimpleUserGUIView((ActionListener) userContr, userModel);
      userContr.setView(userGui);
    } else if (command.equals("government")) {
      Address addr1 = new Address("Beijing");
      Address addr2 = new Address("Shanghai");
      IPerson person1 = new SimplePerson(001, "Duang", "hengki",
              new ArrayList<>(Arrays.asList(addr1, addr2)), false, new ArrayList<>(),
              true, false, false, 20, "Male");
      Map<IRegion, Integer> map1 = new HashMap<>();
      IRegion simpleRegion1 = new SimpleRegion(new ArrayList<>(
              Arrays.asList(person1)), null, null, map1,
              EContainmentApproach.MILD);
      ICovidModelGovernment gov1 = new SimpleCovidModelGovernment(simpleRegion1);
      ICovidControllerGovernment cont1 = new SimpleCovidControllerGovernment(gov1, null);
      IGovernmentGUIView guiGov = new SimpleGovernmentGUI((ActionListener) cont1, gov1);
      cont1.setView(guiGov);
    }
  }

}
