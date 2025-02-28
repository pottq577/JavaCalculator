package test.com.Sparta.Calculator.Operations;

public class Add implements Computable {

  @Override
  public double compute(double value1, double value2) {
    return value1 + value2;
  }
}
