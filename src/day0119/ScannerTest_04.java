package day0119;

import java.util.Scanner;  //Scanner클래스 가져오기

public class ScannerTest_04 {

	public static void main(String[] args) {
		
		//Scanner라는 클래스는 문자열이나 숫자 모두 키보드로 입력받으려 할때 생성
		
		//Scanner타입의 참조변수sc에 Scanner라는 입력객체 생성
		Scanner sc = new Scanner(System.in);
		
		//변수선언
		String name;
		int age;
		String city;
		
		//입력에 관한 출력가이드문 -> 키보드 입력
		System.out.print("이름을 입력해보세요==>");
		
		//스캐너의 nextLine()메서드
		//한 라인을 문자로 읽어온다(공백 사용가능)
		name = sc.nextLine();
		
		System.out.print("당신의 나이는 몇살?==>");
		age = Integer.parseInt(sc.nextLine());
		
		System.out.println("사시는 지역은?==>");
		city = sc.nextLine();
		
		//출력
		System.out.println("나의 이름은 " + name + "입니다");
		System.out.println("나의 나이는 " + age + "세 입니다");
		System.out.println("나는 " + city + " 지역에 살아요");
		
		sc.close();
		
	}

}
