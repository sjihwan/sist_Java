package day0125;

import java.util.Scanner;

public class QuizOperEx_05 {
	
	public static void ex_01() {
		
		/*
		 * for������ 10�� ������ ��
		 * 1: 21
		 * 2: -23
		 * 
		 * 10: 88
		 * ===================
		 * �������: 4
		 * ��������: 6
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int su;			//�� �Է�	
		int pcnt = 0;	//��� ����
		int ncnt = 0;	//���� ����
		
		for(int i=1; i<=10; i++) {
			System.out.print(i + ": ");
			su = sc.nextInt();
			
			if(su>0) {
				pcnt++;
			}
			else if(su<0) {
				ncnt++;
			}
			else {
				System.out.println("0�Դϴ�");
			}
		}
		
		System.out.println("����� ����: " + pcnt);
		System.out.println("������ ����: " + ncnt);
		
	}
	
	public static void ex_02() {
		
		/*
		 * while(true)
		 * continue�� �̿��Ͽ� 1~100������ ¦���� ���� ���Ͻÿ�
		 * 1~100������ ¦���� ��: 
		 */
		
		int n = 0;
		int sum = 0;
		
		while(true) {
			n++;
			
			if(n%2==0)
				sum += n;
			
			if(n==100)
				break;
		}
		
		System.out.println("1~100������ ¦���� ��: " + sum);
		
	}
	
	public static void ex_03() {
		
		/*
		 * while(true)
		 * 1~100������ 3�� ����� ������ ī��Ʈ 
		 */
		
		int n = 1;
		int cnt_3 = 0;
		
		while(true) {
			if(n%3==0) {
				cnt_3++;
			}
			
			n++;
			
			if(n>100)
				break;
		}
		
		System.out.println("1~100������ 3�� ����� ����: " + cnt_3);
		
	}
	
	public static void ex_04() {
		
		/*
		 * while(true)
		 * 1~10���� ���丮�� ���Ұ�
		 * 1! = ---
		 * 10! = ---
		 */
		
		int n = 1;
		int result = 1;

		while(true) {
			result *= n;
			
			System.out.println(n + "!= " + result);
			
			n++;
			
			if(n>10)
				break;
		}
	}

	public static void main(String[] args) {
		
//		ex_01();
//		ex_02();
//		ex_03();
		ex_04();
		
	}
	
}
