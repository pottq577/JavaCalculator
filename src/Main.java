import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] userInputArray;
    int result;

    while (true) {
      System.out.println("수식을 입력해주세요. 'exit' 입력 시 종료됩니다.");
      System.out.println("예시: 1 + 2");
      System.out.print("입력: ");
      String userInput = scanner.nextLine();

      /**
       * 사용자로부터의 입력에 'exit'가 포함될 경우 무한 반복 종료
       */
      if (userInput.contains("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }

      /**
       * 숫자 부분과 연산자 부분을 분리하는 코드
       */
      if (userInput.contains(" ")) {
        userInputArray = userInput.split(" ");
      } else {
        userInputArray = userInput.split("");
      }

      /**
       * UserInputArray[0]과 UserInputArray[2]를 정수로 변환한다.
       * 연산자에 따라 적절한 계산 결과를 보여준다.
       *
       * @param userInputArray[1] 사용자로부터 입력받은 연산자
       */
      switch (userInputArray[1]) {
        case "+":
          result = Integer.parseInt(userInputArray[0]) + Integer.parseInt(userInputArray[2]);
          System.out.println(
              userInputArray[0] + " " + userInputArray[1] + " " + userInputArray[2] + " = "
                  + result);
          break;
        case "-":
          result = Integer.parseInt(userInputArray[0]) - Integer.parseInt(userInputArray[2]);
          System.out.println(
              userInputArray[0] + " " + userInputArray[1] + " " + userInputArray[2] + " = "
                  + result);
          break;
        case "*":
          result = Integer.parseInt(userInputArray[0]) * Integer.parseInt(userInputArray[2]);
          System.out.println(
              userInputArray[0] + " " + userInputArray[1] + " " + userInputArray[2] + " = "
                  + result);
          break;
        case "/":
          try {
            result = Integer.parseInt(userInputArray[0]) / Integer.parseInt(userInputArray[2]);
          } catch (ArithmeticException e) {
            System.out.println("잘못된 나눗셈입니다.");
            continue;
          }
          System.out.println(
              userInputArray[0] + " " + userInputArray[1] + " " + userInputArray[2] + " = "
                  + result);
          break;
        default:
          break;
      }
      System.out.println("\n==================\n");
    }

  }
}