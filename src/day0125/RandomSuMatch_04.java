package day0125;

import java.util.Scanner;

public class RandomSuMatch_04 {

	public static void main(String[] args) {
		
		// 여러회차에 걸쳐서 난수 알아맞추기(1~100)
		// 1: 77
		// 77보다 작습니다
		// 2: 66
		// 맞아요~정답은 66입니다.. 프로그램종료
		// while(true)
		
		Scanner sc= new Scanner(System.in);
		
		int rnd = (int)(Math.random()*100)+1;	//1~100사이의 난수 저장
		int su;									//입력할 값
		int cnt = 0; 							//입력한 횟수
		
		while(true) {
			cnt++; //카운트
			
			System.out.print(cnt + "회: ");
			su = sc.nextInt();
			
			if(su > rnd) {
				System.out.println(su+"보다 작습니다");
			}
			else if(su < rnd) {
				System.out.println(su+"보다 큽니다");
			}
			else {
				System.out.println("정답입니다~ " + rnd + "입니다~");
				break;
			}
		}
		
		System.out.println("프로그램 종료");
		
	}
	
}
