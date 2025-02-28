package main.com.Sparta.Calculator.App;

import java.util.ArrayList;
import java.util.Scanner;
import main.com.Sparta.Calculator.Operations.MathOperator;
import main.com.Sparta.Calculator.Utils.ResultManager;
import main.com.Sparta.Calculator.Utils.Converter;
import main.com.Sparta.Calculator.Utils.InputParser;
import main.com.Sparta.Calculator.Utils.Menu;

public class Calculator {

  //  속성
  private static final ResultManager resultManager = new ResultManager();

  //  생성자

  //  기능
  /**
   * 사용자가 입력한 문자열을 전처리하는 과정
   *
   * @param userInput 사용자 입력 문자열
   * @return Calculator 객체
   */
  private MathOperator parseAndCreateOperator(String userInput) {
    try {
      // 숫자와 연산자를 분리해서 문자열 배열로 반환
      InputParser inputParser = new InputParser(userInput);
      String[] userInputArray = inputParser.parseToArray();

      // 숫자만 형 변환(String -> double)한 후 ArrayList에 저장
      Converter converter = new Converter(userInputArray);
      ArrayList<Object> convertedNumberList = converter.convertStringToNumberArray();

      double value1 = (Double) convertedNumberList.get(0);
      double value2 = (Double) convertedNumberList.get(2);
      String operator = (String) convertedNumberList.get(1);

      return new MathOperator(value1, operator, value2, resultManager);
    } catch (Exception e) {
      System.out.println("잘못된 입력입니다.");
    }

    return new MathOperator();
  }

  // 프로그램 시작 지점
  public void run() {
    System.out.println("'help' 입력 시 안내 문구가 출력됩니다.\n");

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("수식 입력: ");
      String userInput = scanner.nextLine();
      Menu menu = new Menu(userInput, resultManager);

      if (menu.isExit()) {
        break;
      }
      if (menu.isCommand()) {
        menu.handleCommands();
        continue;
      }

      try {
        MathOperator mathOperator = parseAndCreateOperator(userInput);
        mathOperator.calculate();
        resultManager.printCurrentResult();
        resultManager.storeResult();
      } catch (Exception e) {
        System.out.println("'help'를 입력하여 입력 형식을 확인해주세요.");
        System.out.println(e.getMessage());
      }

      System.out.println("\n=============================\n");

    }

  }
}
