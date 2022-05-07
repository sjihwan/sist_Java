package day0124;

public class ForGuguBreak_14 {

	public static void main(String[] args) {
		
		// 2~9단까지를 출력하되 2*4=8....9*4=36
		// 각각 4까지만 출력되게 하시오...break를 이용하시오
		
		for(int dan=2; dan<=9; dan++) {
			for(int i=1; i<=9; i++) {
				if(i==5)
					break;
				System.out.println(dan + "X" + i + "=" + (dan*i));
			}
		}
		
	}
	
}
