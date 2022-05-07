package day0125;

import java.util.Scanner;

public class ForWhileReview_01 {
	
	//for���� 1~5���� ���ϱ�
	public static void test1() {
		
		int sum = 0;
		
		for(int i=1; i<=5; i++) {
			sum += i;
		}
		
		System.out.println("���հ�� " + sum + "�Դϴ�");
		
	}
	
	//1~10������ Ȧ���� ��
	public static void test2() {
		
		int odd_sum = 0;
		
		for(int i=1; i<=10; i++) {
			if(i%2!=0) {
				odd_sum += i;
			}
		}
		
		System.out.println("���հ�� " + odd_sum + "�Դϴ�");
		
	}
	
	//10������ ���� 55�Դϴ�
	public static void test3() {
		
		int sum = 0;
		int i = 0;
		
		for(i=1; i<=10; i++) {
			sum += i;
		}
		
		System.out.println((i-1) + "������ ���� " + sum + "�Դϴ�");
		
	}
	
	//1~10������ ¦���� ��
	//while(true)
	//continue
	public static void whileTest4() {
		
		int i = 0;
		int sum = 0;
		
		while(true) {
			i++;
			
			if(i%2==1)
				continue;
			
			sum += i;
			
			if(i==10)
				break;
		}
		
		System.out.println("1~" + i + "������ ���� " + sum);
		
	}
	
	public static void ScanSum_05() {
		
		// for, continue
		// 3��° �������� �Է��ϸ� �հ� ����Ͻÿ�
		// ������ �����̸� "�߸��� �����Դϴ�" ���
		// �ùٸ� ������ ��3���� �Ǿ� �Ѵ�
		
		Scanner sc = new Scanner(System.in);
		
		int score;
		int sum = 0;
		
		for(int i=1; i<=3; i++) {
			System.out.println(i + "��° ������ �Է��Ͻÿ�");
			score = sc.nextInt();
			
			if(score<0 || score>100) {
				System.out.println("�߸��� �����Դϴ�");
				i--;
				continue;
			}
			
			sum += score;
		}
		
		System.out.println("���հ�� " + sum + "�� �Դϴ�");
		
	}

	public static void main(String[] args) {
		
		test1(); // test1() �޼��� ȣ��
		test2();
		test3();
		whileTest4();
		ScanSum_05();

	}
	
}
