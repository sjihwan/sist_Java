package day0126;

public class ArrayEx_04 {

	public static void main(String[] args) {
		/*int�迭*/
		//����� ���ÿ� �ʱⰪ �������ټ� �ִ�...{}�� �Ѵ�	
		int[] arr = {5,7,84,88,9,43};
		
		//arr.length�迭���� ���
		System.out.println("����: " + arr.length);
		
		//for��...�迭�� ���
		System.out.println("arr_#1");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		//for-each��...�迭�� ���
		System.out.println("arr_#2");
		for(int a:arr) {
			System.out.print(a + " ");
		}
		
		System.out.println();
		
		//�迭����_���1...������ ������ �ε����� ���� �ִ´�
		System.out.println("===���1===");
		int[] arr1 = new int[5]; //����Ʈ: 0���� �ʱ�ȭ
		arr1[1] = 10;
		arr1[4] = 34;
		
		for(int n:arr1) {
			System.out.println(n);
		}
		
		//�迭����_���2...�ϰ������� {}�ȿ� ���� �ִ´�
		System.out.println("===���2===");
		int [] arr2 = {44,77,88,99,100,34,56,78};
		//arr2 ���� ���
		System.out.println("arr2�� ����: " + arr2.length); //8
		System.out.println("----------------");
		
		//for...arr2 �� ���
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("----------------");
		//for-each...arr2 �� ���
		for(int a2:arr2) {
			System.out.printf("%5d",a2); //%5d: 5�ڸ� ���������� ����ϰڴ�
		}System.out.println();
		
		/*String�迭*/
		//���1
		String[] str1 = new String[5];
		str1[0] = "���";
		str1[2] = "�ĸ�����";
		//���2
		String[] str2 = {"����","���","�׸�","�Ķ�"};
		
		//���#1_str1..for
		for(int i=0; i<str1.length; i++) {
			System.out.print(str1[i] + " ");
		}System.out.println();
		//���#2_str1..for-each
		for(String s1:str1) {
			System.out.print(s1 + " ");
		}System.out.println();
		
		//���#1_str2..for
		for(int i=0; i<str2.length; i++) {
			System.out.print(str2[i] + " ");
		}System.out.println();
		//���#2_str2..for-each
		for(String s2:str2) {
			System.out.print(s2 + " ");
		}System.out.println();
	}

}
