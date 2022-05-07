package day0125;

public class ForGuguEx_06 {
	
	public static void height_gugu() {
		
		/*
		 * [2단]
		 * 2X1=2
		 */
		
		for(int n=2; n<=9; n++) {
			System.out.println("[" + n + "단]");
			for(int i=1; i<=9; i++) {
				System.out.println(n + "X" + i + "=" + (n*i));
			}
			System.out.println();			
		}
		
	}
	
	//가로로 출력
	public static void width_gugu() {
		
		//2~4단까지 탭을 간격으로 출력한다
		for(int dan=2; dan<=4; dan++) {			
			System.out.print( "[" + dan + "단]\t" );
		}

		System.out.println();
		
		//2*1	3*1 이런식으로 출력한다
		for(int n=1; n<=9; n++) {
			for(int dan=2; dan<=4; dan++) { //4단까지
				System.out.print(dan + "X" + n + "=" + (dan*n) + "\t");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		
		width_gugu();
		
	}
	
}
