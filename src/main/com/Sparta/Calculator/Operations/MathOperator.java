package main.com.Sparta.Calculator.Operations;

import main.com.Sparta.Calculator.Utils.ResultManager;

public class MathOperator {

  //  속성
  private double value1;
  private double value2;
  private String operation;
  private ResultManager resultManager;

  //  생성자
  public MathOperator(double value1, String operation, double value2, ResultManager resultManager) {
    this.value1 = value1;
    this.value2 = value2;
    this.operation = operation;
    this.resultManager = resultManager;
  }

  public MathOperator() {
  }

  //  기능
  // TODO 02/27
  //  case에 있는 "+", "-" 등을
  //  ENUM(Operators)을 활용해서 활용하는 방법 찾기
  // 연산자에 따라 계산 결과 저장
  public void calculate() {

    if (operation.equals("/") || operation.equals("%")) {
      if (value2 == 0) {
        System.out.println("0으로 나눌 수 없습니다.");
        return;
      }
    }
    try {
      double result;
      switch (operation) {
        case "+":
          result = value1 + value2;
          break;
        case "-":
          result = value1 - value2;
          break;
        case "*":
          result = value1 * value2;
          break;
        case "/":
          result = value1 / value2;
          break;
        case "%":
          result = value1 % value2;
          break;
        case "^":
          result = Math.pow(value1, value2);
          break;
        case "sqrt":
          result = Math.sqrt(value1);
          break;
        default:
          System.out.println("지원하지 않는 연산자입니다.");
          return;
      }
      resultManager.setResult(result);
    } catch (Exception e) {
      resultManager.setResult(0);
      System.out.println("잘못된 수식입니다.");
    }
  }
}
