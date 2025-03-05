package main.com.Sparta.Calculator.Utils;

public class Menu {

  private static final String EXIT_MESSAGE = "\n프로그램을 종료합니다.";
  private static final String NO_RESULTS = "\n저장된 계산 결과가 없습니다.\n";
  private static final String ALL_RESULT_DELETED = "\n모든 결과가 삭제되었습니다.\n";
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

  /**
   * 사용자 입력이 'exit'인지 판단
   *
   * @return 사용자 입력이 'exit'일 경우 true
   */
  public boolean isExit() {
    if (userInput.contains("exit")) {
      System.out.println(EXIT_MESSAGE);
      return true;
    }
    return false;
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

  // 저장된 결과 출력
  public void displayResults() {
    if (resultManager.getResult().isEmpty()) {
      System.out.println(NO_RESULTS);
      printFooter();
    } else {
      System.out.println("\n저장된 결과: " + resultManager.getResult() + "\n");
      printFooter();
    }
  }

  // 가장 먼저 저장된 결과 삭제
  public void removeResult() {
    if (resultManager.getResult().isEmpty()) {
      System.out.println(NO_RESULTS);
      printFooter();
    } else {
      System.out.println("\n" + resultManager.getResult().get(0) + " 이 삭제되었습니다.\n");
      printFooter();
      resultManager.getResult().remove(0);
    }
  }

  // 모든 결과 삭제
  public void removeAllResults() {
    if (resultManager.getResult().isEmpty()) {
      System.out.println(NO_RESULTS);
      printFooter();
    } else {
      System.out.println(ALL_RESULT_DELETED);
      printFooter();
      resultManager.getResult().clear();
    }
  }

  // 안내 문구 출력
  private void printInstructions() {
    printHeader("사용 방법");
    System.out.printf("%-5s - %s%n", "입력 예", "1+2, 3-1, 4*2, 8/4");
    System.out.printf("%-5s - %s%n", "연산자", "+, -, *, /, %, ^");
    printFooter();

    printHeader("명령어");
    System.out.printf("%-5s - %s%n", "exit", "프로그램 종료");
    System.out.printf("%-5s - %s%n", "ls", "저장된 결과 출력");
    System.out.printf("%-5s - %s%n", "a", "가장 먼저 저장된 결과 삭제");
    System.out.printf("%-5s - %s%n", "ac", "모든 결과 삭제");
    printFooter();
  }

  // 구분선을 출력하는 메서드
  private void printHeader(String title) {
    String line = "=".repeat(30);
    System.out.println("\n" + line);
    System.out.printf("%-" + (30 / 2 + title.length() / 2) + "s%n", title);
    System.out.println(line);
  }

  private void printFooter() {
    System.out.println("=".repeat(30));
  }
}