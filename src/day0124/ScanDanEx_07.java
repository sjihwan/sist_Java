package day0124;

import java.util.Scanner;

public class ScanDanEx_07 {

	public static void main(String[] args) {
		
		/*
		 * ������ �� ���ϴ� �ܸ� ����� ��
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int dan;
		
		System.out.println("���ϴ� ��������?");
		dan = sc.nextInt();
		
		//���ǹ�(������ ������ �� ���, ����� ��밡��)
		//��: 2~9�ܱ����� ���Ͻÿ�..������ ����� ��
		if(dan<2 || dan>9) { //||(OR) ������
			System.out.println("������ �ƴ� �����Դϴ�. �����մϴ�");
			return; //���θ޼��� ����
		}
		
		System.out.println("***" + dan + "��***");
		
		for(int i = 1; i<=9; i++) {
//			System.out.println(dan + "X" + i + "=" + dan * i);
			System.out.printf("%d X %d = %2d\n", dan,i,dan*i); //%2d: �ڸ��� 2��,������ ����ó�� ���
			
		}
		
	}
	
}
