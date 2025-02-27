package main.com.Sparta.Calculator.Utils;

public class InputParser {

  //  속성
  String userInput;
  String[] userInputArray;

  //  생성자
  public InputParser(String userInput) {
    this.userInput = userInput;
  }

  //  기능
  /**
   * 숫자와 연산자를 분리해서 문자열 배열로 반환
   *
   * @param userInput 사용자로부터 입력받은 문자열
   * @return [숫자(String), 연산자(String), 숫자(String)] 형태로 분리한 문자열 배열
   */
  public String[] parseExpression(String userInput) {
    if (userInput.contains(" ")) {
      userInputArray = userInput.split(" ");
    } else {
      userInputArray = userInput.split("");
    }

    return userInputArray;
  }
}
