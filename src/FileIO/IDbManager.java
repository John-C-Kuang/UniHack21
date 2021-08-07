package FileIO;

public interface IDbManager {
  // Assignment the target file for database storage
  // Flag : r - Read, w - Write, a - Append
  void setFile(String filePath, char flag);
  // Append new information to the file
  void append(String line);
  // Match personal data by name
  String[] matchName(String name);
  // Match personal data by id
  String[] matchId(long id);
  // Overwrite the whole database
  void write(String line);
}
