package main.com.Sparta.Calculator.Utils;

public class Quit {
  //  속성
  private String userInput;

  //  생성자
  public Quit(String userInput) {
    this.userInput = userInput;
  }

  //  기능
  /**
   * 입력에 'exit'가 포함될 경우 무한 반복 종료
   *
   * @return 'exit'가 포함될 경우 true
   */
  public boolean isQuit() {
    if (userInput.contains("exit")) {
      System.out.println("프로그램을 종료합니다.");
      return true;
    }

    return false;
  }
}
