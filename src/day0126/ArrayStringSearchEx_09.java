package day0126;

import java.util.Scanner;

public class ArrayStringSearchEx_09 {

	public static void main(String[] args) {
		
		/*
		 * 이름을 입력해서 그이름이 몇번째 있는지 
		 * 그이름이 없습니다 를 출력
		 * 끝 이라고 입력하면 검색을 종료합니다 라고 나온후 종료되게 할것!!
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String[] data = {"최준영","조정언","임현정","장수빈","조아라","이용기","이경룡","유태호","원연욱"};
		boolean flag; //(발견여부)찾았다&못찾았다를 알리기 위한 변수
		String name; //검색할이름
		
		while(true) {
			System.out.println("찾고자 하는 이름을 입력하세요(종료:끝)");
			name = sc.nextLine();
			
			//==은 숫자타입 비교논리연산자
			//String타입은 무조건 equals()메서드를 사용
			
			//끝을 입력시..종료
			if(name.equals("끝")) {
				System.out.println("검색을 종료합니다");
				break;
			}
			
			flag = false; //발견여부 false로 초기화
			for(int i=0; i<data.length; i++) {
				if(name.equals(data[i])) {
					flag = true;
					System.out.println(name+ "은 " + i + "번째에 있습니다");
				}
			}
			
			//찾지 못했으면..
			if(!flag) {
				System.out.println(name + "이 없습니다");
			}
		}

	}

}