package day0124;

import java.util.Scanner;

public class QuizForBreakContinue_09 {

	public static void main(String[] args) {
		
		/*
		 * �� 5���� ������ �Է¹޾Ƽ� �հ踦 ���Ѵ�(�ݺ������� �Է��ϱ�)
		 * ���� 1~100�� �ƴҰ�� �ٽ� �Է¹����ÿ�(continue ���)...�ݺ������� �߸��Է� ����
		 * for�� �ȿ� if��
		 * 1�� ����: 88
		 * 2�� ����: -77
		 * 			�߸��Է��߾��
		 * 2�� ����: 99
		 * 
		 * 
		 * 5�� ����: 55
		 * ����:
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int score;		//����
		int total = 0;	//����
		
		//�ݺ���
		for(int n=1; n<=5; n++) {
			System.out.print(n + "�� ����: ");
			score = sc.nextInt();
			
			if(score < 1 || score > 100) {				
				System.out.println("�߸��Է��߾��");
				n--;
				continue;
			}
			
			total += score;	//if���ǹ��� ���� ������ ������ ���Ѵ�
		}
		System.out.println("����: " + total);
		
	}
	
}
