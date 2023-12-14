package application;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 * 
 * @author Mohamed Mohamed
 *
 */
public class CalcController {

  private CalcModel calcModel;
  private ViewInterface view;
  private boolean isInfix;
  
  CalcController(CalcModel calcModel, ViewInterface view) {
    this.calcModel = calcModel;
    this.view = view;
    isInfix = true;
    view.addCalculateObserver(this::handleCalculate);
    view.addTypeObserver(this::handleSetExpressionType);
    view.addResetObserver(this::handleReset);
  }
  
  private void handleCalculate() {
    String userExpression = view.getExpression();
    try {
      calcModel.evaluate(userExpression, isInfix);
      view.setAnswer(String.valueOf(calcModel.getLastResult()));
    } catch (Exception e) {
      view.setAnswer("Error has occurred");
    }
  }
  
  private void handleSetExpressionType() {
    String expressionType = view.getExpressionType();
    if (expressionType.equals("_infix")) { 
      isInfix = true; 
    }
    
    isInfix = false;
  }
  
  private void handleReset() {
    calcModel.reset();
    view.setAnswer(String.valueOf(calcModel.getLastResult()));
  }   
}
