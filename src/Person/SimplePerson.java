package Person;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

// To represent the tracking state of a passed location
class Address {
  // Which location
  String location;
  // The format to represent the date
  SimpleDateFormat format;
  // Dates of coming and leaving
  String come;
  String leave;

  // The constructor
  Address(String location) {
    this.location = location;
    this.format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    this.come = this.format.format(new Date());
    this.leave = null;
  }

  // To call the function when leaving
  void leave() {
    this.leave = this.format.format(new Date());
  }
}

// To represent common attributes to monitor an individual
public class Person {
  // Name components
  String last;
  String first;
  // Passed cities in the past 2 weeks
  ArrayList<Address> trip;
  // Current states
  // Vaccination statue (n - None, 1 - one dose, f - fully vaccinated)
  char vaccFlag;
  // Under quarantine or not
  boolean quarantine;
  // Covid-19 test result in the past 5 days (Positive/Negative, NULL)
  boolean testResult;
  // Physical attributes
  // float BMI;
  int age;
  // True - male, False - female
  boolean gender;

  // The constructor
  Person(String last, String first, ArrayList<Address> trip, char vaccFlag, boolean quarantine,
      boolean testResult, int age, boolean gender) {
    this.last = last;
    this.first = first;
    this.trip = trip;
    this.vaccFlag = vaccFlag;
    this.quarantine = quarantine;
    this.testResult = testResult;
    this.age = age;
    this.gender = gender;
  }
}
