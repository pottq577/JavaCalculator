package main.com.Sparta.Calculator.Utils;

import main.com.Sparta.Calculator.Operations.Operation;
import main.com.Sparta.Calculator.Operations.Add;
import main.com.Sparta.Calculator.Operations.Divide;
import main.com.Sparta.Calculator.Operations.Mod;
import main.com.Sparta.Calculator.Operations.Mul;
import main.com.Sparta.Calculator.Operations.Square;
import main.com.Sparta.Calculator.Operations.SquareRoot;
import main.com.Sparta.Calculator.Operations.Sub;

public class DisplayCalculationResult {
  //  속성
  double value1;
  double value2;
  String operator;

  //  생성자
  public DisplayCalculationResult(double value1, double value2, String operator) {
    this.value1 = value1;
    this.value2 = value2;
    this.operator = operator;
  }

  //  기능
  /**
   * 연산 결과 출력
   *
   * @param value1   첫 번째 숫자
   * @param operator 연산자
   * @param value2   두 번째 숫자
   */
  public void printResultByOperator(double value1, String operator, double value2) {
    Operation operation;

    // TODO 02/07
    //  case에 있는 "+", "-" 등을
    //  ENUM(Operators)을 활용해서 활용하는 방법 찾기
    switch (operator) {
      case "+":
        operation = new Add(value1, operator, value2);
        break;
      case "-":
        operation = new Sub(value1, operator, value2);
        break;
      case "*":
        operation = new Mul(value1, operator, value2);
        break;
      case "/":
        operation = new Divide(value1, operator, value2);
        break;
      case "%":
        operation = new Mod(value1, operator, value2);
        break;
      case "^":
        operation = new Square(value1, operator, value2);
        break;
      case "sqrt":
        operation = new SquareRoot(value1, operator);
        break;
      default:
        System.out.println("지원하지 않는 연산자입니다.");
        return;
    }
    operation.printResult();
  }
}
