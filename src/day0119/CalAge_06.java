package day0119;

import java.util.Calendar;

public class CalAge_06 {

	public static void main(String[] args) {

		//Calendar를 이용하여 본인의 나이를 구하자
		
		Calendar cal = Calendar.getInstance();
		
		int curYear = cal.get(Calendar.YEAR); //현재년도
		
		//String타입의 입력받은 인자값을 받아 나이를 계산하기 위해 String->Int 캐스팅
		int myYear = Integer.parseInt(args[0]);
		
		//나이 구하기(한국기준)
		int myAge = curYear - myYear + 1;
		
		//출력
		System.out.println("태어난 년도: " + myYear + "년생");
		System.out.println("현재 나이: " + myAge + "세");
		
	}

}
