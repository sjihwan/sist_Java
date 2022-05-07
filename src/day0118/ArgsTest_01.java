//패키지란 관련있는 파일의 목록을 묶어주는 역할을 한다
package day0118;

//메인클래스는 파일명과 똑같은 이름을 가지고 있다(필수불변)
//메인클래스는 메인메서드를 가지고 있는 클래스이다
public class ArgsTest_01 {  //매개변수테스트

	public static void main(String[] args) {
		
		System.out.println("***매개변수 테스트***");
		System.out.println("첫번째: " + args[0]);
		System.out.println("두번째: " + args[1]);
		System.out.println("결과: " + (args[0] + args[1]));
		//Run As -> Run Configuration -> Arguments(인자값)입력 -> Run
		
	}

}
