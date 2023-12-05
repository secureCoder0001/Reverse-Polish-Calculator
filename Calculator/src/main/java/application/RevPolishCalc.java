package application;

/**
 * Class to represent calculator that performs calculations in reverse polish notation.
 * 
 * @author Mohamed Mohamed
 *
 */
public class RevPolishCalc {

  /**
   * Method calculates calculated given input using the reverse polish/postfix notation.
   * 
   * @param calcInput string to be evaluated.
   * @return result of the calculation in the form of a float.
   */
  public float evaluate(String calcInput) throws InvalidExpression {
    
    if (calcInput.equals("")) {
      throw new InvalidExpression("An empty string cannot be evaluated.");
    }
    
    return 1;
  }

}
