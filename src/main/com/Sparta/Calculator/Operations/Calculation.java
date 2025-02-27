package main.com.Sparta.Calculator.Operations;

public class Calculation implements Operation {

  //  속성
  private double value1;
  private double value2;
  private String operation;
  private double result;
  Results results = new Results(result);

  //  생성자
  public Calculation(double value1, String operation, double value2) {
    this.value1 = value1;
    this.value2 = value2;
    this.operation = operation;
  }

  public Calculation() {
  }

  //  기능
  // TODO 02/27
  //  case에 있는 "+", "-" 등을
  //  ENUM(Operators)을 활용해서 활용하는 방법 찾기
  // 연산자에 따라 계산 결과 저장
  @Override
  public double doCalculate() {

    if (operation.equals("/") || operation.equals("%")) {
      if (value2 == 0) {
        System.out.println("0으로 나눌 수 없습니다.");
        return 0;
      }
    }
    try {
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
          return 0;
      }
    } catch (Exception e) {
      result = 0;
      System.out.println("잘못된 수식입니다.");
    }
    return result;
  }

  // 계산 결과 출력
  @Override
  public void printResult() {
    if (operation.equals("sqrt")) {
      System.out.println(operation + "(" + value1 + ") = " + result);
    } else {
      System.out.println(value1 + " " + operation + " " + value2 + " = " + result);
    }
  }

  public void addResultList() {
    results.addResult(result);
  }
}
