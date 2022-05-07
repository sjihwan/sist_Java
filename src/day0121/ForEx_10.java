package day0121;

public class ForEx_10 {

	public static void main(String[] args) {
		
		// I Love Java1...3까지 반복하려면?
		int i;
		
		for(i=1; i<=3; i++) {
			System.out.println("I Love Java"+i);
		}
//		System.out.println(i);
		
		//0 1 2 3 4
		for(int n=0; n<=4; n++) {
			System.out.print(n + " ");
		}
		System.out.print("\n");
		
		//세로로 Hello1~Hello10까지 반복하고
		//마지막줄엔 for문을 빠져나옴 이라고 출력
		for(int h=1; h<=10; h++) {
			System.out.println("Hello" + h);
		}
		System.out.println("for문을 빠져나옴");
		
	}
	
}
