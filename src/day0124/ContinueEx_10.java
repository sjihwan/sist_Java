package day0124;

public class ContinueEx_10 {

	public static void main(String[] args) {
		
		// 12347810 �� continue���� �����ؼ� ����غ�����
		// break������ �������� �ݺ����� ����� �ʴ´ٴ� ��
		// continue�� ��������, �Ʒ��� ������ ������� �ʴ� ��
		
		for(int i=1; i<=10; i++) {
			if(i==10)
				System.out.print(i);
			if(i%5==0)
				continue;
			else if(i%6==0)
				continue;
			else if(i%9==0)
				continue;
			System.out.print(i + " ");
		}
		System.out.println();
		
		// continue �̿��� ��!!
		// Ȧ����: 1
		// Ȧ����: 3
		// Ȧ����: 5
		// Ȧ����: 7
		// Ȧ����: 9
		
		for(int i=1; i<=10; i++) {
			if(i%2==0)
				continue;
			System.out.println("Ȧ����: " + i);
		}
		
	}
	
}
