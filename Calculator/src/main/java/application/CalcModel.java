package application;

/**
 * Class to abstract away from the repective posfix (Reverse Polish) and infix calculators. 
 * Provides one class to represent the notion of a calculator.
 * 
 * @author Mohamed Mohamed
 * 
 */
public class CalcModel {
  
  // Consider a second parameter, Boolean infix
  
  /**
   * An absstraction of both the reverse polish (postfix) and infix expressions.
   * 
   * @param expression the string to be evaluated.
   * @param isInfix an assertion, of sorts, by the user indicating that the expression 
   *     is in a particular notation. Of course, this is not neccessarily true.
   * @return the calculated expression evaluated in either infix or postfix notation
   */
  public float evaluate(String expression, boolean isInfix) throws InvalidExpression {
    return 18.0f;
  }
}
