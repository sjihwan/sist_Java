package day0118;

public class VarTest_04 {

	public static void main(String[] args) {

		//����: �޸𸮰����� �Ҵ�� ����, 2������ �ذ��ϱ� ���ؼ� ���� ����
		//�ڵ忡�� ���� ���� --> �޸𸮰��� �Ҵ� --> �Ҵ�� �޸𸮿� ������ ���ؼ� �����̸�����
		//����: �����Ϸ����� ���𰡸� �˸��� ����
		//�ڹٿ����� �ݵ�� �ڷ������� ���� ����
		
		int num1;  //��������
		num1 = 100;  //����num1�� ������
		int num2 = 200; //��������� ���ÿ� ������
		int result = num1 + num2; //��������� ���ÿ� �� ����(num1,num2)�� ���� ���Ѱ��� ����
		
		System.out.println(num1 + num2); //����num1�� num2�� ���� ���� ���� ���
		System.out.println(num1 + "+" + num2 + "=" + result); //����num1�� ��+����num2�� ��=����result��
		
	}

}
