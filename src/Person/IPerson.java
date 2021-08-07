package Person;

import java.util.ArrayList;

public interface IPerson {
  // FIELDS

  // Get personal ID
  long getPersonalID();

  // Get name components
  String getLastname();

  String getFirstname();

  // Get travel history in the past 2 weeks
  ArrayList<Address> getTravelHistory();
  
  // If the person had contact with confirmed/possible patient
  boolean isConfirmed();
  boolean isPossible();

  // Get list of current have/n't symptoms
  ArrayList<Boolean> getSymptoms();

  // Current states
  // Get vaccination statue (n - None, 1 - one dose, f - fully vaccinated)
  char getVaccFlag();

  // Get under quarantine or not
  boolean isQuarantine();

  // Get Covid-19 test result in the past 5 days (Positive/Negative, NULL)
  boolean getTestResult();

  // Physical attributes
  // Get person age
  int getAge();

  // True - male, False - female
  // Get person gender
  boolean getGender();

  // METHOD

  // getters
  // ?contactPatients
  // ?beenToDangerousCities

  // level of access to different activities
}
