package day0118;

public class VarTest_04 {

	public static void main(String[] args) {

		//변수: 메모리공간의 할당과 접근, 2가지를 해결하기 위해서 변수 도입
		//코드에서 변수 선언 --> 메모리공간 할당 --> 할당된 메모리에 접근을 위해서 변수이름지정
		//선언: 컴파일러에게 무언가를 알리는 행위
		//자바에서는 반드시 자료형으로 변수 선언
		
		int num1;  //변수선언
		num1 = 100;  //변수num1에 값저장
		int num2 = 200; //변수선언과 동시에 값저장
		int result = num1 + num2; //변수선언과 동시에 두 변수(num1,num2)의 값을 더한값을 저장
		
		System.out.println(num1 + num2); //변수num1과 num2의 값을 더한 값을 출력
		System.out.println(num1 + "+" + num2 + "=" + result); //변수num1의 값+변수num2의 값=변수result값
		
	}

}
