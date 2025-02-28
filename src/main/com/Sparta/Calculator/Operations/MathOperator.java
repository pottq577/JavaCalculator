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

    try {
      if (operation == null) {
        throw new IllegalArgumentException("연산자가 설정되지 않았습니다.");
      }

      validateDivisionByZero();

      double result = performCalculation();

      resultManager.setResult(result);
    } catch (IllegalArgumentException e) {
      System.out.println("계산 오류: " + e.getMessage());
      resultManager.setResult(0);
    } catch (ArithmeticException e) {
      System.out.println("수학적 오류: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("예상치 못한 오류: " + e.getMessage());
    }
  }

  // 0으로 나눗셈 / 나머지 연산을 하는지 검증
  private void validateDivisionByZero() {
    if ((operation.equals("/") || operation.equals("%")) && value2 == 0) {
      throw new ArithmeticException("0으로 나눌 수 없습니다.");
    }
  }

  /**
   * 연산자에 따라 연산 수행
   * @return 연산 결과값
   */
  private double performCalculation() {
    switch (operation) {
      case "+":
        return value1 + value2;
      case "-":
        return value1 - value2;
      case "*":
        return value1 * value2;
      case "/":
        return value1 / value2;
      case "%":
        return value1 % value2;
      case "^":
        return Math.pow(value1, value2);
      default:
        throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + operation);
    }
  }
}
