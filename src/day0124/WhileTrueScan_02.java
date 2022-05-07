package day0124;

import java.util.Scanner;

public class WhileTrueScan_02 {

	public static void main(String[] args) {
		
		/*
		 * 합계를 구할 숫자를 입력하시오
		 * 10
		 * 1~10까지의 합: 55
		 * while(true) 이용할 것!!
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int su; //입력할 수
		int i = 0;
		int sum = 0;
		
		System.out.println("합계를 구할 숫자를 입력하시오");
		su = sc.nextInt();
		
		//반복문
		while(true) {
			sum+=i;
			i++;
			if(i>su)
				break;
		}
		
		//출력
 		System.out.println("1~" + su + "까지의 합: " + sum);
// 		System.out.println(i);
 		
	}
	
}
