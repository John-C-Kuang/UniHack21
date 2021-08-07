package view.gov;

/**
 * The Interface of a gui designed for governmental use. Allows visualization
 */
public interface IGovernmentGUIView {

  void showPopUp(String message) throws IllegalArgumentException;

  void getNotified(String actionName);

  String showInteractivePopup(String question);

}
