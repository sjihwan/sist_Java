package day0121;

import java.util.Scanner;

public class CharAtEx_07 {

	public static void main(String[] args) {
		
		//Scanner��ü�� �ּҸ� �����ϴ� ����..sc
		Scanner sc = new Scanner(System.in);
		
		char ch;
		
		System.out.println("�����ڿ� �Է�");
		//charAt(0)...�Է��� ���ڿ��� ù���� ��������
		//���ڿ��� �ε��� ��ȣ�� �̿��Ͽ� ���� �����´�
		ch = sc.nextLine().charAt(0);
		System.out.println("ch="+ch);
		
		switch(ch) {
		case 'a': //switch-case���� ��ҹ��ڸ� �����Ѵ�
		case 'A':
			System.out.println("Apple");
			break;
		case 'b':
		case 'B':
			System.out.println("Banana");
			break;
		case 'o':
		case 'O':
			System.out.println("Orange");
			break;
		default:
			System.out.println("Other Fruits");	
		}
		
	}
	
}
