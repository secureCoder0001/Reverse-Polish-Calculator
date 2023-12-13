package application;

import java.util.Scanner;

/**
 * Class to represent calculator that performs calculations in infix notation.
 * 
 * @author Mohamed Mohamed
 *
 */
public class StandardCalc implements Calculator {

  private RevPolishCalc revPolishCalc;
  private String output;
  private OpStack opStack;
  
  /**
   * Constructs a Standard calc and initialises the underlying RevPolishCalc.
   */
  public StandardCalc() {
    revPolishCalc = new RevPolishCalc();
  }
  
  /**
   * Method to determine if two operators have the same level of precedence.
   * 
   * @return number indicating level of precedence.
   */
  public int precedenceLevel(Symbol symbol) {
    
    if (symbol == Symbol.TIMES || symbol == Symbol.DIVIDE) {
      return 1;
    } else if (symbol == Symbol.PLUS || symbol == Symbol.MINUS) {
      return 2;
    }
    
    return 3;
  }

  /**
   * Evaluates expressoin in infix notation. Really, it converts the expression to 
   * reverse polish (postfix) notation (using the Shunting Yard Algorithm) and calls 
   * the evaluate method of the underlying RevPolishCalc instance.
   * 
   * @param expression string to be evaluated.
   * 
   * @return Result of the given expression.
   * 
   * @throws InvalidExpressionException If an invalid expression is entered.
   */
  @Override
  public float evaluate(String expression) throws InvalidExpression {
    
    opStack = new OpStack();
    output = "";
    Scanner scanner = new Scanner(expression);
    boolean expectNumber = true;
    
    while (scanner.hasNext()) {
      if (scanner.hasNextFloat() && expectNumber) {
        output += scanner.next() + " ";
        expectNumber = false;
      } else {      
        //expectNumber = true;
        String readItem = scanner.next(); // ith item read from expression
        Symbol topItem = Symbol.INVALID; 
        Symbol operator = Symbol.INVALID; 
        
        // For loop to check that 'readItem' is a valid symbol 
        Symbol[] validOperators = Symbol.values();
        for (int i = 0; i < validOperators.length; i++) { 
          if (validOperators[i].toString().equals(readItem)) {
            operator = validOperators[i];
            break;
          }
        }        
        if (operator == Symbol.INVALID) {
          throw new InvalidExpression("Invalid Symbol: Operator Expected");
        }
        
        expectNumber = true;
        
        // To get item at top of opStack instance
        if (!opStack.isEmpty()) {
          topItem = this.opStack.top();          
        }
        
        // Case when no brackets are encountered
        while ((topItem != Symbol.LEFT_BRACKET) 
            && (this.precedenceLevel(topItem) > this.precedenceLevel(operator)) 
            && (!this.opStack.isEmpty())) {
          
          this.output += this.opStack.pop().toString() + " ";                    
          
          if (this.opStack.isEmpty()) {
            break;
          }
         
          topItem = this.opStack.top();
        }        
        
        this.opStack.push(operator); 
        expectNumber = true;
      }
      
    }
    
    // Pop remaing items off stack (if any), and add them to the output by order of popping
    while (!opStack.isEmpty()) {
      this.output += opStack.pop() + " ";
    }
    
     
    return this.revPolishCalc.evaluate(output.trim()); 
  } 
}