package day0127;

import java.util.Scanner;

public class QuizReview_01 {

	public static void main(String[] args) {
		/*
		 * Scanner�� ���ڸ� �Է¹޾� �迭�� ���° �ִ��� ����ϼ���
		 * ������� ���ٰ� ����ϼ���
		 * 0�� �Է½� ����
		 * �Է°�: 11
		 * 		11�� 2��° �־��!!
		 * �Է°�: 23
		 * 		23�� 6��° �־��!!
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = {6,11,45,66,78,23,88,77,100};
		int count = 0;
		boolean find;
		
		while(true) {
			count++;
			System.out.print("�Է°�"+count+"(����:0): ");
			int n = sc.nextInt();
			
			if(n==0) {
				System.out.println("\t�����մϴ�");
				break;
			}
			
			find = false;
			
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==n) {
					find = true;
					System.out.println("\t"+n+"�� "+(i+1)+"��° �־��!!");
				}
			}
			
			if(!find) {
				System.out.println("\t"+n+"�� �����!!");
			}
		}

	}

}