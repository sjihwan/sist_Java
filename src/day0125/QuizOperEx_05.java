package day0125;

import java.util.Scanner;

public class QuizOperEx_05 {
	
	public static void ex_01() {
		
		/*
		 * for문으로 10번 질문할 것
		 * 1: 21
		 * 2: -23
		 * 
		 * 10: 88
		 * ===================
		 * 양수갯수: 4
		 * 음수갯수: 6
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int su;			//수 입력	
		int pcnt = 0;	//양수 개수
		int ncnt = 0;	//음수 개수
		
		for(int i=1; i<=10; i++) {
			System.out.print(i + ": ");
			su = sc.nextInt();
			
			if(su>0) {
				pcnt++;
			}
			else if(su<0) {
				ncnt++;
			}
			else {
				System.out.println("0입니다");
			}
		}
		
		System.out.println("양수의 갯수: " + pcnt);
		System.out.println("음수의 갯수: " + ncnt);
		
	}
	
	public static void ex_02() {
		
		/*
		 * while(true)
		 * continue를 이용하여 1~100까지의 짝수의 합을 구하시오
		 * 1~100까지의 짝수의 합: 
		 */
		
		int n = 0;
		int sum = 0;
		
		while(true) {
			n++;
			
			if(n%2==0)
				sum += n;
			
			if(n==100)
				break;
		}
		
		System.out.println("1~100까지의 짝수의 합: " + sum);
		
	}
	
	public static void ex_03() {
		
		/*
		 * while(true)
		 * 1~100까지의 3의 배수의 갯수를 카운트 
		 */
		
		int n = 1;
		int cnt_3 = 0;
		
		while(true) {
			if(n%3==0) {
				cnt_3++;
			}
			
			n++;
			
			if(n>100)
				break;
		}
		
		System.out.println("1~100까지의 3의 배수의 갯수: " + cnt_3);
		
	}
	
	public static void ex_04() {
		
		/*
		 * while(true)
		 * 1~10까지 팩토리얼 구할것
		 * 1! = ---
		 * 10! = ---
		 */
		
		int n = 1;
		int result = 1;

		while(true) {
			result *= n;
			
			System.out.println(n + "!= " + result);
			
			n++;
			
			if(n>10)
				break;
		}
	}

	public static void main(String[] args) {
		
//		ex_01();
//		ex_02();
//		ex_03();
		ex_04();
		
	}
	
}
