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
        "Inputting only two values should throw an InvalidExpressionException");
  }

  
}
