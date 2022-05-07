package day0121;

public class SubStringEx_09 {

	public static void main(String[] args) {
		
		String str = "나는 강남 쌍용교육센터에서 자바를 공부중입니다";
		int l = str.length(); //25
		char ch = str.charAt(4); //'남'
		
		//substring메서드...문자열중 일부문자열 반환
		String word1 = str.substring(3); //"강남 쌍용교육센터에서 자바를 공부중입니다"
		String word2 = str.substring(6, 11); //"쌍용교육센"
		
		System.out.println(ch);
		System.out.println(word1); //3번부터 끝까지 추출
		System.out.println(word2); //6번~11번 이전까지 추출
		System.out.println(l);
		
	}
	
}
