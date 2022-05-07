package day0121;

import java.util.Scanner;

public class CharAtEx_07 {

	public static void main(String[] args) {
		
		//Scanner객체의 주소를 참조하는 변수..sc
		Scanner sc = new Scanner(System.in);
		
		char ch;
		
		System.out.println("영문자열 입력");
		//charAt(0)...입력한 문자열의 첫글자 가져오기
		//문자열의 인덱스 번호를 이용하여 값을 가져온다
		ch = sc.nextLine().charAt(0);
		System.out.println("ch="+ch);
		
		switch(ch) {
		case 'a': //switch-case문은 대소문자를 구분한다
		case 'A':
			System.out.println("Apple");
			break;
		case 'b':
		case 'B':
			System.out.println("Banana");
			break;
		case 'o':
		case 'O':
			System.out.println("Orange");
			break;
		default:
			System.out.println("Other Fruits");	
		}
		
	}
	
}
