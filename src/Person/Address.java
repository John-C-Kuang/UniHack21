package Person;

import java.text.SimpleDateFormat;
import java.util.Date;

// To represent the tracking state of a passed location
public class Address {
  // Which location
  private String location;

  // The format to represent the date
  private SimpleDateFormat format;

  // Dates of coming and leaving
  public Date come;
  public Date leave;

  // The constructor
  public Address(String location) {
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
