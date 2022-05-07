package day0126;

public class StringEx_01 {

	public static void main(String[] args) {
		
		System.out.println("String객체에 대한 멤버 메서드 공부합니다");
		
		String str1 = "apple";
		String str2 = "Apple";
		String str3 = "Have a Nice Day";
		String str4 = "   Happy Day   ";
		
		System.out.println("str3의 길이: " + str3.length());
		System.out.println("str4의 길이: " + str4.length());
		
		//trim(): 중간에 있는 공백은 제거하지 않음
		System.out.println("앞뒤공백제거 str4의 길이: " + str4.trim().length());
		System.out.println("*"+str4+"*");
		System.out.println("*"+str4.trim()+"*");
		
		System.out.println("str3에서 0번문자: " + str3.charAt(0));
		System.out.println("str3에서 7번문자: " + str3.charAt(7));
		
		//indexOf('char형'): 문자가 시작하는 첫 위치(인덱스 번호)를 반환함
		System.out.println("str3에서 H의 인덱스: " + str3.indexOf('H'));
		System.out.println("str3에서 N의 인덱스: " + str3.indexOf('N'));
		
		//substring(시작인덱스,끝인덱스-1): 끝인덱스는 생략할수있다
		System.out.println("str3에서 Have출력: " + str3.substring(0, 4));
		System.out.println("str3에서 Nice출력: " + str3.substring(7, 11));
		
		//equals(): 문자열 비교
		System.out.println("문자열비교: " + str1.equals(str2));
		System.out.println("문자열비교: " + str1.equalsIgnoreCase(str2)); //대소문자 상관없이
		
		/*
		 * 문자열 변수 a,b
		 * a.compareTo(b)
		 * compareTo()는 같은 위치의 문자 비교(아스키값의 차이 반환)
		 * a와 b가 같은 경우 0
		 * a가 작은 경우 -(알파벳 차이만큼 마이너스값)
		 * a가 큰 경우 +(알파벳 차이만큼 플러스값)
		 */
		System.out.println(str1.compareTo(str2)); //a(97)와 A(65) 비교 //+32 반환
		System.out.println(str1.compareTo(str1)); //0 반환
		System.out.println("computer".compareTo("command")); //p(112)와 m(109) 비교
		System.out.println("hello".compareTo("hello")); //0 반환
		System.out.println("apple".compareTo("banana")); //a와 b 비교 //-1 반환
		System.out.println("o".compareTo("orange")); //비교 문자열이 포함될 경우, 문자열 길이의 차이값 반환
		System.out.println("".compareTo("orange")); //문자열 길이의 차이값 반환 //-6 반환
		System.out.println("홍".compareTo("차"));
		
		//startsWith(): boolean값 반환
		System.out.println("str3가 Have로 시작하면 true: " + str3.startsWith("Have"));
		System.out.println("str3가 Have로 시작하면 true: " + str3.startsWith("Happy"));
		//endsWith(): boolean값 반환
		System.out.println(str3.endsWith("Day"));	//true
		System.out.println(str3.endsWith("day"));	//대소문자구분...false
		
		//split(): 문자열 분리하여 배열 생성
		String str5 = "red,blue,green,yellow,pink,white";
		System.out.println("str5를 컴마로 분리하여 출력하기");
		String[] arr = str5.split(",");
		System.out.println(",로 구분된 색상 갯수: " + arr.length);
		for(String color:arr)
			System.out.println(color);
		
		System.out.println("str3의 소문자 출력: " + str3.toLowerCase());
		System.out.println("str3의 대문자 출력: " + str3.toUpperCase());
		
		//String.valueOf(): 숫자값을 문자열로 바꿔줌
		String a = String.valueOf(100);		//int-->String
		String b = String.valueOf(12.345);	//double-->String
		System.out.println(a+b);
		String a2 = 100 + "";
		String b2 = 23.5 + "";
		System.out.println(a2+b2);
		
		//replace(): 문자열의 일부를 변경
		System.out.println("문자열의 일부변경");
		System.out.println(str3.replace('a', '*'));			//모든 a-->*
		System.out.println(str3.replace("Nice", "Good"));	//Nice-->Good
		
	}
	
}
