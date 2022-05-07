package day0127;

import java.util.Scanner;

public class QuizReview_01 {

	public static void main(String[] args) {
		/*
		 * Scanner로 숫자를 입력받아 배열에 몇번째 있는지 출력하세요
		 * 없을경우 없다고 출력하세요
		 * 0을 입력시 종료
		 * 입력값: 11
		 * 		11은 2번째 있어요!!
		 * 입력값: 23
		 * 		23은 6번째 있어요!!
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = {6,11,45,66,78,23,88,77,100};
		int count = 0;
		boolean find;
		
		while(true) {
			count++;
			System.out.print("입력값"+count+"(종료:0): ");
			int n = sc.nextInt();
			
			if(n==0) {
				System.out.println("\t종료합니다");
				break;
			}
			
			find = false;
			
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==n) {
					find = true;
					System.out.println("\t"+n+"은 "+(i+1)+"번째 있어요!!");
				}
			}
			
			if(!find) {
				System.out.println("\t"+n+"은 없어요!!");
			}
		}

	}

}