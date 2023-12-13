package application;


/**
 * An observer to implement the observer/observable Design Pattern.
 * 
 * @author Mohamed Mohamed
 *
 */
@FunctionalInterface
public interface Observer {
  /**
   * Method to be called by observable objects when a change has occurred.
   */
  public void notifyObservers();
}