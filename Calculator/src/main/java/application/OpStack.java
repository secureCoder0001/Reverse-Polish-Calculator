package application;


/**
 * A facade for stack to hide implementation details of stack for ease of use of operations.
 * 
 * @author Mohamed Mohamed
 *
 */
public class OpStack {

  private EntryStack stack;
  
  
  /**
   * Constructs and initialises a new OpStack.
   * 
   */
  public OpStack() {
    
    this.stack = new EntryStack(); 
  }
  
  /**
  * Returns the size of the OpStack.
  * 
  * @return the size of the stack.
  */
  public int size() {
    
    return this.stack.size();
  }

  /**
   * Pushes an operator onto the top of an OpStack instance.
   * 
   * @param symbol symbol to be pushed onto the stack.
   */
  public void push(Symbol symbol) { 
    
    this.stack.push(new Entry(symbol)); 
  }

  /**
   * Top method to return item at top of stack (without removing it).
   * 
   * @return item at top of stack.
   */
  public Symbol top() {
    
    try {
      return this.stack.top().getSymbol();
    } catch (BadTypeException e) {
      System.err.println();
    }
    
    return Symbol.INVALID;
  }

  /**
   * Method to return a symbol from the OpStack (if it exists) and remove it from said OpStack.
   * 
   * @return item popped from OpStack instance.
   */
  public Symbol pop() {
    
    try {
      return this.stack.pop().getSymbol();
    } catch (BadTypeException e) {
      System.err.println(); 
    }
    return Symbol.INVALID;
  }

  /**
   * Check if OpStack instance is empty. If so, return true, false otherwise.
   * 
   * @return boolean value indicating whether or not OpStack is empty.
   */
  public boolean isEmpty() {
    
    return this.stack.size() == 0;
  }  
    

  

}
