package application;

import java.util.Scanner;

/**
 * Class to represent calculator that performs calculations in reverse polish notation.
 * 
 * @author Mohamed Mohamed
 *
 */
public class RevPolishCalc {

  private NumStack expressStack;
  
  /**
   * Contstructs a new numstack to store the operands of calculation input.
   */
  public RevPolishCalc() {
    this.expressStack = null;
  }

  
  
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
        

    this.expressStack = new NumStack();
    Scanner input = new Scanner(calcInput);
    Symbol operator = Symbol.INVALID;
    float result;
    
    try {
      while (input.hasNext()) {
        if (input.hasNextFloat()) {
          this.expressStack.push(input.nextFloat());
        } else {         
          String token = input.next();
          Symbol[] possibleOperations = Symbol.values();
          
          Symbol ithOperator;
          for (int i = 0; i < possibleOperations.length; i++) {
            ithOperator = possibleOperations[i];
            
            if (ithOperator.toString().equals(token)) {
              operator = ithOperator;
              break;
            }
          }
          
          if (operator == Symbol.PLUS) {
            float tempResult = this.expressStack.pop() + this.expressStack.pop(); 
            this.expressStack.push(tempResult);
          } else if (operator == Symbol.DIVIDE) {
            float rightOperand = this.expressStack.pop();
            float leftOperand = this.expressStack.pop();
             
            if (rightOperand == 0) {
              throw new InvalidExpression("Divide By Zero Undefined");
            }            
            this.expressStack.push(leftOperand / rightOperand);
          }
           
        }
      }
      
      input.close();
      result = this.expressStack.pop();
      
    } catch (Exception e) {
      throw new InvalidExpression("Incorrect Expression");
    }
    
    
    
    
    
    
    
    
    
    return result;
  }
  
}
