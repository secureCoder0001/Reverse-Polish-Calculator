package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {

  private CalcModel calcModel;
  
  @BeforeEach
  void setUp() {
    calcModel = new CalcModel();
  }

  @Test
  void testIsInfix() throws InvalidExpression {
    // Test to check that the appropriate evaluate method is called for an expression in infix notation.
    assertEquals(calcModel.evaluate("6 * 3", true), 18.0f);
    assertEquals(calcModel.evaluate("6 * 5", true), 30.0f);
    assertEquals(calcModel.evaluate("6 + 3", true), 9.0f);
  }
  
  @Test
  void testIsRevPolish() throws InvalidExpression {
    // Test to check that the appropriate evaluate method is called for an expression in reverse polish notation
    assertEquals(calcModel.evaluate("6 10 *", false), 60.0f);
    assertEquals(calcModel.evaluate("6 7 *", false), 42.0f);
    assertEquals(calcModel.evaluate("6 9 +", false), 15.0f);
  }
  
  @Test
  void testNotPostfix() {
    // To test exception is thrown when invalid expression is entered into InfixCalc 
    assertThrows(InvalidExpression.class, () -> calcModel.evaluate("6 * 10 ", false),
        "Inputting an InvalidExpression should throw and InvalidExpressionException");
    assertThrows(InvalidExpression.class, () -> calcModel.evaluate("500 * 3", false),
        "Inputting an InvalidExpression should throw and InvalidExpressionException");
    assertThrows(InvalidExpression.class, () -> calcModel.evaluate("9 * 3", false),
        "Inputting an InvalidExpression should throw and InvalidExpressionException");
  }  
  
  @Test
  void testNotInfix() {
    // To test exception is thrown when invalid expression is entered into InfixCalc
    assertThrows(InvalidExpression.class, () -> calcModel.evaluate("6 1 *", true),
        "Inputting an InvalidExpression should throw and InvalidExpressionException");
    assertThrows(InvalidExpression.class, () -> calcModel.evaluate("5 3 *", true),
        "Inputting an InvalidExpression should throw and InvalidExpressionException");
    assertThrows(InvalidExpression.class, () -> calcModel.evaluate("9 3 *", true),
        "Inputting an InvalidExpression should throw and InvalidExpressionException");
  }
  
  @Test
  void testMemory() throws InvalidExpression {
    // Test to check that the memory of the calculator works as expected.
    
    float result = 0.0f;
    
    result = calcModel.evaluate("6 + 9", true); 
    assertEquals(calcModel.getLastResult(), result);
    
    result = calcModel.evaluate("6 + 3", true);
    assertEquals(calcModel.getLastResult(), result);
    
    result = calcModel.evaluate("6  9 + ", false); 
    assertEquals(calcModel.getLastResult(), result);
    
    result = calcModel.evaluate("6 3 +", false);
    
    assertEquals(calcModel.getLastResult(), result);
  }  
}
