package main.com.Sparta.Calculator.Utils;

import java.util.ArrayList;

public class ConvertToNumberList {
  //  속성
  private String[] userInputArray;
  private ArrayList<Object> arrayList;
  double value1;
  double value2;

  //  생성자
  public ConvertToNumberList(String[] userInputArray) {
    this.userInputArray = userInputArray;
    this.arrayList = new ArrayList<>();
  }

  //  기능
  /**
   * 숫자를 형변환하고 ArrayList에 추가
   *
   * @param userInputArray 띄어쓰기를 제외한 숫자, 연산자
   * @return [숫자(int), 연산자(String), 숫자(int)] 형태로 변환한 ArrayList
   */
  public ArrayList<Object> convert(String[] userInputArray) {
    value1 = Double.parseDouble(userInputArray[0]);

    if (userInputArray.length == 3) {
      value2 = Double.parseDouble(userInputArray[2]);
    }

    arrayList.add(value1);
    arrayList.add(userInputArray[1]);
    arrayList.add(value2);

    return arrayList;
  }
}
