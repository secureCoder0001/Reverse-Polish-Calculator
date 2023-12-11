package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestStandardCalc {

  private StandardCalc standardCalc;
  
  @BeforeEach
  void setUp(){
    standardCalc = new StandardCalc();
  }

  @Test
  void testEmptyExpression() {
    
    assertThrows(InvalidExpression.class, () -> standardCalc.evaluate(""),
        "Inputting an empty expression should throw an InvalidExpressionException");
  }
  
  @Test
  void testSingleNum() throws InvalidExpression {
    assertEquals(standardCalc.evaluate("9"), 9.0);
  }  
  
  @Test
  void testTwoNums() {
    
    assertThrows(InvalidExpression.class, () -> standardCalc.evaluate("3 6"),
        "Inputting ONLY two values should throw an InvalidExpressionException");
  }
  
  @Test
  void testPlus() throws InvalidExpression {
    assertEquals(this.standardCalc.evaluate("6 + 3"), 9.0f);
    
    assertEquals(this.standardCalc.evaluate("9 + 6 + 3"), 18.0f);
    
    assertEquals(this.standardCalc.evaluate("3 + 6 + 9 + 15"), 33.0f);
    
    assertEquals(this.standardCalc.evaluate("3 + 6 + 9 + 15 + 13 + 16 + 100"), 162.0f);
  }

  
}
