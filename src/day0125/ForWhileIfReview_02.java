package day0125;

import java.util.Scanner;

public class ForWhileIfReview_02 {
	
	//숫자를 입력시 팩토리얼 값을 출력하기
	//5입력시 5!=120
	public static void scanfactorialEx_01() {
		
		Scanner sc = new Scanner(System.in);
		
		int su;
		int result = 1;
		
		System.out.println("팩토리얼 구할 숫자를 입력");
		su = sc.nextInt();
		
		for(int i=1; i<=su; i++) {
			result *= i;
		}
		
		System.out.println(su + "! = " + result);
		
	}
	
	// 김씨가 몇명인지?
	// String class에서 equals,startswith 사용
	public static void stringEqualsStartswith() {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int cnt = 0;
		
		while(true) {
			System.out.println("이름입력(종료=끝)");
			name = sc.nextLine();
			
//			if(name == "끝")		//잘못된 방식, ==은 숫자형 비교!! 
			if(name.equals("끝"))
				break;
			
			if(name.startsWith("김"))
				cnt++;
		}
		
		System.out.println("김씨는 " + cnt + "명 입니다");
		
	}
	
	public static void scanWhileTrueEx_02() {
		
		/*
		 * 합계를 구할 숫자를 입력하시오
		 * 10
		 * 1~10까지의 합은 55입니다
		 * while(true) 이용할 것
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int n; //합계를 구할 숫자
		int sum = 0; //합계
		
		System.out.println("합계를 구할 숫자를 입력하시오");
		n = sc.nextInt();
		
		int i = n;
		
		while(true) {
			sum += i;
			
			i--;
			
			if(i==0)
				break;
		}
		
		System.out.println("1~" + n + "까지의 합은 " + sum + "입니다");
		
	}

	public static void main(String[] args) {
		
//		scanfactorialEx_01();
//		stringEqualsStartswith();
		scanWhileTrueEx_02();
		
	}
	
}
