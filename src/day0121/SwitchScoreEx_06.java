package day0121;

import java.util.Scanner;

public class SwitchScoreEx_06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int score;		//점수
		String grade;	//학점(등급)
		String msg;		//메시지(코멘트)
		
		System.out.println("당신의 점수는?");
		score = sc.nextInt();
		
		//점수 출력
		System.out.println("당신의 점수는 " + score + "점 입니다");
		
		//switch문
		switch (score/10) {
		case 10: case 9: //score/10이 10이거나 9이면..
			grade = "A";
			break;
		case 8:
			grade = "B";			
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		System.out.println("학점은 " + grade + "입니다");
		
		//삼항연산자를 통해 코멘트 출력
		msg = grade == "A"? "합격입니다" :
			  grade == "B"? "좀더 노력하세요" : "다음기회에";
		System.out.println(msg);
		
	}
	
}
