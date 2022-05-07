package day0121;

public class DoWhileEx_13 {

	public static void main(String[] args) {
		
		int i = 1;
		
		System.out.println("While문 결과");
		while(i>=5) {  //조건문에 충족하지 않아 반복문 실행안됨
			System.out.println(i++);
		}
		
		System.out.println("do-While문 결과");
		do {
			System.out.println(i++); //출력후 증가!!
		}while(i>=5);
		System.out.println("종료");
		
	}
	
}
