package day0120;

public class OperTest_02 {

	public static void main(String[] args) {

		int a,b;
		a=b=5;
		
		//����������
		//������ ��쿡�� �տ� ���̳� �ڿ� ���̳� ����
		++a;
		b++;
		System.out.println("a=" + a + ",b=" + b);
		
		//���Ŀ��� ����� ���� ��ġ ��ġ�� ������� �޶�����
		int m,n;
		m=n=0;
		a=b=5;  //a,b�� �ٽ� 5�� �ʱ�ȭ
		
		m=a++;  //��ġ: a�� ������ ������Ų��
		System.out.println("m=" + m + ",a=" + a);
		
		n=++b;  //��ġ: b�� ������ ������Ų��
		System.out.println("n=" + n + ",b=" +b);
		
	}

}
