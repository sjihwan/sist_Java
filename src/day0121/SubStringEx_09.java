package day0121;

public class SubStringEx_09 {

	public static void main(String[] args) {
		
		String str = "���� ���� �ֿ뱳�����Ϳ��� �ڹٸ� �������Դϴ�";
		int l = str.length(); //25
		char ch = str.charAt(4); //'��'
		
		//substring�޼���...���ڿ��� �Ϻι��ڿ� ��ȯ
		String word1 = str.substring(3); //"���� �ֿ뱳�����Ϳ��� �ڹٸ� �������Դϴ�"
		String word2 = str.substring(6, 11); //"�ֿ뱳����"
		
		System.out.println(ch);
		System.out.println(word1); //3������ ������ ����
		System.out.println(word2); //6��~11�� �������� ����
		System.out.println(l);
		
	}
	
}
