package day0121;

import java.util.Scanner;

public class IfScanReiview {

	public static void main(String[] args) {
		
		//두 수를 입력해서 max 값을 구하고 두수중 첫번째,두번째가 더 크다 라는걸 출력
		//삼항연산자
		Scanner sc= new Scanner(System.in);
				
		int x,y; //max 가장 큰 값은?,비교->더 큰수?
//		int max;		
		
		System.out.println("**두개의 숫자를 입력하세요**");
		x=sc.nextInt();
		y=sc.nextInt();
				
		System.out.println("입력한 두수: " + x + ", " + y);
				
		//max값을 구하기 위해선?
//		if(x>y) {
//			max=x;
//			System.out.println("두수중 더 큰값은 " +max+ "입니다");
//		}
//		else if(x<y) {
//			max=y;
//			System.out.println("두수중 더 큰값은 " +max+ "입니다");
//		}
//		else
//			System.out.println("두 수는 같다");
				
		System.out.println(x>y? x+"가 "+y+"보다 크다" :
			x<y? y+"가 "+x+"보다 크다" : 
				"두 수는 같다");
		
		sc.close();
		
	}

}
