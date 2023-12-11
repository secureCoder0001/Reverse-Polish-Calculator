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
}
