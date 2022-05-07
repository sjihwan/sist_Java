package day0126;

public class StringEx_01 {

	public static void main(String[] args) {
		
		System.out.println("String��ü�� ���� ��� �޼��� �����մϴ�");
		
		String str1 = "apple";
		String str2 = "Apple";
		String str3 = "Have a Nice Day";
		String str4 = "   Happy Day   ";
		
		System.out.println("str3�� ����: " + str3.length());
		System.out.println("str4�� ����: " + str4.length());
		
		//trim(): �߰��� �ִ� ������ �������� ����
		System.out.println("�յڰ������� str4�� ����: " + str4.trim().length());
		System.out.println("*"+str4+"*");
		System.out.println("*"+str4.trim()+"*");
		
		System.out.println("str3���� 0������: " + str3.charAt(0));
		System.out.println("str3���� 7������: " + str3.charAt(7));
		
		//indexOf('char��'): ���ڰ� �����ϴ� ù ��ġ(�ε��� ��ȣ)�� ��ȯ��
		System.out.println("str3���� H�� �ε���: " + str3.indexOf('H'));
		System.out.println("str3���� N�� �ε���: " + str3.indexOf('N'));
		
		//substring(�����ε���,���ε���-1): ���ε����� �����Ҽ��ִ�
		System.out.println("str3���� Have���: " + str3.substring(0, 4));
		System.out.println("str3���� Nice���: " + str3.substring(7, 11));
		
		//equals(): ���ڿ� ��
		System.out.println("���ڿ���: " + str1.equals(str2));
		System.out.println("���ڿ���: " + str1.equalsIgnoreCase(str2)); //��ҹ��� �������
		
		/*
		 * ���ڿ� ���� a,b
		 * a.compareTo(b)
		 * compareTo()�� ���� ��ġ�� ���� ��(�ƽ�Ű���� ���� ��ȯ)
		 * a�� b�� ���� ��� 0
		 * a�� ���� ��� -(���ĺ� ���̸�ŭ ���̳ʽ���)
		 * a�� ū ��� +(���ĺ� ���̸�ŭ �÷�����)
		 */
		System.out.println(str1.compareTo(str2)); //a(97)�� A(65) �� //+32 ��ȯ
		System.out.println(str1.compareTo(str1)); //0 ��ȯ
		System.out.println("computer".compareTo("command")); //p(112)�� m(109) ��
		System.out.println("hello".compareTo("hello")); //0 ��ȯ
		System.out.println("apple".compareTo("banana")); //a�� b �� //-1 ��ȯ
		System.out.println("o".compareTo("orange")); //�� ���ڿ��� ���Ե� ���, ���ڿ� ������ ���̰� ��ȯ
		System.out.println("".compareTo("orange")); //���ڿ� ������ ���̰� ��ȯ //-6 ��ȯ
		System.out.println("ȫ".compareTo("��"));
		
		//startsWith(): boolean�� ��ȯ
		System.out.println("str3�� Have�� �����ϸ� true: " + str3.startsWith("Have"));
		System.out.println("str3�� Have�� �����ϸ� true: " + str3.startsWith("Happy"));
		//endsWith(): boolean�� ��ȯ
		System.out.println(str3.endsWith("Day"));	//true
		System.out.println(str3.endsWith("day"));	//��ҹ��ڱ���...false
		
		//split(): ���ڿ� �и��Ͽ� �迭 ����
		String str5 = "red,blue,green,yellow,pink,white";
		System.out.println("str5�� �ĸ��� �и��Ͽ� ����ϱ�");
		String[] arr = str5.split(",");
		System.out.println(",�� ���е� ���� ����: " + arr.length);
		for(String color:arr)
			System.out.println(color);
		
		System.out.println("str3�� �ҹ��� ���: " + str3.toLowerCase());
		System.out.println("str3�� �빮�� ���: " + str3.toUpperCase());
		
		//String.valueOf(): ���ڰ��� ���ڿ��� �ٲ���
		String a = String.valueOf(100);		//int-->String
		String b = String.valueOf(12.345);	//double-->String
		System.out.println(a+b);
		String a2 = 100 + "";
		String b2 = 23.5 + "";
		System.out.println(a2+b2);
		
		//replace(): ���ڿ��� �Ϻθ� ����
		System.out.println("���ڿ��� �Ϻκ���");
		System.out.println(str3.replace('a', '*'));			//��� a-->*
		System.out.println(str3.replace("Nice", "Good"));	//Nice-->Good
		
	}
	
}
