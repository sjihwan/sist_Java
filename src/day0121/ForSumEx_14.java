package day0121;

public class ForSumEx_14 {

	//반복문을 이용해서 숫자의 합계 구하기(1~5까지의 합계 구하기)
	public static void main(String[] args) {
		
		//for문
		int sum = 0;
		
		System.out.println("**for문의 합**");
		for(int i=1; i<=5; i++) {
			sum += i;
		}
		System.out.println("1부터 5까지의 합은 " + sum + "입니다");
		
		//while문
		sum = 0;
		int i = 1;
		
		System.out.println("**while문의 합**");
		while(i<=5) {
			sum += i;
			i++;
		}
		System.out.println("1부터 5까지의 합은 " + sum + "입니다");
		
		//1~10까지의 홀수 합 구하기
		sum = 0;
		
		System.out.println("**1부터 10까지의 홀수 합**");
		for(i=1; i<=10; i++) {
			if(i%2 != 0)
				sum += i;
		}
		System.out.println("1부터 10까지의 홀수의 합은 " + sum + "입니다");
		
	}
	
}
