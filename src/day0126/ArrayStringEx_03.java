package day0126;

public class ArrayStringEx_03 {

	public static void main(String[] args) {
		
		String[] str;
		str = new String[4];
		
		str[0] = "ȫ�浿";
		str[1] = "���缮";
		str[2] = "�̽±�";
		//string �ʱ�ȭ���� �־������� ������ null
		
		//���
		System.out.println("***���1_for***");
		for(int i=0; i<str.length; i++) {
			System.out.println( (i+1) + ": " + str[i] );
		}
		
		System.out.println("***���2_for~each***");
		for(String s:str) {
			System.out.println(s);
		}
		
	}
	
}
