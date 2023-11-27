package application;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Class to represent and implement a stack that supports objects of type Entry.
 *
 * @author Mohamed Mohamed
 * 
 */
public class EntryStack {
  
  int size = 0; // Included in UML but not really needed as I have a top variable
  List<Entry> values; // Refactor to support entries
  
  
  /**
   * Constructs and intialises a new stack.
   * 
   */
  public EntryStack() {

    values = new ArrayList<Entry>();

  }
  
  // Variable not essential but useful to use instead of calling 'values.get(values.size() - 1)'
  // every time we require the item at the top of the stack
  int topOfStack = 0;
  
  
  /**
   * Returns the size of the stack. Really under the hood, it is returing the size of the ArrayList.
   *
   * @return Returns the size of the stack.
   */
  public int size() {

    return values.size();
  }
  
  
  /**
   * Pushes an item onto the top of the stack.
   *
   * @param value the item to be pushed onto the stack.
   */
  public void push(Entry value) {

    values.add(value);

    topOfStack = this.size() - 1;
  }
  
   
  
  /**
   * Removes the item at the top of the stack and returns said item. Technically speaking, it
   * returns the last item in the underlying ArrayList.
   *
   * @return Returns the Entry at the top of the stack.
   */
  public Entry pop() {

    if (values.size() == 0) {
      throw new EmptyStackException();
    }

    Entry value = values.get(topOfStack);
    values.remove(topOfStack);

    topOfStack = values.size() - 1;

    return value;
  }  
  
  /**
   * Returns the item at the top of the stack without removing it from the stack.
   *
   * @return the Entry at the top of the stack.
   */
  public Entry top() {

    if (values.size() == 0) {
      throw new EmptyStackException();
    }

    return values.get(topOfStack);
  }
}
