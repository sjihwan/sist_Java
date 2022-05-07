package day0121;

public class CharAtEx_08 {

	public static void main(String[] args) {
		
		//주민번호 변수jumin에 저장
		String jumin = "951102-4276545";

		char seventh = jumin.charAt(7);
		
		//조건문을 이용하여 남자,여자,2000년이후 남자,여자 인지 구하시오
//		if(seventh == '1')
//			System.out.println("당신은 남자입니다");
//		else if(seventh == '2')
//			System.out.println("당신은 여자입니다");
//		else if(seventh == '3')
//			System.out.println("당신은 2000년대 남자입니다");
//		else
//			System.out.println("당신은 2000년대 여자입니다");
		
		switch(seventh) {
		case '1':
			System.out.println("당신은 남자입니다");
		case '2':
			System.out.println("당신은 여자입니다");
		case '3':
			System.out.println("당신은 2000년대 남자입니다");
		case '4':
			System.out.println("당신은 2000년대 여자입니다");
		}
		
	}
	
}
