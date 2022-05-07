package day0126;

public class ArrayEx_04 {

	public static void main(String[] args) {
		/*int배열*/
		//선언과 동시에 초기값 지정해줄수 있다...{}로 한다	
		int[] arr = {5,7,84,88,9,43};
		
		//arr.length배열길이 출력
		System.out.println("갯수: " + arr.length);
		
		//for문...배열값 출력
		System.out.println("arr_#1");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		//for-each문...배열값 출력
		System.out.println("arr_#2");
		for(int a:arr) {
			System.out.print(a + " ");
		}
		
		System.out.println();
		
		//배열선언_방법1...일일이 지정한 인덱스에 값을 넣는다
		System.out.println("===방법1===");
		int[] arr1 = new int[5]; //디폴트: 0으로 초기화
		arr1[1] = 10;
		arr1[4] = 34;
		
		for(int n:arr1) {
			System.out.println(n);
		}
		
		//배열선언_방법2...일괄적으로 {}안에 값을 넣는다
		System.out.println("===방법2===");
		int [] arr2 = {44,77,88,99,100,34,56,78};
		//arr2 길이 출력
		System.out.println("arr2의 길이: " + arr2.length); //8
		System.out.println("----------------");
		
		//for...arr2 값 출력
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("----------------");
		//for-each...arr2 값 출력
		for(int a2:arr2) {
			System.out.printf("%5d",a2); //%5d: 5자리 정수형으로 출력하겠다
		}System.out.println();
		
		/*String배열*/
		//방법1
		String[] str1 = new String[5];
		str1[0] = "장미";
		str1[2] = "후리지아";
		//방법2
		String[] str2 = {"레드","노랑","그린","파랑"};
		
		//출력#1_str1..for
		for(int i=0; i<str1.length; i++) {
			System.out.print(str1[i] + " ");
		}System.out.println();
		//출력#2_str1..for-each
		for(String s1:str1) {
			System.out.print(s1 + " ");
		}System.out.println();
		
		//출력#1_str2..for
		for(int i=0; i<str2.length; i++) {
			System.out.print(str2[i] + " ");
		}System.out.println();
		//출력#2_str2..for-each
		for(String s2:str2) {
			System.out.print(s2 + " ");
		}System.out.println();
	}

}
