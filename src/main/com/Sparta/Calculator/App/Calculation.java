package main.com.Sparta.Calculator.App;

import java.util.ArrayList;
import java.util.Scanner;
import main.com.Sparta.Calculator.Operations.Calculator;
import main.com.Sparta.Calculator.Utils.ConvertToNumberList;
import main.com.Sparta.Calculator.Utils.Help;
import main.com.Sparta.Calculator.Utils.InputParser;
import main.com.Sparta.Calculator.Utils.Quit;

public class Calculation {
  Quit quit = new Quit("");
  Help help = new Help("");

  // 프로그램 시작 지점
  public void start() {
    while (true) {
      System.out.println("'help' 입력 시 안내 문구가 출력됩니다.");
      System.out.println("'exit' 입력 시 프로그램이 종료됩니다.");
      System.out.print("수식 입력: ");
      Scanner scanner = new Scanner(System.in);
      String userInput = scanner.nextLine();

      if (quit.isQuit(userInput)) {
        break;
      }
      if (help.isHelp(userInput)) {
        continue;
      }

      // 숫자와 연산자를 분리해서 문자열 배열로 반환
      InputParser inputParser = new InputParser(userInput);
      String[] userInputArray = inputParser.parseExpression(userInput);

      // 숫자만 형 변환(String -> double)한 후 ArrayList에 저장
      ConvertToNumberList convertToNumberList = new ConvertToNumberList(userInputArray);
      ArrayList<Object> convertedNumberList = convertToNumberList.convert(userInputArray);

      double value1 = (Double) convertedNumberList.get(0);
      double value2 = (Double) convertedNumberList.get(2);
      String operator = (String) convertedNumberList.get(1);

      Calculator calculator = new Calculator(value1, operator, value2);
      calculator.doCalculate();
      System.out.println("=============================\n");
    }
  }
}
