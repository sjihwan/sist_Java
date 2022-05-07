package day0124;

import java.util.Scanner;

public class ScanDanEx_07 {

	public static void main(String[] args) {
		
		/*
		 * 구구단 중 원하는 단만 출력할 것
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int dan;
		
		System.out.println("원하는 구구단은?");
		dan = sc.nextInt();
		
		//조건문(숫자의 범위를 줄 경우, 제어문을 사용가능)
		//예: 2~9단까지만 구하시오..범위를 벗어나면 끝
		if(dan<2 || dan>9) { //||(OR) 연산자
			System.out.println("범위가 아닌 숫자입니다. 종료합니다");
			return; //메인메서드 종료
		}
		
		System.out.println("***" + dan + "단***");
		
		for(int i = 1; i<=9; i++) {
//			System.out.println(dan + "X" + i + "=" + dan * i);
			System.out.printf("%d X %d = %2d\n", dan,i,dan*i); //%2d: 자리수 2개,오른쪽 정렬처럼 출력
			
		}
		
	}
	
}
