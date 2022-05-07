package day0119;

//캘린더(Calendar) 클래스 가져오기
import java.util.Calendar;

public class CalendarTest_05 {

	public static void main(String[] args) {

		//Calendar타입의 참조변수cal
		//Calendar클래스 안에 getInstance()메서드를 호출한 값을 저장
		//디폴트 값으로 현재 날짜를 리턴
		Calendar cal = Calendar.getInstance();
		
		System.out.println("지금은 " + cal.get(Calendar.YEAR) + "년도 입니다");
		System.out.println("지금은 " + (cal.get(Calendar.MONTH)+1) + "월 입니다"); //세계표준, 항상 월(MONTH)만 1을 더해준다
		System.out.println("지금은 " + cal.get(Calendar.DAY_OF_MONTH) + "일 입니다");
		System.out.println("시간: " + cal.get(Calendar.HOUR_OF_DAY) + "시" + cal.get(Calendar.MINUTE) + "분");
		
	}

}
