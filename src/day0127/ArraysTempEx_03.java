package day0127;

import java.util.Arrays;

public class ArraysTempEx_03 {

	public static void main(String[] args) {
		
		int[] arr = {5,7,3,9,12,45,76,89,10};
		
		//원 데이터 출력
		System.out.println("원 데이터");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		/* 데이터 거꾸로 바꾸어보기 */
		//중간인덱스 기준으로 바꾼다
		for(int i=0; i<arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		
		System.out.println("거꾸로 출력 데이터");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		
		/* 오름차순 정렬(중첩for) */
		for(int i=0; i<arr.length-1; i++) {
			//비교데이터는 기준다음값부터
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("오름차순 출력 데이터");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		/* Arrays객체를 이용: 배열arr을 오름차순 정렬한다 */
		Arrays.sort(arr); 

		System.out.println(arr.toString()); //배열의 주소값 출력
		System.out.println(Arrays.toString(arr)); //배열의 값들 출력
	}
}