package day0125;

public class MathRandomEx_03 {

	public static void main(String[] args) {
		
		//10���� ���� �߻�
		for(int i=1; i<=10; i++) {
			// Math.random() �޼���� 0.0�̻� 1.0�̸��� double�� �Ǽ����� ��ȯ
			Double n = Math.random();
			System.out.println(n);
		}
		
		System.out.println("------------------------");
		
		System.out.println("0~9������ ���� �߻�");
		for(int i=1; i<=10; i++) {
			int n = (int)(Math.random()*10);
			System.out.println(n);
		}
		
		System.out.println("------------------------");
		
		System.out.println("1~10������ ���� �߻�");
		for(int i=1; i<=10; i++) {
			int n = (int)(Math.random()*10)+1;
			System.out.println(n);
		}
		
		System.out.println("------------------------");
		
		System.out.println("1~45������ ���� �߻�");
		for(int i=1; i<=10; i++) {
			int n = (int)(Math.random()*45)+1;
			System.out.println(n);
		}
		
	}
	
}
