package day0124;

public class ForBreakLoop_15 {

	public static void main(String[] args) {
		
		//네이밍(반복문의 이름을 지정)
		loop1: for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if(j==5)
					break loop1; // 네이밍을 통해 먼 곳의 반복문을 지정하여 빠져나갈수있다
				System.out.println(i + "*" + j + "=" + i*j);
			}
			System.out.println();
		}
		
	}
	
}
