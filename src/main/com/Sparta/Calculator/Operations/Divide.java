package main.com.Sparta.Calculator.Operations;

public class Divide implements Operation {

  //  속성
  private double value1;
  private double value2;
  private String operation;

  //  생성자
  public Divide(double value1, String operation, double value2) {
    this.value1 = value1;
    this.value2 = value2;
    this.operation = operation;
  }

  //  기능
  /**
   * 나눗셈 연산 수행
   * 0으로 나눌 시 예외 처리
   * @return value1 / 0
   */
  @Override
  public double doCalculate() {
    double result = 0;
    try {
      result = value1 / value2;
    } catch (ArithmeticException e) {
      System.out.println("0으로 나눌 수 없습니다.");
    }

    return result;
  }

  @Override
  public void printResult() {
    System.out.println(value1 + " " + operation + " " + value2 + " = " + doCalculate());
  }
}
