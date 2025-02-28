package test.com.Sparta.Calculator.App;

import java.util.Scanner;
import test.com.Sparta.Calculator.Operations.Operators;

public class Main {

  public static void main(String[] args) {
    double value1 = 12;
    double value2 = 4;

    while (true) {
      System.out.println("연산자: ");
      Scanner scanner = new Scanner(System.in);
      String operator = scanner.nextLine();

      Calculate calculate = new Calculate(value1, operator, value2);

      double result = calculate.calc();
      System.out.println("result = " + result);
    }
  }

}
