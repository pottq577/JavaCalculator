package main.com.Sparta.Calculator.App;

import java.util.ArrayList;
import java.util.Scanner;
import main.com.Sparta.Calculator.Operations.Calculation;
import main.com.Sparta.Calculator.Operations.Results;
import main.com.Sparta.Calculator.Utils.ConvertToNumberList;
import main.com.Sparta.Calculator.Utils.Help;
import main.com.Sparta.Calculator.Utils.InputParser;
import main.com.Sparta.Calculator.Utils.Quit;

public class Calculator {

  Quit quit;
  Help help;
  Results results;

  /**
   * 사용자가 입력한 문자열을 전처리하는 과정
   *
   * @param userInput 사용자 입력 문자열
   * @return Calculator 객체
   */
  private static Calculation initCalculator(String userInput) {
    try {
      // 숫자와 연산자를 분리해서 문자열 배열로 반환
      InputParser inputParser = new InputParser(userInput);
      String[] userInputArray = inputParser.parseExpression(userInput);

      // 숫자만 형 변환(String -> double)한 후 ArrayList에 저장
      ConvertToNumberList convertToNumberList = new ConvertToNumberList(userInputArray);
      ArrayList<Object> convertedNumberList = convertToNumberList.convert(userInputArray);

      double value1 = (Double) convertedNumberList.get(0);
      double value2 = (Double) convertedNumberList.get(2);
      String operator = (String) convertedNumberList.get(1);

      return new Calculation(value1, operator, value2);
    } catch (Exception e) {
      System.out.println("잘못된 입력입니다.");
      System.out.println(e.getMessage());
    }

    return new Calculation();
  }

  /**
   * 특정 커맨드가 들어왔을 때 처리하는 로직
   * @param userInput 사용자 입력
   * @return help, ls, a, ac 입력 시 true 반환
   */
  private boolean handleCommands(String userInput) {
    help = new Help(userInput);
    results = new Results();

    return help.isHelp() || results.handleCommand(userInput);
  }

  // 프로그램 시작 지점
  public void start() {
    System.out.println("'help' 입력 시 안내 문구가 출력됩니다.\n");

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("수식 입력: ");
      String userInput = scanner.nextLine();
      quit = new Quit(userInput);

      if (quit.isQuit()) {
        break;
      }
      if (handleCommands(userInput)) {
        continue;
      }

      try {
        Calculation calculation = initCalculator(userInput);
        calculation.doCalculate();
        calculation.printResult();
        calculation.addResultList();

      } catch (Exception e) {
        System.out.println("'help'를 입력하여 입력 형식을 확인해주세요.");
      }

      System.out.println("\n=============================\n");
    }
  }
}
