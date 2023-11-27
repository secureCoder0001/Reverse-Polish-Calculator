package application;

/**
 * An enum to represent the different types of data a calculator can support.
 *
 * @author Mohamed Mohamed
 *
 */
public enum Type {
  
  NUMBER, SYMBOL, STRING, INVALID;

  @Override
  public String toString() {

    return this.name();
  }
}
