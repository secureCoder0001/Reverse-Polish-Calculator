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
  void testIsInfix() throws InvalidExpression{
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
}
