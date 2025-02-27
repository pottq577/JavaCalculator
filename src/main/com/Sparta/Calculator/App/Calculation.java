package main.com.Sparta.Calculator.App;

import main.com.Sparta.Calculator.Operations.Add;
import main.com.Sparta.Calculator.Operations.Divide;
import main.com.Sparta.Calculator.Operations.Mul;
import main.com.Sparta.Calculator.Operations.Operation;
import main.com.Sparta.Calculator.Operations.Square;
import main.com.Sparta.Calculator.Operations.SquareRoot;
import main.com.Sparta.Calculator.Operations.Sub;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculation {

  /**
   * 입력에 'exit'가 포함될 경우 무한 반복 종료
   *
   * @param userInput 사용자로부터 입력받은 문자열
   * @return 'exit'가 포함될 경우 true
   */
  private boolean quit(String userInput) {
    if (userInput.contains("exit")) {
      System.out.println("프로그램을 종료합니다.");
      return true;
    }

    return false;
  }

  /**
   * 입력에 'help'가 포함될 경우 안내 문구 출력
   *
   * @param userInput 사용자로부터 입력받은 문자열
   * @return 'help'가 포함될 경우 true
   */
  private boolean help(String userInput) {
    if (userInput.contains("help")) {
      System.out.println("\n안내 문구를 출력합니다.");
      printInstructions();
      return true;
    }

    return false;
  }

  // 안내 문구 출력
  private void printInstructions() {
    System.out.println("\n=============================");
    System.out.println("임력 예시: 1 + 2 (띄어쓰기 구분 없음)");
    System.out.println("덧셈: 1 + 2");
    System.out.println("뺄셈: 1 - 2");
    System.out.println("곱셈: 1 * 2");
    System.out.println("나눗셈: 1 / 2");
    System.out.println("나머지 연산: 1 % 2");
    System.out.println("제곱: 1 ^ 2");
    System.out.println("제곱근: 4 sqrt");
    System.out.println("=============================\n");
    System.out.println("");
  }

  /**
   * 숫자와 연산자를 분리해서 문자열 배열로 반환
   *
   * @param userInput 사용자로부터 입력받은 문자열
   * @return [숫자(String), 연산자(String), 숫자(String)] 형태로 분리한 문자열 배열
   */
  private String[] separateString(String userInput) {
    String[] userInputArray;

    if (userInput.contains(" ")) {
      userInputArray = userInput.split(" ");
    } else {
      userInputArray = userInput.split("");
    }

    return userInputArray;
  }

  /**
   * 숫자를 형변환하고 ArrayList에 추가
   *
   * @param userInputArray 띄어쓰기를 제외한 숫자, 연산자
   * @return [숫자(int), 연산자(String), 숫자(int)] 형태로 변환한 ArrayList
   */
  private ArrayList<Object> stringToInteger(String[] userInputArray) {
    ArrayList<Object> arrayList = new ArrayList<>();
    double value1 = Double.parseDouble(userInputArray[0]);
    double value2 = 0;

    if (userInputArray.length == 3) {
      value2 = Double.parseDouble(userInputArray[2]);
    }

    arrayList.add(value1);
    arrayList.add(userInputArray[1]);
    arrayList.add(value2);

    return arrayList;
  }

  /**
   * 연산 결과 출력
   *
   * @param value1   첫 번째 숫자
   * @param operator 연산자
   * @param value2   두 번째 숫자
   */
  private void printCalcResult(double value1, String operator, double value2) {
    Operation operation = null;

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
      case "^":
        operation = new Square(value1, operator, value2);
        break;
      case "sqrt":
        operation = new SquareRoot(value1, operator);
        break;
      default:
        System.out.println("지원하지 않는 연산자입니다.");
        break;
    }
    operation.printResult();
  }

  // 프로그램 시작 지점
  public void start() {
    while (true) {
      System.out.println("'help' 입력 시 안내 문구가 출력됩니다.");
      System.out.println("'exit' 입력 시 프로그램이 종료됩니다.");
      System.out.print("수식 입력: ");
      Scanner scanner = new Scanner(System.in);
      String userInput = scanner.nextLine();

      if (quit(userInput)) {
        break;
      }

      if (help(userInput)) {
        continue;
      }

      double value1 = (Double) stringToInteger(separateString(userInput)).get(0);
      double value2 = (Double) stringToInteger(separateString(userInput)).get(2);
      String operator = (String) stringToInteger(separateString(userInput)).get(1);

      printCalcResult(value1, operator, value2);
      System.out.println("=============================\n");
    }
  }
}
