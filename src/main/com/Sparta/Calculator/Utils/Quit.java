package main.com.Sparta.Calculator.Utils;

public class Quit {
  //  속성
  String userInput;

  //  생성자
  public Quit(String userInput) {
    this.userInput = userInput;
  }

  //  기능
  /**
   * 입력에 'exit'가 포함될 경우 무한 반복 종료
   *
   * @param userInput 사용자로부터 입력받은 문자열
   * @return 'exit'가 포함될 경우 true
   */
  public boolean isQuit(String userInput) {
    if (userInput.contains("exit")) {
      System.out.println("프로그램을 종료합니다.");
      return true;
    }

    return false;
  }
}
