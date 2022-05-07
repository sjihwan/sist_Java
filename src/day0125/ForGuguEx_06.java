package day0125;

public class ForGuguEx_06 {
	
	public static void height_gugu() {
		
		/*
		 * [2��]
		 * 2X1=2
		 */
		
		for(int n=2; n<=9; n++) {
			System.out.println("[" + n + "��]");
			for(int i=1; i<=9; i++) {
				System.out.println(n + "X" + i + "=" + (n*i));
			}
			System.out.println();			
		}
		
	}
	
	//���η� ���
	public static void width_gugu() {
		
		//2~4�ܱ��� ���� �������� ����Ѵ�
		for(int dan=2; dan<=4; dan++) {			
			System.out.print( "[" + dan + "��]\t" );
		}

		System.out.println();
		
		//2*1	3*1 �̷������� ����Ѵ�
		for(int n=1; n<=9; n++) {
			for(int dan=2; dan<=4; dan++) { //4�ܱ���
				System.out.print(dan + "X" + n + "=" + (dan*n) + "\t");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		
		width_gugu();
		
	}
	
}
