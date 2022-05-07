package day0120;

public class OperTest_02 {

	public static void main(String[] args) {

		int a,b;
		a=b=5;
		
		//증감연산자
		//단항일 경우에는 앞에 붙이나 뒤에 붙이나 같다
		++a;
		b++;
		System.out.println("a=" + a + ",b=" + b);
		
		//수식에서 사용할 때는 전치 후치의 결과값이 달라진다
		int m,n;
		m=n=0;
		a=b=5;  //a,b를 다시 5로 초기화
		
		m=a++;  //후치: a를 대입후 증가시킨다
		System.out.println("m=" + m + ",a=" + a);
		
		n=++b;  //전치: b를 대입전 증가시킨다
		System.out.println("n=" + n + ",b=" +b);
		
	}

}
