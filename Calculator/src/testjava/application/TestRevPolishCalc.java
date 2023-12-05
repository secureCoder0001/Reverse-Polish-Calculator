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

}
