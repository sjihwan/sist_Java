package day0126;

public class ArraysMaxMinEx_06 {

	public static void main(String[] args) {
		
		int data[] = {5, 6, 4, 7, 1, 10, 15};
		
		System.out.println("data 갯수: " + data.length);
		
		int max = data[0];
		int min = data[0];
		
		//두번째 데이터[1]부터 끝까지 max 또는 min과 비교
		for(int i=1; i<data.length; i++) {
			if(max<data[i]) {
				max = data[i];
			}
			if(min>data[i]) {
				min = data[i];
			}			
		}
		
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
		
	}
	
}
