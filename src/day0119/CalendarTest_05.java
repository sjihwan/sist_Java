package day0119;

//Ķ����(Calendar) Ŭ���� ��������
import java.util.Calendar;

public class CalendarTest_05 {

	public static void main(String[] args) {

		//CalendarŸ���� ��������cal
		//CalendarŬ���� �ȿ� getInstance()�޼��带 ȣ���� ���� ����
		//����Ʈ ������ ���� ��¥�� ����
		Calendar cal = Calendar.getInstance();
		
		System.out.println("������ " + cal.get(Calendar.YEAR) + "�⵵ �Դϴ�");
		System.out.println("������ " + (cal.get(Calendar.MONTH)+1) + "�� �Դϴ�"); //����ǥ��, �׻� ��(MONTH)�� 1�� �����ش�
		System.out.println("������ " + cal.get(Calendar.DAY_OF_MONTH) + "�� �Դϴ�");
		System.out.println("�ð�: " + cal.get(Calendar.HOUR_OF_DAY) + "��" + cal.get(Calendar.MINUTE) + "��");
		
	}

}
