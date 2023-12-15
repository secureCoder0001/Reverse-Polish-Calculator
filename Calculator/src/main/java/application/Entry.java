package application;

import java.util.Objects;

/**
 * Class to represent a container class for either a Float, String or a Symbol.
 *
 *
 * @author Mohamed Mohamed
 * 
 */
public class Entry {

  
  private float value;
  private String str;
  private Symbol other;
  private Type type;
  
  /**
   * Constructs a new Float Entry.
   *
   * @param value the value to be store in the new float Entry
   */
  public Entry(float value) {

    this.value = value;
    this.type = Type.NUMBER;
  }
  
  /**
   * Constructs a new String Entry.
   *
   * @param string the value to be store in the new float Entry
   */
  public Entry(String string) {
    this.str = string;
    this.type = Type.STRING;
  }

  
  /**
   * Constructs a new Symbol Entry.
   *
   * @param other the value to be store in the new float Entry
   */
  public Entry(Symbol other) {

    // There was initially no field in the class and so I had to manually return the Symbol I
    // required to pass the tests
    this.other = other;
    this.type = Type.SYMBOL;
  }
 

  /**
   * Returns the value stored in the Entry container.
   *
   * @return Returns the value stored in Entry
   * @throws BadTypeException if this method is called by non-corresponding Entry type
   */
  public Float getValue() throws BadTypeException {
    // There was initially no field in the class and so I had to manually return a value of type
    // float I required to pass the tests

    if (this.type != Type.NUMBER) {

      throw new BadTypeException("Inappropriate entry used to call getValue()");
    }

    return this.value;
  }

 

  /**
   * Returns the value stored in the Entry container.
   *
   * @return Returns the value stored in Entry
   * @throws BadTypeException if this method is called by non-corresponding Entry type
   */
  public String getString() throws BadTypeException {
    // There was initially no field in the class and so I had to manually return the String I
    // required to pass the tests

    if (this.type != Type.STRING) {

      throw new BadTypeException("Inappropriate entry used to call getString()");
    }

    return this.str;
  }


  /**
   * Returns the value stored in the Entry container.
   *
   * @return Returns the value stored in Entry
   * @throws BadTypeException if this method is called by non-corresponding Entry type
   */
  public Symbol getSymbol() throws BadTypeException {

    if (this.type != Type.SYMBOL) {

      throw new BadTypeException("Inappropriate entry used to call getSymbol()");
    }

    return this.other;
  }


  /**
   * Check this Entry and the specified 'Object' for equality.
   *
   * @return Returns true iff boths objects have the same type and value, false otherwise.
   */
  @Override
  public boolean equals(Object o) {

    if (this == o) { // Purely a performance decision - not neccessary
      return true;
    }

    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }


    Entry other = (Entry) o;

    if (this.getType() != other.getType()) {
      return false;
    }

    return Objects.equals(this.str, other.str) && this.value == other.value
        && this.other == other.other;

  }


  /**
   * Generates a hash code for all the value types (String, Float andt Symbol).
   * 
   */
  @Override
  public int hashCode() {

    return Objects.hash(this.str, this.value, this.other);
  }
  

  /**
   * Returns the type of the Entry container instance.
   *
   * @return Returns the type of the Entry instance
   */
  public Type getType() {

    return type;
  }

  /**
   * Formatted string represenation of the object's attributes.
   * 
   * @return a formatted string representation of the arributes.
   */
  @Override
  public String toString() {

    return "value = " + this.value + " \n" + "string = " + this.str + " \n" + "Symbol = "
        + this.other;
  }  
}
