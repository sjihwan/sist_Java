package day0120;

public class OperEx_05 {

	public static void main(String[] args) {

		boolean bool = false;
		System.out.println("a="+bool);  //false
		System.out.println("b="+!bool); //true
		
		boolean bool1 = 5>3;
		System.out.println("c="+bool1); //true
		System.out.println("d="+!(5>3));//false
		//System.out.println("d="+!5); //숫자는 부정할 수 없다(논리부정은 가능)
		
		//비교연산자(관계): >,<,>=,<=,==,!=
		//논리연산자: &&(and),||(or),!(not)
		int a=5,b=3,c=5;
		
		//결과값을 true,false
		System.out.println("논리,비교연산자");
		System.out.println(a>b);
		System.out.println(a==b);
		System.out.println(!(a==b));
		System.out.println(a!=b);	//a!=b는 !(a==b)와 같다
		System.out.println(a==c);
		System.out.println(a>b&&b>c); //&&: 둘다 참이 아니면 false
		System.out.println(a>b||b>c); //||: 둘중에 하나가 참이면 true
		
	}

}
