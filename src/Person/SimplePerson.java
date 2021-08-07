package Person;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

// To represent the tracking state of a passed location
class Address {
  // Which location
  String location;
  // The format to represent the date
  SimpleDateFormat format;
  // Dates of coming and leaving
  Date come;
  Date leave;

  // The constructor
  Address(String location) {
    this.location = location;
    this.format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    this.come = new Date();
    this.leave = null;
  }

  // To call the function when leaving
  void leave() {
    this.leave = new Date();
  }

  // To get the date of coming
  String getCome() {
    return this.format.format(this.come);
  }

  // To get the date of leaving
  String getLeave() {
    if (this.leave != null) {
      return this.format.format(this.leave);
    }
    else {
      return "NOW";
    }
  }
}

// To represent common attributes to monitor an individual
public class SimplePerson implements IPerson {
  // Personal ID
  long id;
  // Name components
  String last;
  String first;
  // Passed cities in the past 2 weeks
  ArrayList<Address> travelHistory;
  // If have direct contact with confirmed/possible COVID-19 patient
  boolean confirmed;
  boolean possible;
  // List of current have/n't symptoms in sequence
  /* - Cough
   * - Fatigue
   * - Fever
   * - Myalgias
   * - Loss of taste
   * - Sore throat
   * - Loss of smell
   * - Diarrhea
   * - Chills/sweats
   * - Dyspnea
   * - Temperature > 38 C
   * - Headache
   * - Nasal congestion
   * - Nonproductive cough
   */
  ArrayList<Boolean> symptoms;
  // Current states
  // Vaccination statue (n - None, 1 - one dose, f - fully vaccinated)
  char vaccFlag;
  // Under quarantine or not
  boolean quarantine;
  // Covid-19 test result in the past 5 days (Positive/Negative, NULL)
  boolean testResult;
  // Physical attributes
    // String HealthCondition; (高血压/既往慢性病史..); 用于      
    // float BMI;
    int age;
  
  // True - male, False - female
  boolean gender;

  // The constructor
   /**
   * 定义一个人对象，人对象包含个人的基本信息，生理状况及旅行记录，用于预测其危险系数
   * 
   * @param last        姓
   * @param first       名
   * @param age         年龄
   * @param trip        旅行记录
   * @param symptons    症状
   * @param vaccFlag    疫苗接种情况
   * @param quarantine  是否正在隔离
   * @param testResult  检测记录
   * 
   */
  SimplePerson(long id, String last, String first, ArrayList<Address> travelHistory,
      ArrayList<Boolean> symptoms, char vaccFlag, boolean quarantine, boolean testResult, int age,
      boolean gender) {
    this.id = id;
    this.last = last;
    this.first = first;
    this.travelHistory = travelHistory;
    this.symptoms = symptoms;
    this.vaccFlag = vaccFlag;
    this.quarantine = quarantine;
    this.testResult = testResult;
    this.age = age;
    this.gender = gender;
  }

//Get personal ID
  public long getPersonalID() {
    return this.id;
  }

  // Get name components
  public String getLastname() {
    return this.last;
  }

  public String getFirstname() {
    return this.first;
  }

  // Get travel history in the past 2 weeks
  public ArrayList<Address> getTravelHistory() {
    return this.travelHistory;
  }
  
  // If the person had contact with confirmed/possible patient
  public boolean isConfirmed() {
    return this.confirmed;
  }
  
  public boolean isPossible() {
    return this.possible;
  }

  // Get list of current have/n't symptoms
  public ArrayList<Boolean> getSymptoms() {
    return this.symptoms;
  }

  // Current states
  // Get vaccination statue (n - None, 1 - one dose, f - fully vaccinated)
  public char getVaccFlag() {
    return this.vaccFlag;
  }

  // Get under quarantine or not
  public boolean isQuarantine() {
    return this.quarantine;
  }

  // Get Covid-19 test result in the past 5 days (Positive/Negative, NULL)
  public boolean getTestResult() {
    return this.testResult;
  }

  // Physical attributes
  // Get person age
  public int getAge() {
    return this.age;
  }

  // True - male, False - female
  // Get person gender
  public boolean getGender() {
    return this.gender;
  }

  // Update the traveled city list by time
  void updateTrip() {
    for (int i = 0; i < this.travelHistory.size(); i++) {
      Address curr = this.travelHistory.get(i);
      if (curr.leave != null) {
        int diffDay = (int) ((new Date().getTime() - curr.leave.getTime()) / (1000 * 60 * 60 * 24))
            % 365;
        if (diffDay > 14) {
          this.travelHistory.remove(i);
        }
      }
    }
  }
  
  // Get the possibility of Covid-19 diagnosis result
  double getDiagnosis() {
    return 0;
  }
}
