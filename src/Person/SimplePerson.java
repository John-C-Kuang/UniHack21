package Person;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.io.File;

// To represent common attributes to monitor an individual
public class SimplePerson implements IPerson {
  // Personal ID
  private long id;
  // Name components
  private String last;
  private String first;
  // Passed cities in the past 2 weeks
  private List<Address> travelHistory;
  // If have direct contact with confirmed/possible COVID-19 patient
  private boolean confirmed;
  // List of current have/n't symptoms in sequence
  /*
   * - Cough 
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
  private List<Boolean> symptoms;
  // Current states
  // If the person is fully vaccinated
  private boolean fullVacc;
  // Under quarantine or not
  private boolean quarantine;
  // Covid-19 test result in the past 5 days (Positive/Negative, NULL)
  private boolean testResult;
  // Physical attributes
  // String HealthCondition;
  // float BMI;
  private int age;

  // True - male, False - female
  private String gender;

  // The constructor
  SimplePerson(long id, String last, String first, List<Address> travelHistory,
      boolean confirmed, List<Boolean> symptoms, boolean fullVacc, boolean quarantine,
      boolean testResult, int age, String gender) {
    this.id = id;
    this.last = last;
    this.first = first;
    this.travelHistory = travelHistory;
    this.confirmed = confirmed;
    this.symptoms = symptoms;
    this.fullVacc = fullVacc;
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
  public List<Address> getTravelHistory() {
    return this.travelHistory;
  }

  // If the person had contact with confirmed patient
  public boolean isConfirmed() {
    return this.confirmed;
  }

  // Get list of current have/n't symptoms
  public List<Boolean> getSymptoms() {
    return this.symptoms;
  }

  // Current states
  // Get vaccination statue (n - None, 1 - one dose, f - fully vaccinated)
  public boolean isFullyVaccinated() {
    return this.fullVacc;
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
  public String getGender() {
    return this.gender;
  }

 //Add to travel history
 public void addLocation(Address that) {
   this.travelHistory.add(that);
 }
 // Change if contacted with confirmed Covid-19 patient
 public void confirmedContact() {
   this.confirmed = true;
 }
 // Change current symptoms for generating diagnosis
 public void setSymptoms(List<Boolean> symptoms) {
   this.symptoms = symptoms;
 }
 // Change after fully vaccinated
 public void fullyVacced() {
   this.fullVacc = true;
 }
 // Change if current quarantine status
 public void setQuarantine() {
   if (this.quarantine) {
     this.quarantine = false;
   }
   else {
     this.quarantine = true;
   }
 }
 // Change if the person received Covid-19 test result
 public void setResult(boolean result) {
   this.testResult = result;
 }
  
  // Update the traveled city list by time
  public void updateHistory() {
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

  // Get the possibility of Covid-19 diagnosis result [Bayes]
  public double getDiagnosis() {
    // Positive result from Naive Baysian
    double pos;
    // Negative result from Naive Baysian
    double neg;

    if (confirmed) {
      pos = Reference.PR_POS_CONFIRM;
      neg = Reference.PR_NEG_CONFIRM;
    } else {
      pos = Reference.PR_POS_POSSIBLE;
      neg = Reference.PR_NEG_POSSIBLE;
    }

    for (int i = 0; i < this.symptoms.size(); i++) {
      if (this.symptoms.get(i)) {
        pos *= Reference.PR_POS_SYMPTOMS.get(i);
        neg *= 1 - Reference.PR_NEG_SYMPTOMS.get(i);
      } else {
        pos *= 1 - Reference.PR_POS_SYMPTOMS.get(i);
        neg *= Reference.PR_NEG_SYMPTOMS.get(i);
      }
    }

    double initialDiagnosis = pos / (pos + neg);

    if (this.fullVacc) {
      return (1 - Reference.VACC_EFFICIENCY) * initialDiagnosis;
    } else {
      return initialDiagnosis;
    }
  }
  
  @Override
  public String toString() {
    return "Name" + getLastname() + getFirstname() 
          + "ID"  + getPersonalID()    
          + "Age" + getAge()
          + "Gender" + getGender()
          + "testResult" + getTestResult()
          + "vaccinated?" + isFullyVaccinated()
        + "Symptons" + printArrList(getSymptoms())
        + "\n";
  }

  public <T> String printArrList(List<T> printingArrList) {
    String returnedString = "";
    for (int i = 0; i < printingArrList.size(); i++) {
      returnedString += printingArrList.get(i);
    }
    return returnedString;
  }

  public String travelHistoryToString() {
    return "Name: " + getFirstname() + getLastname() + "Travel History: " + printArrList(getTravelHistory()) + "\n";
  }
}
