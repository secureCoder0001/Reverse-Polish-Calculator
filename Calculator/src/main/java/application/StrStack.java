package application;

/**
 * A facade for stack to hide implementation details of stack for ease of use of strings.
 * 
 * @author Mohamed Mohamed
 *
 */
public class StrStack {
  
  private EntryStack strStack;
  
  /**
   * Constructs and initialises a new StrStack.
   * 
   */
  public StrStack() {
    
    this.strStack = new EntryStack(); 
  }
  
  /**
  * Returns the size of the StrStack instance.
  * 
  * @return the size of the stack.
  */
  public int size() {
    
    return this.strStack.size(); 
  }

  /**
   * Pushes a string onto the top of a StrStack instance.
   * 
   * @param strValue string value to be pushed onto the stack.
   */
  public void push(String strValue) { 
    
    this.strStack.push(new Entry(strValue));
  }

  /**
   * Top method to return item at top of stack (without removing it).
   * 
   * @return item at top of stack.
   */
  public String top() {
    
    try {
      return this.strStack.top().getString();
    } catch (BadTypeException e) {
      System.err.println();
    }
    
    return null;
  }

  /**
   * Method to return a string value from StrStack (if it exists) and remove it from said StrStack.
   * 
   * @return item popped from StrStack instance.
   */
  public String pop() {
    
    try {
      return this.strStack.pop().getString();
    } catch (BadTypeException e) {
      System.err.println(); 
    }
    return null;
  }

  /**
   * Check if StrStack instance is empty. If so, return true, false otherwise.
   * 
   * @return boolean value indicating whether or not StrStack is empty.
   */
  public boolean isEmpty() {
    
    return this.strStack.size() == 0;
  }  
  
  
}
