package day0119;

import java.util.Calendar;

public class CalAge_06 {

	public static void main(String[] args) {

		//Calendar�� �̿��Ͽ� ������ ���̸� ������
		
		Calendar cal = Calendar.getInstance();
		
		int curYear = cal.get(Calendar.YEAR); //����⵵
		
		//StringŸ���� �Է¹��� ���ڰ��� �޾� ���̸� ����ϱ� ���� String->Int ĳ����
		int myYear = Integer.parseInt(args[0]);
		
		//���� ���ϱ�(�ѱ�����)
		int myAge = curYear - myYear + 1;
		
		//���
		System.out.println("�¾ �⵵: " + myYear + "���");
		System.out.println("���� ����: " + myAge + "��");
		
	}

}
