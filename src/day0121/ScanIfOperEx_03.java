package day0121;

import java.util.Scanner;

public class ScanIfOperEx_03 {

	public static void main(String[] args) {
		
		//������ �ܰ��� �Է��� �ѱݾ� �˾ƺ���
		//�������� �̻��� �����ϸ� �����ݾ��� �������شٰ� �����غ���
		
		Scanner sc = new Scanner(System.in);
		String sangpum; //��ǰ��
		int su; //����
		int dan; //�ܰ�
		int total; //�ѱݾ�
		
		//��ǰ�� ���� �ܰ� �Է�
		System.out.println("��ǰ��?");
		sangpum = sc.nextLine();
		System.out.println("����?");
		su = sc.nextInt();
		System.out.println("�ܰ���?");
		dan = sc.nextInt();
		
		//�ѱݾ��� ����Ͽ� ����Ѵ�
		total = su*dan;
		
		System.out.println(sangpum + " " + su + "���� �� " + total + "�� �Դϴ�");
		
		//������ 5�� �̻��̸� �ѱݾ��� 10%�� DC���ش�ϴ�
		//DC�� �ݾ�: 
		int dc;
		if(su>=5) {
			dc = total *= 0.9; //=total*0.9 �ʹ� �ڷ����� �ٸ���
			System.out.println("5�� �̻��� 10���� DC�ȴ�ϴ�");
			System.out.println("DC�� �ݾ�: " + dc);
		}
	}

}
