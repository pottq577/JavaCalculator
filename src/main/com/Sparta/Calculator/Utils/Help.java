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
   * @return 'help'가 포함될 경우 true
   */
  public boolean isHelp() {
    if (userInput.contains("help")) {
      System.out.println("\n안내 문구를 출력합니다.");
      printInstructions();
      return true;
    }

    return false;
  }

  // 안내 문구 출력
  private void printInstructions() {
    System.out.println("\n=============입력=============");
    System.out.println("임력 예시: 1 + 2 (띄어쓰기 구분 없음)");
    System.out.println("덧셈: 1 + 2");
    System.out.println("뺄셈: 1 - 2");
    System.out.println("곱셈: 1 * 2");
    System.out.println("나눗셈: 1 / 2");
    System.out.println("나머지 연산: 1 % 2");
    System.out.println("제곱: 1 ^ 2");
    System.out.println("제곱근: 4 sqrt");
    System.out.println("============================\n");

    System.out.println("\n=============명령어=============");
    System.out.println("'exit' 입력 시 프로그램이 종료됩니다.");
    System.out.println("'ls' 입력 시 저장된 모든 결과를 출력합니다.");
    System.out.println("'a' 입력 시 가장 먼저 저장된 결과가 삭제됩니다.");
    System.out.println("'ac' 입력 시 모든 결과가 삭제됩니다.");
    System.out.println("=============================\n");
  }
}
