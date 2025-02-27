package main.com.Sparta.Calculator.Utils;

public class Help {
  //  속성
  String userInput;

  //  생성자
  public Help(String userInput) {
    this.userInput = userInput;
  }

  //  기능
  /**
   * 입력에 'help'가 포함될 경우 안내 문구 출력
   *
   * @param userInput 사용자로부터 입력받은 문자열
   * @return 'help'가 포함될 경우 true
   */
  public boolean isHelp(String userInput) {
    if (userInput.contains("help")) {
      System.out.println("\n안내 문구를 출력합니다.");
      printInstructions();
      return true;
    }

    return false;
  }

  // 안내 문구 출력
  private void printInstructions() {
    System.out.println("\n=============================");
    System.out.println("임력 예시: 1 + 2 (띄어쓰기 구분 없음)");
    System.out.println("덧셈: 1 + 2");
    System.out.println("뺄셈: 1 - 2");
    System.out.println("곱셈: 1 * 2");
    System.out.println("나눗셈: 1 / 2");
    System.out.println("나머지 연산: 1 % 2");
    System.out.println("제곱: 1 ^ 2");
    System.out.println("제곱근: 4 sqrt");
    System.out.println("=============================\n");
    System.out.println("");
  }
}
