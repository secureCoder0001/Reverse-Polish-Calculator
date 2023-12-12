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
    // Test to check that appropriate evaluate method is called for an infix expression.
    assertEquals(calcModel.evaluate("6 * 3", true), 18.0f);
  }
  
}
