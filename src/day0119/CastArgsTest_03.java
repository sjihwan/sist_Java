package day0119;

public class CastArgsTest_03 {

	public static void main(String[] args) {
		
		/*
		 * 상품명: 아이폰13 mini
		 * 수량: 20개
		 * 단가: 95만원
		 * 총금액: ****원
		 */
		
		//변수
		String name = args[0];  //"아이폰13 mini"
		int num = Integer.parseInt(args[1]);  //20
		int price = Integer.parseInt(args[2]);  //95
		
		//계산
		int tot = num * price;
		
		//출력
		System.out.println("상품명: " + name);
		System.out.println("수량: " + num + "개");
		System.out.println("단가: " + price + "만원");
		System.out.println("총금액: " + tot + "만원");
		
	}

}
