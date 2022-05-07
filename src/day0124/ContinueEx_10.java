package day0124;

public class ContinueEx_10 {

	public static void main(String[] args) {
		
		// 12347810 을 continue문을 포함해서 출력해보세요
		// break문과의 차이점은 반복문을 벗어나지 않는다는 점
		// continue를 만났을때, 아래의 문장은 수행되지 않는 점
		
		for(int i=1; i<=10; i++) {
			if(i==10)
				System.out.print(i);
			if(i%5==0)
				continue;
			else if(i%6==0)
				continue;
			else if(i%9==0)
				continue;
			System.out.print(i + " ");
		}
		System.out.println();
		
		// continue 이용할 것!!
		// 홀수값: 1
		// 홀수값: 3
		// 홀수값: 5
		// 홀수값: 7
		// 홀수값: 9
		
		for(int i=1; i<=10; i++) {
			if(i%2==0)
				continue;
			System.out.println("홀수값: " + i);
		}
		
	}
	
}
