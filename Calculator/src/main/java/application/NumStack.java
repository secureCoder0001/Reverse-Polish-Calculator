package application;


/**
 * A facade for stack to hide implementation details of stack for ease of use of floats. 
 * 
 * @author Mohamed Mohamed 
 *
 */
public class NumStack {

  private EntryStack stack;
  
  /**
   * Constructs and initialises a new stack.
   * 
   */
  public NumStack() {
    
    this.stack = new EntryStack();
  }
  
  /**
  * Returns the size of the NumStack.
  * 
  * @return the size of the stack.
  */
  public int size() {
    
    return stack.size();
  }
  
  
  /**
   * Method to push float onto NumStack.
   * 
   * @param num float to be pushed onto stack.
   */
  public void push(float num) {
    
    stack.push(new Entry(num));
    
  }  
  
 
}




