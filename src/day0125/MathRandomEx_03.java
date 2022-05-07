package day0125;

public class MathRandomEx_03 {

	public static void main(String[] args) {
		
		//10개의 난수 발생
		for(int i=1; i<=10; i++) {
			// Math.random() 메서드는 0.0이상 1.0미만의 double형 실수값을 반환
			Double n = Math.random();
			System.out.println(n);
		}
		
		System.out.println("------------------------");
		
		System.out.println("0~9사이의 난수 발생");
		for(int i=1; i<=10; i++) {
			int n = (int)(Math.random()*10);
			System.out.println(n);
		}
		
		System.out.println("------------------------");
		
		System.out.println("1~10사이의 난수 발생");
		for(int i=1; i<=10; i++) {
			int n = (int)(Math.random()*10)+1;
			System.out.println(n);
		}
		
		System.out.println("------------------------");
		
		System.out.println("1~45사이의 난수 발생");
		for(int i=1; i<=10; i++) {
			int n = (int)(Math.random()*45)+1;
			System.out.println(n);
		}
		
	}
	
}
