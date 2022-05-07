package day0126;

public class ArrayStringEx_03 {

	public static void main(String[] args) {
		
		String[] str;
		str = new String[4];
		
		str[0] = "홍길동";
		str[1] = "유재석";
		str[2] = "이승기";
		//string 초기화값을 넣어지주지 않으면 null
		
		//출력
		System.out.println("***출력1_for***");
		for(int i=0; i<str.length; i++) {
			System.out.println( (i+1) + ": " + str[i] );
		}
		
		System.out.println("***출력2_for~each***");
		for(String s:str) {
			System.out.println(s);
		}
		
	}
	
}
