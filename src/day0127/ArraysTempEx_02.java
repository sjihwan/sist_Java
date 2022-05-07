package day0127;

public class ArraysTempEx_02 {
	
	//배열을 이용해서 교환출력

	public static void main(String[] args) {
		
		int[] a= {6,9,3};
		
		//for each문은 (배열 및 ArrayList 등)만 가능하다
		for(int n:a) {
			System.out.println(n);
		}
		
		System.out.println("0번과 2번 교환후 출력");
		int temp = a[0];	//temp=6
		a[0] = a[2];	//{3,9,3}
		a[2] = temp;	//{3,9,6}
		
		for(int n:a) {
			System.out.println(n);
		}
	}

}