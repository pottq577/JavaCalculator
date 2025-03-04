package main.com.Sparta.Calculator.App;

import java.util.List;
import java.util.Scanner;
import main.com.Sparta.Calculator.Operations.MathOperator;
import main.com.Sparta.Calculator.Utils.ResultManager;
import main.com.Sparta.Calculator.Utils.Converter;
import main.com.Sparta.Calculator.Utils.InputParser;
import main.com.Sparta.Calculator.Utils.Menu;

public class Calculator {

  //  속성
  private static final ResultManager resultManager = new ResultManager();

  //  기능

  /**
   * 전처리된 문자열로 연산 객체 생성
   *
   * @param userInput 사용자 입력 문자열
   * @return MathOperator 객체
   */
  private MathOperator createOperator(String userInput) {
    try {
      List<Object> convertedNumberList = splitAndParsing(userInput);

      try {
        double value1 = (Double) convertedNumberList.get(0);
        double value2 = (Double) convertedNumberList.get(2);
        String operator = (String) convertedNumberList.get(1);

        return new MathOperator(value1, operator, value2, resultManager);
      } catch (Exception e) {
        throw new IllegalArgumentException("오류가 발생했습니다.");
      }

    } catch (IllegalArgumentException e) {
      System.out.println("입력 오류 발생: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("예상치 못한 오류 발생: " + e.getMessage());
    }

    return new MathOperator();
  }

  /**
   * 사용자 입력 문자열 전처리 과정
   * - 문자열을 문자열 배열로 변환 (공백 제거)
   * - 문자열 형태의 숫자를 실수형으로 변환
   * - 최종 결과를 ArrayList에 저장
   *
   * @param userInput 사용자 입력 문자열
   * @return [피연산자(double), 연산자(String), 피연산자(double)] 형태의 ArrayList
   */
  private List<Object> splitAndParsing(String userInput) {
    if (userInput == null || userInput.trim().isEmpty()) {
      throw new IllegalArgumentException("입력값이 비어있습니다.");
    }

    // 숫자와 연산자를 분리해서 문자열 배열로 반환
    InputParser inputParser = new InputParser(userInput);
    String[] userInputArray = inputParser.parseToArray();
    if (userInputArray.length < 3) {
      throw new IllegalArgumentException("올바르지 않은 수식 형식입니다. (예: 2 + 3)");
    }

    // 숫자만 형 변환(String -> double)한 후 ArrayList에 저장
    Converter converter = new Converter(userInputArray);
    List<Object> convertedNumberList = converter.convertStringToNumberArray();
    if (convertedNumberList.size() != 3) {
      throw new IllegalArgumentException("잘못된 수식 형식입니다.");
    }

    return convertedNumberList;
  }

  // 프로그램 시작 지점
  public void run() {
    System.out.println("'help' 입력 시 안내 문구가 출력됩니다.\n");

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("수식 입력: ");
      String userInput = scanner.nextLine();
      Menu menu = new Menu(userInput, resultManager);

      // userInput이 특정 커맨드일 때 로직
      if (menu.isExit()) {
        break;
      }
      if (menu.isCommand()) {
        menu.handleCommands();
        continue;
      }

      try {
        MathOperator mathOperator = createOperator(userInput);
        mathOperator.calculate();
        resultManager.printCurrentResult();
        resultManager.storeResult();
      } catch (Exception e) {
        System.out.println("\n'help'를 입력하여 입력 형식을 확인해주세요.");
      }

      System.out.println("\n=============================\n");

    }

  }
}
