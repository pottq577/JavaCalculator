package calculator.operations;

public class SquareRoot implements Operation {

  //  속성
  private int value1;
  private int value2;
  private String operation;

  //  생성자
  public SquareRoot(int value1, String operation, int value2) {
    this.value1 = value1;
    this.value2 = value2;
    this.operation = operation;
  }

  //  기능
  @Override
  public int doCalculate() {
    return (int) Math.sqrt(value1);
  }
}
