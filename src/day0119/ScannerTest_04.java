package day0119;

import java.util.Scanner;  //ScannerŬ���� ��������

public class ScannerTest_04 {

	public static void main(String[] args) {
		
		//Scanner��� Ŭ������ ���ڿ��̳� ���� ��� Ű����� �Է¹����� �Ҷ� ����
		
		//ScannerŸ���� ��������sc�� Scanner��� �Է°�ü ����
		Scanner sc = new Scanner(System.in);
		
		//��������
		String name;
		int age;
		String city;
		
		//�Է¿� ���� ��°��̵幮 -> Ű���� �Է�
		System.out.print("�̸��� �Է��غ�����==>");
		
		//��ĳ���� nextLine()�޼���
		//�� ������ ���ڷ� �о�´�(���� ��밡��)
		name = sc.nextLine();
		
		System.out.print("����� ���̴� ���?==>");
		age = Integer.parseInt(sc.nextLine());
		
		System.out.println("��ô� ������?==>");
		city = sc.nextLine();
		
		//���
		System.out.println("���� �̸��� " + name + "�Դϴ�");
		System.out.println("���� ���̴� " + age + "�� �Դϴ�");
		System.out.println("���� " + city + " ������ ��ƿ�");
		
		sc.close();
		
	}

}
