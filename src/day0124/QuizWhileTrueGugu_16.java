package day0124;

import java.util.Scanner;

public class QuizWhileTrueGugu_16 {

	public static void main(String[] args) {
		
		/*
		 * while(true)
		 * 0이라고 입력시 종료
		 * 단은 2~9단까지만 입력할 것(continue이용)
		 * 
		 * 단을 입력하시오(종료:0)
		 * [5단]
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int dan;  //몇단?

		//while(true) 반복문
		while(true) {
			System.out.print("단을 입력하시오(종료:0): ");
			dan = sc.nextInt();
			
			if(dan == 0) {  //0 입력시 종료
				System.out.print("종료합니다");
				break;
			}			
			
			if(dan<2 || dan>9) {
				System.out.println("2~9사이의 숫자를 다시 입력하시오");
				continue;  //반복문 처음으로
			}
			
			System.out.printf("[%d단]\n", dan);
			
			for(int i=1; i<=9; i++) {
				System.out.println(dan + "X" + i + "=" + (dan*i));
			}
		}
		
	}

}
