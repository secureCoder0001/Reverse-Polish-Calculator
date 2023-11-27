package application;

/**
 * Exception is created to be thrown when an Entry method is called by an inappropriate Entry type.
 *
 * @author Mohamed Mohamed
 * 
 */
public class BadTypeException extends Exception {
  
  
  private static final long serialVersionUID = -2256729445991102663L;
  
  
  /**
   * Constructs a BadTypeException with the specified message to be displayed.
   *
   * @param message the message to be displayed when an exception occurs.
   */
  public BadTypeException(String message) {

    super(message);
  }
}
