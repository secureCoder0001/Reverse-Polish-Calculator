package application;

/**
 * An enum to represent the different symbols in a calculator and to document their meaning.
 *
 * @author Mohamed Mohamed
 * 
 */
public enum Symbol {
  
  
  // The different descriptors of the symbols associated with the calculator  
  
  /**
   * Creates an a constant associating 'Left Bracket' with "(".
   */
  LEFT_BRACKET("("),
    
  
  /**
   * Creates a constant associating 'Right Bracket' with ")".
   */
  RIGHT_BRACKET(")"),

  
  /**
   * Creates a constant associating 'TIMES' with "*".
   */
  TIMES("*"),


  /**
   * Creates a constant associating 'DIVIDE' with "/".
   */
  DIVIDE("/"),


  /**
   * Creates a constant associating 'PLUS' with "+".
   */
  PLUS("+"),


  /**
   * Creates a constant associating 'MINUS' with "-".
   */
  MINUS("-"),


  /**
   * Creates a constant associating 'INVALID' with the value "N/A".
   */
  INVALID("N/A");


  // Where the assciated symbol ('+, '/', '*' etc.) will be stored.
  String symbol;

  // Associates a symbol with a descriptor.
  private Symbol(String symbol) {

    this.symbol = symbol;
  }

  @Override
  public String toString() {

    return this.symbol;
  }  
  
}
