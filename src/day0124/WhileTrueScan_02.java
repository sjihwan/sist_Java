package day0124;

import java.util.Scanner;

public class WhileTrueScan_02 {

	public static void main(String[] args) {
		
		/*
		 * �հ踦 ���� ���ڸ� �Է��Ͻÿ�
		 * 10
		 * 1~10������ ��: 55
		 * while(true) �̿��� ��!!
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int su; //�Է��� ��
		int i = 0;
		int sum = 0;
		
		System.out.println("�հ踦 ���� ���ڸ� �Է��Ͻÿ�");
		su = sc.nextInt();
		
		//�ݺ���
		while(true) {
			sum+=i;
			i++;
			if(i>su)
				break;
		}
		
		//���
 		System.out.println("1~" + su + "������ ��: " + sum);
// 		System.out.println(i);
 		
	}
	
}
