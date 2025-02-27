package main.com.Sparta.Calculator.Operations;

public class Mul implements Operation {

  //  속성
  private double value1;
  private double value2;
  private String operation;

  //  생성자
  public Mul(double value1, String operation, double value2) {
    this.value1 = value1;
    this.value2 = value2;
    this.operation = operation;
  }

  //  기능
  /**
   * 곱셈 연산 수행
   * @return value1 * value2
   */
  @Override
  public double doCalculate() {
    return value1 * value2;
  }

  @Override
  public void printResult() {
    System.out.println(value1 + " " + operation + " " + value2 + " = " + doCalculate());
  }
}
