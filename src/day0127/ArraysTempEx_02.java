package day0127;

public class ArraysTempEx_02 {
	
	//�迭�� �̿��ؼ� ��ȯ���

	public static void main(String[] args) {
		
		int[] a= {6,9,3};
		
		//for each���� (�迭 �� ArrayList ��)�� �����ϴ�
		for(int n:a) {
			System.out.println(n);
		}
		
		System.out.println("0���� 2�� ��ȯ�� ���");
		int temp = a[0];	//temp=6
		a[0] = a[2];	//{3,9,3}
		a[2] = temp;	//{3,9,6}
		
		for(int n:a) {
			System.out.println(n);
		}
	}

}