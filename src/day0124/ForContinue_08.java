package day0124;

public class ForContinue_08 {

	public static void main(String[] args) {

		//continue: for������ continue�� ������ �� �Ʒ��κ��� �������� �ʰ� ���������� �̵��Ѵ�
		//break: �ݺ������� ���� ����� �ݺ����� ����������
		//return: �޼���(�Լ�) ����
		
		//break
		for(int i=1; i<=10; i++) {
			if(i%5==0)
				break;
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		//continue
		for(int i=1; i<=10; i++) {
			if(i%5==0)
				continue;  //i++�� �̵�
			System.out.print(i + " ");
		}
		
	}

}
