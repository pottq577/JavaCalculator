import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("수식을 입력해주세요.");
    System.out.println("예시: 1 + 2");
    System.out.print("입력: ");
    String userInput = scanner.nextLine();
    String[] userInputArray;

    /**
     * 사용자로부터 입력받은 문자열에서
     * 숫자 부분과 연산자 부분을 분리하는 코드
     */
    if(userInput.contains(" ")){
      userInputArray = userInput.split(" ");
    } else{
      userInputArray = userInput.split("");
    }

    for(int i = 0; i < userInputArray.length; i++){
      System.out.println(userInputArray[i]);
    }
  }
}