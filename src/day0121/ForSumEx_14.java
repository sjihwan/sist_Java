package day0121;

public class ForSumEx_14 {

	//�ݺ����� �̿��ؼ� ������ �հ� ���ϱ�(1~5������ �հ� ���ϱ�)
	public static void main(String[] args) {
		
		//for��
		int sum = 0;
		
		System.out.println("**for���� ��**");
		for(int i=1; i<=5; i++) {
			sum += i;
		}
		System.out.println("1���� 5������ ���� " + sum + "�Դϴ�");
		
		//while��
		sum = 0;
		int i = 1;
		
		System.out.println("**while���� ��**");
		while(i<=5) {
			sum += i;
			i++;
		}
		System.out.println("1���� 5������ ���� " + sum + "�Դϴ�");
		
		//1~10������ Ȧ�� �� ���ϱ�
		sum = 0;
		
		System.out.println("**1���� 10������ Ȧ�� ��**");
		for(i=1; i<=10; i++) {
			if(i%2 != 0)
				sum += i;
		}
		System.out.println("1���� 10������ Ȧ���� ���� " + sum + "�Դϴ�");
		
	}
	
}
