package application;

/**
 * An expression was passed to a method that could not be evaluated.
 */

@SuppressWarnings("serial")
public class InvalidExpression extends Exception {

  /**
   * Method inherited from super class, 'Exception'. Displays error message. 
   * 
   * @param message message displayed when exception is thrown
   */
  public InvalidExpression(String message) {
    super(message);
  
  }

  
}