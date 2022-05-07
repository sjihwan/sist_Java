package day0127;

import java.util.Arrays;

public class ArraysTempEx_03 {

	public static void main(String[] args) {
		
		int[] arr = {5,7,3,9,12,45,76,89,10};
		
		//�� ������ ���
		System.out.println("�� ������");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		/* ������ �Ųٷ� �ٲپ�� */
		//�߰��ε��� �������� �ٲ۴�
		for(int i=0; i<arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		
		System.out.println("�Ųٷ� ��� ������");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		
		/* �������� ����(��øfor) */
		for(int i=0; i<arr.length-1; i++) {
			//�񱳵����ʹ� ���ش���������
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("�������� ��� ������");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		/* Arrays��ü�� �̿�: �迭arr�� �������� �����Ѵ� */
		Arrays.sort(arr); 

		System.out.println(arr.toString()); //�迭�� �ּҰ� ���
		System.out.println(Arrays.toString(arr)); //�迭�� ���� ���
	}
}