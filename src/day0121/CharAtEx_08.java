package day0121;

public class CharAtEx_08 {

	public static void main(String[] args) {
		
		//�ֹι�ȣ ����jumin�� ����
		String jumin = "951102-4276545";

		char seventh = jumin.charAt(7);
		
		//���ǹ��� �̿��Ͽ� ����,����,2000������ ����,���� ���� ���Ͻÿ�
//		if(seventh == '1')
//			System.out.println("����� �����Դϴ�");
//		else if(seventh == '2')
//			System.out.println("����� �����Դϴ�");
//		else if(seventh == '3')
//			System.out.println("����� 2000��� �����Դϴ�");
//		else
//			System.out.println("����� 2000��� �����Դϴ�");
		
		switch(seventh) {
		case '1':
			System.out.println("����� �����Դϴ�");
		case '2':
			System.out.println("����� �����Դϴ�");
		case '3':
			System.out.println("����� 2000��� �����Դϴ�");
		case '4':
			System.out.println("����� 2000��� �����Դϴ�");
		}
		
	}
	
}
