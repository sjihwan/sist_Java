package day0121;

import java.util.Scanner;

public class SwitchEx_05 {

	public static void main(String[] args) {
		
		//���� ����
		Scanner sc = new Scanner(System.in);
		int num;
		
		//�Է�
		System.out.println("���ڸ� �Է����ּ���");
		num = sc.nextInt();
		
		//Switch��: 1,2,3�� �Է��ߴ���
		switch(num) {
		case 1: //num�� ���� 1���� ��
			System.out.println("input 1");
			break;
		case 2:
			System.out.println("input 2");
			break;
		case 3:
			System.out.println("input 3");
			break;
		default:
			System.out.println("not 1,2,3");
			break;
		}
		
		//switch��: Ȧ������,¦������
		switch(num%2) {
		case 0: //num%2�� 0���� ��
			System.out.println(num+"�� ¦��");
			break;
		case 1:
			System.out.println(num+"�� Ȧ��");
			break;
		}
		
	}
	
}
