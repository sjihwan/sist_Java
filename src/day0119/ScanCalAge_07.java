package day0119;

import java.util.Calendar;
import java.util.Scanner;

public class ScanCalAge_07 {

	public static void main(String[] args) {

		/*
		 * Q. Scanner, Calendar�� import�޾� �ϼ��Ͻÿ�
		 * Ű����� �Է¹޴°� name, myYear
		 * 
		 * ����� �䷸��
		 * ����⵵: 2022��
		 * ����� �̸���? ����ȯ
		 * �¾ �⵵��? 1997
		 * ----------------------
		 * ����ȯ���� 1997����̸� 26���Դϴ�
		 */
		
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		//Scanner�� �Է�
		System.out.println("����� �̸���?");
		String name = sc.nextLine();
		System.out.println("����� �¾ �⵵��?");
		int myYear = Integer.parseInt(sc.nextLine());
		
		//����⵵
		int curYear = cal.get(Calendar.YEAR);

		//���糪�� ���
		int age = curYear - myYear + 1;
		
		System.out.println("����⵵: " + cal.get(Calendar.YEAR) + "��");
		System.out.println("����� �̸���? " + name);
		System.out.println("�¾ �⵵��? " + myYear);
		System.out.println("----------------------");
		System.out.println(name + "���� " + myYear + "����̸� " + age + "���Դϴ�");
		
		sc.close();
		
	}

}
