package view.user;

public interface IUserGUiView {

  void showPopUp(String message) throws IllegalArgumentException;

  void getNotified(String actionName);

}
