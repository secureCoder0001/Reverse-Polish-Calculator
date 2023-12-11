package application;


/**
 * Class to represent calculator that performs calculations in infix notation.
 * 
 * @author Mohamed Mohamed
 * 
 */
public class StandardCalc implements Calculator {

  private RevPolishCalc revPolishCalc;
  
  /**
   * Constructs a Standard calc and initialises the underlying RevPolishCalc.
   */
  public StandardCalc() {
    revPolishCalc = new RevPolishCalc();
  }
  
  @Override
  public float evaluate(String expression) throws InvalidExpression {
    
    return this.revPolishCalc.evaluate(expression);
  }

}
