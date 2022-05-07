package day0121;

import java.util.Scanner;

public class SwitchEx_05 {

	public static void main(String[] args) {
		
		//변수 선언
		Scanner sc = new Scanner(System.in);
		int num;
		
		//입력
		System.out.println("숫자를 입력해주세요");
		num = sc.nextInt();
		
		//Switch문: 1,2,3을 입력했는지
		switch(num) {
		case 1: //num이 숫자 1인지 비교
			System.out.println("input 1");
			break;
		case 2:
			System.out.println("input 2");
			break;
		case 3:
			System.out.println("input 3");
			break;
		default:
			System.out.println("not 1,2,3");
			break;
		}
		
		//switch문: 홀수인지,짝수인지
		switch(num%2) {
		case 0: //num%2가 0인지 비교
			System.out.println(num+"은 짝수");
			break;
		case 1:
			System.out.println(num+"은 홀수");
			break;
		}
		
	}
	
}
