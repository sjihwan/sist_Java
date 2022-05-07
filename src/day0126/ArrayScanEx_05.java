package day0126;

import java.util.Scanner;

public class ArrayScanEx_05 {

	public static void main(String[] args) {
		//배열의 범위만큼 입력후 출력해보자
		Scanner sc = new Scanner(System.in);
		
		int data[] = new int[5];
		
		//해당 인덱스 번호에 입력
		for(int i=0; i<data.length; i++) {
			System.out.print((i+1) + "번째 값: "); //1~5번째 값:
			data[i] = sc.nextInt(); //인덱스 0~4에 값 입력
		}
		
		//입력값 출력
		System.out.println("**입력값 확인**");
		for(int i=0; i<data.length; i++) {
			System.out.println((i+1) + " ===> " + data[i]);
		}
		
		/*
		 * Quiz.
		 * 입력한 데이터의
		 * 총합계: ***
		 */
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		System.out.println("총합계: " + sum);

	}

}
