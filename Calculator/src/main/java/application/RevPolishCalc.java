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

    if (calcInput.length() == 1) {      
      float result = Float.valueOf(calcInput);
      return result;
    }    
    
    // To capture when only two values are entered. 
    // That is, a value, followed by a space and finally, followed further by another value
    if (calcInput.length() == 3) { 
      throw new InvalidExpression("Unbalanced Expression");
    }
        
    return 1;
  }
  
}
