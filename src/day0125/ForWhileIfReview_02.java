package day0125;

import java.util.Scanner;

public class ForWhileIfReview_02 {
	
	//���ڸ� �Է½� ���丮�� ���� ����ϱ�
	//5�Է½� 5!=120
	public static void scanfactorialEx_01() {
		
		Scanner sc = new Scanner(System.in);
		
		int su;
		int result = 1;
		
		System.out.println("���丮�� ���� ���ڸ� �Է�");
		su = sc.nextInt();
		
		for(int i=1; i<=su; i++) {
			result *= i;
		}
		
		System.out.println(su + "! = " + result);
		
	}
	
	// �达�� �������?
	// String class���� equals,startswith ���
	public static void stringEqualsStartswith() {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int cnt = 0;
		
		while(true) {
			System.out.println("�̸��Է�(����=��)");
			name = sc.nextLine();
			
//			if(name == "��")		//�߸��� ���, ==�� ������ ��!! 
			if(name.equals("��"))
				break;
			
			if(name.startsWith("��"))
				cnt++;
		}
		
		System.out.println("�达�� " + cnt + "�� �Դϴ�");
		
	}
	
	public static void scanWhileTrueEx_02() {
		
		/*
		 * �հ踦 ���� ���ڸ� �Է��Ͻÿ�
		 * 10
		 * 1~10������ ���� 55�Դϴ�
		 * while(true) �̿��� ��
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int n; //�հ踦 ���� ����
		int sum = 0; //�հ�
		
		System.out.println("�հ踦 ���� ���ڸ� �Է��Ͻÿ�");
		n = sc.nextInt();
		
		int i = n;
		
		while(true) {
			sum += i;
			
			i--;
			
			if(i==0)
				break;
		}
		
		System.out.println("1~" + n + "������ ���� " + sum + "�Դϴ�");
		
	}

	public static void main(String[] args) {
		
//		scanfactorialEx_01();
//		stringEqualsStartswith();
		scanWhileTrueEx_02();
		
	}
	
}
