package day0120;

import java.util.Scanner;

public class QuizOper_04 {

	public static void main(String[] args) {

		/*
		 * ���޿��� �Է��Ͽ� ����,õ��,���,�ʿ�,�Ͽ� ������ ���Ͻÿ�
		 * ��)�ݾ��� �Է�
		 * 1234567
		 * ����: 123
		 * õ��: 4
		 * ���: 5
		 * �ʿ�: 6
		 * �Ͽ�: 7
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ݾ��� �Է�");
		int pay = sc.nextInt();
		
		//���� ����
		System.out.println("����: " + pay/10000);
		//õ�� ����
		System.out.println("õ��: " + (pay%10000)/1000);
		//��� ����
		System.out.println("���: " + (pay%1000)/100);
		//�ʿ� ����
		System.out.println("�ʿ�: " + (pay%100)/10);
		//�Ͽ� ����
		System.out.println("�Ͽ�: " + (pay%10));
		//������ ������%�� Ȱ��
		
		sc.close();
				
	}

}
