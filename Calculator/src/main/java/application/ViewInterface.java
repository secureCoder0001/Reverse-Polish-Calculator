package application;

// You can use this file in your second assignment as is - or modify it to suit your code - in which
// case add another @author tag below mine
// DO NOT remove my @author tag

import java.util.function.Consumer;

/**
 * Any calculator view must implement these methods to allow the controller and the view to properly
 * work together.
 * 
 * @author Dave Cohen (d.cohen@rhul.ac.uk)
 * @author Mohamed Mohamed
 * 
 **/
public interface ViewInterface {
  
  /**
   * Observer method to be notified when a calculation is required.
   */
  void addCalculateObserver(Observer observer);
  
  /**
   * Observer method to be notified when a change in type preference has been selected/specified.
   */
  void addTypeObserver(Observer observer);

  /**
   * Observer method to be notified when a change to reset the calculator (buffer) is requested.
   */
  public void addResetObserver(Observer observer);
  
  /**
   * The controller can call this to find the current expression to be evaluated.
   * 
   * @return expression entered by the user.
   */
  String getExpression();
  
  /**
   * Method to get the type of notation to indicate expression notation to be used.
   * 
   * @return expression notation to be used.
   */
  public String getExpressionType();
  
  /**
   * The controller should call this to display the evaluated answer to the user.
   */
  void setAnswer(String a);

  /**
   * Activate the user interface - all systems are go. All buttons start disabled - the controller
   * calls this method once it is ready to start calculating.
   */
  public void startView();
}
