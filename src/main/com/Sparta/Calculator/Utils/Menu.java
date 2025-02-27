package main.com.Sparta.Calculator.Utils;

public class Menu {

  //  속성
  private final String userInput;
  private final ResultManager resultManager;

  //  생성자
  public Menu(String userInput, ResultManager resultManager) {
    this.userInput = userInput;
    this.resultManager = resultManager;
  }

  //  기능

  /**
   * 사용자 입력이 커맨드인지 판단
   *
   * @return 특정 커맨드 포함 시 true
   */
  public boolean isCommand() {
    return switch (userInput) {
      case "help", "ls", "a", "ac" -> true;
      default -> false;
    };
  }

  // 커맨드 별 기능 동작
  public void handleCommands() {
    switch (userInput) {
      case "help" -> printInstructions();
      case "ls" -> displayResults();
      case "a" -> removeResult();
      case "ac" -> removeAllResults();
    }
  }

  /**
   * 사용자 입력이 'exit'인지 판단
   *
   * @return 사용자 입력이 'exit'일 경우 true
   */
  public boolean isExit() {
    if (userInput.contains("exit")) {
      System.out.println("프로그램을 종료합니다.");
      return true;
    }
    return false;
  }

  // 저장된 결과 출력
  public void displayResults() {
    if (resultManager.getResult().isEmpty()) {
      printNoResultsMessage();
    } else {
      System.out.println("\n저장된 결과: " + resultManager.getResult());
      System.out.println("\n=============================\n");
    }
  }

  // 가장 먼저 저장된 결과 삭제
  public void removeResult() {
    if (resultManager.getResult().isEmpty()) {
      printNoResultsMessage();
    } else {
      System.out.println("\n" + resultManager.getResult().get(0) + " 이 삭제되었습니다.");
      System.out.println("\n=============================\n");
      resultManager.getResult().remove(0);
    }
  }

  // 모든 결과 삭제
  public void removeAllResults() {
    if (resultManager.getResult().isEmpty()) {
      printNoResultsMessage();
    } else {
      System.out.println("\n모든 결과가 삭제되었습니다.");
      System.out.println("\n=============================\n");
      resultManager.getResult().clear();
    }
  }

  // 저장된 결과가 없을 때 출력하는 메세지
  public void printNoResultsMessage() {
    System.out.println("\n저장된 계산 결과가 없습니다.");
    System.out.println("\n=============================\n");
  }

  // 안내 문구 출력
  private void printInstructions() {
    System.out.println("\n안내 문구를 출력합니다.");
    System.out.println("\n=============입력=============");
    System.out.println("임력 예시: 1 + 2 (띄어쓰기 구분 없음)");
    System.out.println("덧셈: 1 + 2");
    System.out.println("뺄셈: 1 - 2");
    System.out.println("곱셈: 1 * 2");
    System.out.println("나눗셈: 1 / 2");
    System.out.println("나머지 연산: 1 % 2");
    System.out.println("제곱: 1 ^ 2");
    System.out.println("============================\n");

    System.out.println("\n=============명령어=============");
    System.out.println("'exit' 입력 시 프로그램이 종료됩니다.");
    System.out.println("'ls' 입력 시 저장된 모든 결과를 출력합니다.");
    System.out.println("'a' 입력 시 가장 먼저 저장된 결과가 삭제됩니다.");
    System.out.println("'ac' 입력 시 모든 결과가 삭제됩니다.");
    System.out.println("=============================\n");
  }
}