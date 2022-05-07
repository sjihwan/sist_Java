package day0120;

import java.util.Calendar;
import java.util.Scanner;

public class CalAgeDdi_08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); //new란 생성자,객체를 생성하겠다는 키워드
		Calendar cal = Calendar.getInstance();
				
		//변수선언
		int curYear = cal.get(Calendar.YEAR);
		int myYear,age;
		String name,ddi;
				
		//입력
		System.out.print("이름입력: ");
		name = sc.nextLine();
		System.out.print("태어난 연도 입력: ");
		myYear = sc.nextInt();
				
		//나이계산
		age = curYear - myYear + 1;
				
		//조건연산자(삼항연산자)
		//조건식 ? (조건이 참이면)값1 : (조건이 거짓이면)값2
		ddi = myYear%12==0?"원숭이":
			myYear%12==1?"닭":
				myYear%12==2?"개":
					myYear%12==3?"돼지":
						myYear%12==4?"쥐":
							myYear%12==5?"소":
								myYear%12==6?"호랑이":
									myYear%12==7?"토끼":
										myYear%12==8?"용":
											myYear%12==9?"뱀":
												myYear%12==10?"말":"양";	
				
		//최종출력
		System.out.println("나이 띠 구하기");
		System.out.println("이름: " + name);
		System.out.println("현재나이: " + age + "세");
		System.out.println("띠: " + ddi + "띠");
		
		sc.close();
		
	}

}
