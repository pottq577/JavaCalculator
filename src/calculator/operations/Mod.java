package calculator.operations;

public class Mod implements Operation {

  //  속성
  private double value1;
  private double value2;
  private String operation;

  //  생성자
  public Mod(double value1, String operation, double value2) {
    this.value1 = value1;
    this.value2 = value2;
    this.operation = operation;
  }

  //  기능
  @Override
  public double doCalculate() {
    double result = 0;
    try {
      result = value1 % value2;
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
