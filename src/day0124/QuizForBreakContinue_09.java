package day0124;

import java.util.Scanner;

public class QuizForBreakContinue_09 {

	public static void main(String[] args) {
		
		/*
		 * 총 5개의 점수를 입력받아서 합계를 구한다(반복문에서 입력하기)
		 * 만약 1~100이 아닐경우 다시 입력받으시오(continue 사용)...반복문에서 잘못입력 빼기
		 * for문 안에 if문
		 * 1번 점수: 88
		 * 2번 점수: -77
		 * 			잘못입력했어요
		 * 2번 점수: 99
		 * 
		 * 
		 * 5번 점수: 55
		 * 총점:
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int score;		//점수
		int total = 0;	//총점
		
		//반복문
		for(int n=1; n<=5; n++) {
			System.out.print(n + "번 점수: ");
			score = sc.nextInt();
			
			if(score < 1 || score > 100) {				
				System.out.println("잘못입력했어요");
				n--;
				continue;
			}
			
			total += score;	//if조건문을 거쳐 총점에 점수를 더한다
		}
		System.out.println("총점: " + total);
		
	}
	
}
