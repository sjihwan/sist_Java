package day0121;

import java.util.Scanner;

public class IfStringOperEx_04 {

	public static void main(String[] args) {
		
		// ���ڿ� �񱳴� ���迬���ڷ� �ϸ� �ȵǰ�
		// equals��� �޼��带 ����ؼ� ���Ѵ�
		
		Scanner sc = new Scanner(System.in);
		
		String msg; //�Է��� �ܾ�
		
		//�Է°��̵幮
		System.out.println("����ܾ �Է��ϼ���");
		System.out.println("�Է´ܾ� ����) happy,angel,rose,winter,summer");  //���� ����
		
		msg = sc.nextLine();
		
		System.out.println("�Է��� ���ڿ�: " + msg);
		
		//���ڿ� ������ڷ� ���Ϸ��� �ּҺ񱳸� ��...���� equals�޼���
		if(msg.equals("angel"))  //msg.equals(���ڿ�) ��ȯ��=> true,false
			System.out.println("***õ��***");
		else if(msg.equalsIgnoreCase("happy")) //equals�޼���� ��ҹ��� ������� �����ɷ� �ν�
			System.out.println("***�ູ�ϴ�***");
		else if(msg.equals("rose"))
			System.out.println("***���***");
		else if(msg.equals("winter"))
			System.out.println("***�ܿ�***");
		else if(msg.equals("summer"))
			System.out.println("***����***");
		else
			System.out.println("***���� ������ ����� �ȵ� ���ڿ��Դϴ�***");
		
	}
	
}
