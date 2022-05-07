package day0121;

import java.util.Scanner;

public class ScanIfOperEx_03 {

	public static void main(String[] args) {
		
		//수량과 단가를 입력후 총금액 알아보자
		//일정개수 이상을 구입하면 일정금액을 할인해준다고 가정해보자
		
		Scanner sc = new Scanner(System.in);
		String sangpum; //상품명
		int su; //수량
		int dan; //단가
		int total; //총금액
		
		//상품명 수량 단가 입력
		System.out.println("상품명?");
		sangpum = sc.nextLine();
		System.out.println("수량?");
		su = sc.nextInt();
		System.out.println("단가는?");
		dan = sc.nextInt();
		
		//총금액을 계산하여 출력한다
		total = su*dan;
		
		System.out.println(sangpum + " " + su + "개는 총 " + total + "원 입니다");
		
		//수량이 5개 이상이면 총금액의 10%를 DC해준답니다
		//DC된 금액: 
		int dc;
		if(su>=5) {
			dc = total *= 0.9; //=total*0.9 와는 자료형이 다르다
			System.out.println("5개 이상은 10프로 DC된답니다");
			System.out.println("DC된 금액: " + dc);
		}
	}

}
