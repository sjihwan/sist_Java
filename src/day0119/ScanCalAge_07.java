package day0119;

import java.util.Calendar;
import java.util.Scanner;

public class ScanCalAge_07 {

	public static void main(String[] args) {

		/*
		 * Q. Scanner, Calendar를 import받아 완성하시오
		 * 키보드로 입력받는건 name, myYear
		 * 
		 * 출력은 요렇게
		 * 현재년도: 2022년
		 * 당신의 이름은? 신지환
		 * 태어난 년도는? 1997
		 * ----------------------
		 * 신지환님은 1997년생이며 26세입니다
		 */
		
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		//Scanner로 입력
		System.out.println("당신의 이름은?");
		String name = sc.nextLine();
		System.out.println("당신의 태어난 년도는?");
		int myYear = Integer.parseInt(sc.nextLine());
		
		//현재년도
		int curYear = cal.get(Calendar.YEAR);

		//현재나이 계산
		int age = curYear - myYear + 1;
		
		System.out.println("현재년도: " + cal.get(Calendar.YEAR) + "년");
		System.out.println("당신의 이름은? " + name);
		System.out.println("태어난 년도는? " + myYear);
		System.out.println("----------------------");
		System.out.println(name + "님은 " + myYear + "년생이며 " + age + "세입니다");
		
		sc.close();
		
	}

}
