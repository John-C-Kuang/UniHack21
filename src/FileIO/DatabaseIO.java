package databaseManager;

import java.io.*;

public class DatabaseIO implements IDbManager {
  // Target reading file path
  String filePath;
  // Flag for file manipulation
  char flag;
  // FileReader object
  FileReader fr;

  // Constant
  public static final String DB_PATH = ""; // Finish this database path

  DatabaseIO() {
    this.filePath = "NULL";
    this.flag = '-';
    this.fr = null;
  }

  // Set target file path and flag
  public void setFile(String filePath, char flag) {
    try {
      this.filePath = filePath;
      this.fr = new FileReader(filePath);
    }
    catch (IOException e) {
      // Exception message
    }

    this.flag = flag;
  }

  // Append to the file content
  public void append(String line) {
    try {
      FileWriter fw = new FileWriter(filePath, true);
      fw.write(line + '\n');
      fw.flush();
      fw.close();
    }
    catch (IOException e) {
      // Exception message
    }
  }

  // Match personal data by name
  public String[] matchName(String name) {
    BufferedReader br = new BufferedReader(fr);
    String line;

    try {
      while ((line = br.readLine()) != null) {
        String[] curr = line.split("/");
        String currName = curr[0];
        if (currName == name) {
          return curr;
        }
      }
    }
    catch (IOException e) {
      // Exception message
    }

    return null;
  }
  
  // match personal data by id
  public String[] matchId(long id) {
    BufferedReader br = new BufferedReader(fr);
    String line;

    try {
      while ((line = br.readLine()) != null) {
        String[] curr = line.split("/");
        String currId = curr[1];
        if (currId == Long.toString(id)) {
          return curr;
        }
      }
    }
    catch (IOException e) {
      // Exception message
    }

    return null;
  }
  
  // Overwrite the whole database
  public void write(String line) {
    try {
      FileWriter fw = new FileWriter(filePath);
      fw.write(line + '\n');
      fw.flush();
      fw.close();
    }
    catch (IOException e) {
      // Exception message
    }
  }
}
