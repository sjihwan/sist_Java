package day0120;

import java.util.Scanner;

public class QuizOper_04 {

	public static void main(String[] args) {

		/*
		 * 월급여를 입력하여 만원,천원,백원,십원,일원 갯수를 구하시오
		 * 예)금액을 입력
		 * 1234567
		 * 만원: 123
		 * 천원: 4
		 * 백원: 5
		 * 십원: 6
		 * 일원: 7
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("금액을 입력");
		int pay = sc.nextInt();
		
		//만원 갯수
		System.out.println("만원: " + pay/10000);
		//천원 갯수
		System.out.println("천원: " + (pay%10000)/1000);
		//백원 갯수
		System.out.println("백원: " + (pay%1000)/100);
		//십원 갯수
		System.out.println("십원: " + (pay%100)/10);
		//일원 갯수
		System.out.println("일원: " + (pay%10));
		//나머지 연산자%를 활용
		
		sc.close();
				
	}

}
