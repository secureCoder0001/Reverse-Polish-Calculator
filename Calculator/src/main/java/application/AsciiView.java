package application;

import java.io.IOException;
import java.util.Scanner;


/**
 * Class to provide a command line interface to the user.
 * Note that calculator only works with single digit operands.
 * 
 * @author Mohamed Mohamed
 */
public class AsciiView implements ViewInterface {
  // The current question that the calculator must solve: entered like ?3*(5+4)
  private String question;

  private String answer;
  private String expressType;
  Observer calculate;
  Observer type;
  Observer reset;

  

  /**
   * Method to handle command line interface for the calculator.
   * 
   */
  private void menu() throws IOException {
    
    System.out.println("*******************************");
    System.out.println("*******************************");
    System.out.println("          Ascii Calculator     ");
    System.out.println("*******************************");
    System.out.println("*******************************\n");
    System.out.print("Press any character followed by enter to continue: ");
        
    Scanner scanner = new Scanner(System.in);
    
    // Continue program once user has pressed any character key
    if (scanner.hasNext()) {
      scanner.next();
    }
    
    System.out.println();
    
    // Display instruction to user first.
    userGuide();
     
    // Program flow
    boolean finished = false;
    while (!finished) {
      
      System.out.print("Enter a command: ");
      String userInput = scanner.next().trim();
      
      switch (userInput.charAt(0)) {
        case 'C':
        case 'c':
          if (calculate != null) {
            calculate.notifyObservers();
            System.out.println(this.answer);
          }
          break;
        case '?':
          question = userInput.substring(1).replace("", " ");
          System.out.println("Question set to: " + this.question);
          break;
        case 'R':
        case 'r':
          reset.notifyObservers();
          this.question = "";
          break;
        case 'T':
        case 't':
          this.expressType = userInput.substring(1);
          type.notifyObservers();
          System.out.println("Notation set to: " + this.expressType);
          break;
        case 'Q':
        case 'q':
          System.out.println("Bye");
          finished = true;
          break;
        default:
          userGuide();
      }
    }
          
    scanner.close();
  }

  private void userGuide() {
    System.out.println("\n***********************************************************");
    System.out.println("When prompted, you can enter one of the following: \n");
    System.out.println("?Expression - to set an expression.");
    System.out.println("C - to calculate");
    System.out.println("T_infix OR T_postfix - to indicate either infix or posfix");
    System.out.println("R - to reset");
    System.out.println("Q - to exit the application");
    System.out.println("***********************************************************\n");
  }

  @Override
  public String getExpression() {
    return this.question;
  }

  @Override
  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Override
  public void startView() {
    try {
      menu();
    } catch (Exception e) {
      System.err.println("Calculator has malfunctioned. Please Restart.");
    }
  }

  @Override
  public void addCalculateObserver(Observer observer) {
    calculate = observer;
  }

  @Override
  public void addTypeObserver(Observer observer) {
    type = observer;
  }

  @Override
  public void addResetObserver(Observer observer) {
    reset = observer;
  }

  @Override
  public String getExpressionType() {
    return this.expressType;
  }
}
