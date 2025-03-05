package main.com.Sparta.Calculator.Utils;

public class InputParser {

  //  속성
  private final String userInput;

  //  생성자
  public InputParser(String userInput) {
    this.userInput = userInput;
  }

  //  기능
  /**
   * 분리된 문자열을 배열로 반환
   * @return [숫자(String), 연산자(String), 숫자(String)] 형태로 분리한 문자열 배열
   */
  public String[] parseToArray(){
    return splitString(userInput);
  }

  /**
   * 문자열 분리
   * @param userInput 사용자로부터 입력받은 문자열
   * @return 공백이 있으면 공백을 기준으로, 없으면 한 문자를 기준으로 분리한 후 문자열 배열 반환
   */
  private String[] splitString(String userInput) {
    if (userInput.contains(" ")) {
      return userInput.split(" ");
    } else {
      return userInput.split("");
    }
  }

}
