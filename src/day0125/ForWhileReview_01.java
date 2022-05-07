package day0125;

import java.util.Scanner;

public class ForWhileReview_01 {
	
	//for문을 1~5까지 더하기
	public static void test1() {
		
		int sum = 0;
		
		for(int i=1; i<=5; i++) {
			sum += i;
		}
		
		System.out.println("총합계는 " + sum + "입니다");
		
	}
	
	//1~10까지의 홀수의 합
	public static void test2() {
		
		int odd_sum = 0;
		
		for(int i=1; i<=10; i++) {
			if(i%2!=0) {
				odd_sum += i;
			}
		}
		
		System.out.println("총합계는 " + odd_sum + "입니다");
		
	}
	
	//10까지의 합은 55입니다
	public static void test3() {
		
		int sum = 0;
		int i = 0;
		
		for(i=1; i<=10; i++) {
			sum += i;
		}
		
		System.out.println((i-1) + "까지의 합은 " + sum + "입니다");
		
	}
	
	//1~10까지의 짝수의 합
	//while(true)
	//continue
	public static void whileTest4() {
		
		int i = 0;
		int sum = 0;
		
		while(true) {
			i++;
			
			if(i%2==1)
				continue;
			
			sum += i;
			
			if(i==10)
				break;
		}
		
		System.out.println("1~" + i + "까지의 합은 " + sum);
		
	}
	
	public static void ScanSum_05() {
		
		// for, continue
		// 3번째 점수까지 입력하면 합계 출력하시오
		// 점수가 음수이면 "잘못된 점수입니다" 출력
		// 올바른 점수만 총3번이 되야 한다
		
		Scanner sc = new Scanner(System.in);
		
		int score;
		int sum = 0;
		
		for(int i=1; i<=3; i++) {
			System.out.println(i + "번째 점수를 입력하시오");
			score = sc.nextInt();
			
			if(score<0 || score>100) {
				System.out.println("잘못된 점수입니다");
				i--;
				continue;
			}
			
			sum += score;
		}
		
		System.out.println("총합계는 " + sum + "점 입니다");
		
	}

	public static void main(String[] args) {
		
		test1(); // test1() 메서드 호출
		test2();
		test3();
		whileTest4();
		ScanSum_05();

	}
	
}
