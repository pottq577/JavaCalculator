package calculator.operations;

public class Divide implements Operation {

  //  속성
  private int value1;
  private int value2;
  private String operation;

  //  생성자
  public Divide(int value1, String operation, int value2) {
    this.value1 = value1;
    this.value2 = value2;
    this.operation = operation;
  }

  //  기능
  @Override
  public int doCalculate() {
    int result = 0;
    try {
      result = value1 / value2;
    } catch (ArithmeticException e) {
      System.out.println("0으로 나눌 수 없습니다.");
    }

    return result;
  }
}
