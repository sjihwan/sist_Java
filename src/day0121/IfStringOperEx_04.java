package day0121;

import java.util.Scanner;

public class IfStringOperEx_04 {

	public static void main(String[] args) {
		
		// 문자열 비교는 관계연산자로 하면 안되고
		// equals라는 메서드를 사용해서 비교한다
		
		Scanner sc = new Scanner(System.in);
		
		String msg; //입력할 단어
		
		//입력가이드문
		System.out.println("영어단어를 입력하세요");
		System.out.println("입력단어 예시) happy,angel,rose,winter,summer");  //나의 사전
		
		msg = sc.nextLine();
		
		System.out.println("입력한 문자열: " + msg);
		
		//문자열 동등연산자로 비교하려면 주소비교를 함...값비교 equals메서드
		if(msg.equals("angel"))  //msg.equals(문자열) 반환값=> true,false
			System.out.println("***천사***");
		else if(msg.equalsIgnoreCase("happy")) //equals메서드는 대소문자 상관없이 같은걸로 인식
			System.out.println("***행복하다***");
		else if(msg.equals("rose"))
			System.out.println("***장미***");
		else if(msg.equals("winter"))
			System.out.println("***겨울***");
		else if(msg.equals("summer"))
			System.out.println("***여름***");
		else
			System.out.println("***나의 사전에 등록이 안된 문자열입니다***");
		
	}
	
}
