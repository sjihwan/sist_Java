package day0126;

import java.util.Scanner;

public class ArrayScanEx_05 {

	public static void main(String[] args) {
		//�迭�� ������ŭ �Է��� ����غ���
		Scanner sc = new Scanner(System.in);
		
		int data[] = new int[5];
		
		//�ش� �ε��� ��ȣ�� �Է�
		for(int i=0; i<data.length; i++) {
			System.out.print((i+1) + "��° ��: "); //1~5��° ��:
			data[i] = sc.nextInt(); //�ε��� 0~4�� �� �Է�
		}
		
		//�Է°� ���
		System.out.println("**�Է°� Ȯ��**");
		for(int i=0; i<data.length; i++) {
			System.out.println((i+1) + " ===> " + data[i]);
		}
		
		/*
		 * Quiz.
		 * �Է��� ��������
		 * ���հ�: ***
		 */
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		System.out.println("���հ�: " + sum);

	}

}
