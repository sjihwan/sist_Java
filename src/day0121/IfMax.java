package day0121;

import java.util.Scanner;

public class IfMax {

	public static void main(String[] args) {
		
		/*
		 * ������ �Է��Ͽ� �� ū ���� ����Ͻÿ� x,y,z
		 * if or ���ǿ����ڸ� �̿��Ͽ� ��� ����� ��
		 * 3���� ��: 10,20,30
		 * max=30 �̶�� ����ϼ���
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ���� �Է��ϼ���");
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		
		int max;
		
		System.out.println("�Է��� ��: " + x + "," + y + "," + z);
		
		System.out.println("**if��**");
		if(x>y&&x>z)
			max=x;
		else if(y>x&&y>z)
			max=y;
		else
			max=z;
		System.out.println("max="+max);
		
		System.out.println("**���׿�����**");
		max = x>y&&x>z ? x:
			  y>x&&y>z ? y:z;
		System.out.println("max="+max);
	}

}
