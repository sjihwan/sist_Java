package day0126; //��Ű��

public class ArrayEx_02 { //����Ŭ����

	public static void main(String[] args) { //���θ޼���
		/*
		intŸ���� �����Ͱ� ��� �迭���� arr
		new�����ڷ� ��ü�� �����Ͽ� ����
		*/
		//int[] arr = new int[3];	//3�� ũ��� �޸� �Ҵ�
		//int arr[] = new int[3];
		//�Ҵ縸 �ϰ� ���� �����ʴ��� 0���� �ʱ�ȭ�ȴ�
		//����� ���ÿ� �ʱⰪ�� �ֱ⵵ �Ѵ�
		
		int[] arr, arr2;
		arr=new int[3];
		arr2=new int[5];
		
		//�迭�� �� �ֱ�
		arr[0] = 10;
		arr[1] = 5;
		arr[2] = 20;
		
		System.out.println("arr �迭�� ����: " + arr.length);
		
		//��½� �ݺ����� �̿��ؼ� �ϰ������� ���
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("***for~each������ �ϰ����***");
		for(int a:arr) {	//for~each(�ڷ��� ����������:�迭��)
			System.out.println(a);
		}
		
		System.out.println("***arr2�� ���***");
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		System.out.println("***for~each��***");
		for(int a2:arr2) {
			System.out.println(a2);
		}
	}
	
}
