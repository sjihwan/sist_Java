package day0124;

import java.util.Scanner;

public class QuizWhileTrueGugu_16 {

	public static void main(String[] args) {
		
		/*
		 * while(true)
		 * 0�̶�� �Է½� ����
		 * ���� 2~9�ܱ����� �Է��� ��(continue�̿�)
		 * 
		 * ���� �Է��Ͻÿ�(����:0)
		 * [5��]
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int dan;  //���?

		//while(true) �ݺ���
		while(true) {
			System.out.print("���� �Է��Ͻÿ�(����:0): ");
			dan = sc.nextInt();
			
			if(dan == 0) {  //0 �Է½� ����
				System.out.print("�����մϴ�");
				break;
			}			
			
			if(dan<2 || dan>9) {
				System.out.println("2~9������ ���ڸ� �ٽ� �Է��Ͻÿ�");
				continue;  //�ݺ��� ó������
			}
			
			System.out.printf("[%d��]\n", dan);
			
			for(int i=1; i<=9; i++) {
				System.out.println(dan + "X" + i + "=" + (dan*i));
			}
		}
		
	}

}
