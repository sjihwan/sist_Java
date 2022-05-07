package day0126; //패키지

public class ArrayEx_02 { //메인클래스

	public static void main(String[] args) { //메인메서드
		/*
		int타입의 데이터가 담길 배열변수 arr
		new연산자로 객체를 생성하여 대입
		*/
		//int[] arr = new int[3];	//3의 크기로 메모리 할당
		//int arr[] = new int[3];
		//할당만 하고 값을 주지않더라도 0으로 초기화된다
		//선언과 동시에 초기값을 주기도 한다
		
		int[] arr, arr2;
		arr=new int[3];
		arr2=new int[5];
		
		//배열에 값 넣기
		arr[0] = 10;
		arr[1] = 5;
		arr[2] = 20;
		
		System.out.println("arr 배열의 갯수: " + arr.length);
		
		//출력시 반복문을 이용해서 일괄적으로 출력
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("***for~each문으로 일괄출력***");
		for(int a:arr) {	//for~each(자료형 참조변수명:배열명)
			System.out.println(a);
		}
		
		System.out.println("***arr2값 출력***");
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		System.out.println("***for~each문***");
		for(int a2:arr2) {
			System.out.println(a2);
		}
	}
	
}
