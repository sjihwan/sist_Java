package day0124;

public class ForGuguBreak_14 {

	public static void main(String[] args) {
		
		// 2~9�ܱ����� ����ϵ� 2*4=8....9*4=36
		// ���� 4������ ��µǰ� �Ͻÿ�...break�� �̿��Ͻÿ�
		
		for(int dan=2; dan<=9; dan++) {
			for(int i=1; i<=9; i++) {
				if(i==5)
					break;
				System.out.println(dan + "X" + i + "=" + (dan*i));
			}
		}
		
	}
	
}
