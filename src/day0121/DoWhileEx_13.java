package day0121;

public class DoWhileEx_13 {

	public static void main(String[] args) {
		
		int i = 1;
		
		System.out.println("While�� ���");
		while(i>=5) {  //���ǹ��� �������� �ʾ� �ݺ��� ����ȵ�
			System.out.println(i++);
		}
		
		System.out.println("do-While�� ���");
		do {
			System.out.println(i++); //����� ����!!
		}while(i>=5);
		System.out.println("����");
		
	}
	
}
