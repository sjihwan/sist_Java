package day0126;

public class ArraysMaxMinEx_06 {

	public static void main(String[] args) {
		
		int data[] = {5, 6, 4, 7, 1, 10, 15};
		
		System.out.println("data ����: " + data.length);
		
		int max = data[0];
		int min = data[0];
		
		//�ι�° ������[1]���� ������ max �Ǵ� min�� ��
		for(int i=1; i<data.length; i++) {
			if(max<data[i]) {
				max = data[i];
			}
			if(min>data[i]) {
				min = data[i];
			}			
		}
		
		System.out.println("�ִ밪: " + max);
		System.out.println("�ּҰ�: " + min);
		
	}
	
}
