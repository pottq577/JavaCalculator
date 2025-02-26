package calculator;

import calculator.operations.Add;
import calculator.operations.Divide;
import calculator.operations.Mul;
import calculator.operations.Operation;
import calculator.operations.Square;
import calculator.operations.SquareRoot;
import calculator.operations.Sub;
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
   * @param userInput 사용자로부터 입력받은 문자열
   * @return 'help'가 포함될 경우 true
   */
  private boolean help(String userInput){
    if(userInput.contains("help")){
      System.out.println("\n안내 문구를 출력합니다.");
      printInstructions();
      return true;
    }

    return false;
  }

  // 안내 문구 출력
  private void printInstructions(){
    System.out.println("\n=============================");
    System.out.println("임력 예시: 1 + 2 (띄어쓰기 구분 없음)");
    System.out.println("덧셈: 1 + 2");
    System.out.println("뺄셈: 1 - 2");
    System.out.println("곱셈: 1 * 2");
    System.out.println("나눗셈: 1 / 2");
    System.out.println("나머지 연산: 1 % 2");
    System.out.println("제곱: 1 ^ 2");
//    System.out.println("제곱근: 4 sqrt");
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
    int value1 = Integer.parseInt(userInputArray[0]);
    int value2 = Integer.parseInt(userInputArray[2]);

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
  private void printCalcResult(int value1, String operator, int value2) {
    Operation operation = null;

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
//      case "sqrt":
//        operation = new Sqrt(value1, operator);
//        break;
      default:
        System.out.println("지원하지 않는 연산자입니다.");
        break;
    }
    System.out.println(value1 + " " + operator + " " + value2 + " = " + operation.doCalculate());
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

      if(help(userInput)){
        continue;
      }

      int value1 = (Integer) stringToInteger(separateString(userInput)).get(0);
      int value2 = (Integer) stringToInteger(separateString(userInput)).get(2);
      String operator = (String) stringToInteger(separateString(userInput)).get(1);

      printCalcResult(value1, operator, value2);
      System.out.println("=============================\n");
    }
  }
}
