package day0121;

import java.util.Scanner;

public class SwitchScoreEx_06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int score;		//����
		String grade;	//����(���)
		String msg;		//�޽���(�ڸ�Ʈ)
		
		System.out.println("����� ������?");
		score = sc.nextInt();
		
		//���� ���
		System.out.println("����� ������ " + score + "�� �Դϴ�");
		
		//switch��
		switch (score/10) {
		case 10: case 9: //score/10�� 10�̰ų� 9�̸�..
			grade = "A";
			break;
		case 8:
			grade = "B";			
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		System.out.println("������ " + grade + "�Դϴ�");
		
		//���׿����ڸ� ���� �ڸ�Ʈ ���
		msg = grade == "A"? "�հ��Դϴ�" :
			  grade == "B"? "���� ����ϼ���" : "������ȸ��";
		System.out.println(msg);
		
	}
	
}
