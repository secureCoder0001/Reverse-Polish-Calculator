package application;

/**
 * Class to abstract away from the repective posfix (Reverse Polish) and infix calculators. 
 * Provides one class to represent the notion of a calculator.
 * 
 * @author Mohamed Mohamed
 * 
 */
public class CalcModel {
  
  private Calculator reversePolish;
  private Calculator standard;
  private float memory;
  

  /**
   * Constructs a CalcModel and initialises the two underlying different calculators: 
   * RevPolishCalc and StandardCalc.
   * 
   */
  public CalcModel() {
    this.reversePolish = new RevPolishCalc();
    this.standard = new StandardCalc();
    memory = 0.0f;
  }
  
  // Consider a second parameter, Boolean infix
  
  /**
   * An absstraction of both the reverse polish (postfix) and infix expressions.
   * 
   * @param expression the string to be evaluated.
   * @param infix an assertion, of sorts, by the user indicating that the expression 
   *     is in a particular notation. Of course, this is not neccessarily true.
   * @return the calculated expression evaluated in either infix or postfix notation
   */
  public float evaluate(String expression, boolean infix) throws InvalidExpression {
    
    if (infix) {
      memory = this.standard.evaluate(expression);
      return memory;
    }    
    
    memory = this.reversePolish.evaluate(expression);
    return memory;
  }
  
  /**
   * Method to access memory of either calculator and return last calculated result.
   * 
   * @return result of last calculation.
   */
  public float getLastResult() {
    
    return this.memory;
  }
}
