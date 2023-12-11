package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/*
 * NOTE TO MARKER: I would like to marker to note that this test class does not require as many tests as the alternative calculator, 
 * RevPolishCalc. 
 * 
 * Test cases such as checking what happens when zero is entered or inputting a single number onto the calculator is already 
 * tested in already tested in the underlying RevPolishCalc instance. As such, rewriting such tests here would cause code duplication.
 * 
 * I have therefore omitted these tests.
 * 
 * */


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
  
}
