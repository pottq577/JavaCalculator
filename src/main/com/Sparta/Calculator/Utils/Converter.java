package main.com.Sparta.Calculator.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Converter {
  //  속성
  private final String[] userInputArray;
  private final ArrayList<Object> arrayList;

  //  생성자
  public Converter(String[] userInputArray) {
    this.userInputArray = userInputArray;
    this.arrayList = new ArrayList<>();
  }

  //  기능
  /**
   * arrayList에 변환한 데이터 추가
   * @param value1
   * @param operator
   * @param value2
   */
  private void addToArrayList(double value1, String operator, double value2) {
    arrayList.add(value1);
    arrayList.add(operator);
    arrayList.add(value2);
  }

  /**
   * 숫자와 연산자를 변환하여 ArrayList에 추가
   *
   * @return [숫자(int), 연산자(String), 숫자(int)] 형태로 변환한 ArrayList
   */
  public ArrayList<Object> convertStringToNumberArray() {
    double value1 = Double.parseDouble(userInputArray[0]);
    double value2 = 0;
    if (userInputArray.length == 3) {
      value2 = Double.parseDouble(userInputArray[2]);
    }
    String operator = userInputArray[1];
    addToArrayList(value1, operator, value2);

    return arrayList;
  }

}
