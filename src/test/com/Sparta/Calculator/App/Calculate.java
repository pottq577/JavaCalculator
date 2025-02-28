package test.com.Sparta.Calculator.App;

import test.com.Sparta.Calculator.Operations.Operators;

public class Calculate {

  double value1;
  String operator;
  double value2;

  public Calculate(double value1, String operator, double value2) {
    this.value1 = value1;
    this.operator = operator;
    this.value2 = value2;
  }

  public double calc() {
    Operators operators = Operators.fromString(operator);
    return operators.compute(value1, value2);
  }
}
