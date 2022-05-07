package day0124;

public class ForContinue_08 {

	public static void main(String[] args) {

		//continue: for문에서 continue를 만나면 그 아래부분을 실행하지 않고 증감식으로 이동한다
		//break: 반복문에서 가장 가까운 반복문을 빠져나간다
		//return: 메서드(함수) 종료
		
		//break
		for(int i=1; i<=10; i++) {
			if(i%5==0)
				break;
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		//continue
		for(int i=1; i<=10; i++) {
			if(i%5==0)
				continue;  //i++로 이동
			System.out.print(i + " ");
		}
		
	}

}
