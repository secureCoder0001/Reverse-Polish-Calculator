package application;


import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {

  private RevPolishCalc revPolishCalc;
  
  @BeforeEach
  void setUp(){
    revPolishCalc = new RevPolishCalc();
  }

  @Test
  void testEmptyExpression() {
    
    assertThrows(InvalidExpression.class, () -> revPolishCalc.evaluate(""),
        "Inputting an empty expression should throw an InvalidExpressionException");
  }
  
  @Test
  void testSingleNum() throws InvalidExpression {
    assertEquals(revPolishCalc.evaluate("9"), 9.0);
  }

  @Test
  void testTwoNums() {
    
    assertThrows(InvalidExpression.class, () -> revPolishCalc.evaluate("6 9"),
        "Inputting ONLY two values should throw an InvalidExpressionException");
  }

  
  @Test
  void testPlus() throws InvalidExpression {
    assertEquals(this.revPolishCalc.evaluate("6 3 +"), 9.0f);
    
    assertEquals(this.revPolishCalc.evaluate("9 7 5 + +"), 21.0f);
    
    assertEquals(this.revPolishCalc.evaluate("3 6 9 12 + + +"), 30.0f);
  }

  @Test
  void testDivide() throws InvalidExpression {
    assertEquals(this.revPolishCalc.evaluate("6 2 /"), 3.0f);
    assertEquals(this.revPolishCalc.evaluate("6 2 /"), 3.0f);        
    assertEquals(this.revPolishCalc.evaluate("12 2 /"), 6.0f);
    assertEquals(this.revPolishCalc.evaluate("8 2 /"), 4.0f);    
    assertEquals(this.revPolishCalc.evaluate("9 3 /"), 3.0f);       
    assertEquals(this.revPolishCalc.evaluate("9 2 /"), 4.5f);    
  }  
  
  @Test
  void testDivideByZero() {
    assertThrows(InvalidExpression.class, () -> this.revPolishCalc.evaluate("10 0 /"),
        "Divide By Zero note permitted");
  }
  
  
  @Test
  void testMinus() throws InvalidExpression {
    assertEquals(this.revPolishCalc.evaluate("9 6 -"), 3.0f);
    assertEquals(this.revPolishCalc.evaluate("9 5 -"), 4.0f);
    assertEquals(this.revPolishCalc.evaluate("15 3 -"), 12.0f);
    assertEquals(this.revPolishCalc.evaluate("20 6 -"), 14.0f);
    assertEquals(this.revPolishCalc.evaluate("100 15 -"), 85.0f); 
  }
  
  @Test
  void testTimes() throws InvalidExpression {
    assertEquals(this.revPolishCalc.evaluate("6 3 *"), 18.0f);
    
    assertEquals(this.revPolishCalc.evaluate("9 7 5 * *"), 315.0f);
    
    assertEquals(this.revPolishCalc.evaluate("3 6 9 12 * * *"), 1944.0f); 
    
    assertEquals(this.revPolishCalc.evaluate("15 5 *"), 75.0f);
    
    assertEquals(this.revPolishCalc.evaluate("15 6 *"), 90.0f);
    
    assertEquals(this.revPolishCalc.evaluate("25 15 *"), 375.0f);
  }

}
