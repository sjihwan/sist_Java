package day0120;

public class OperEx_05 {

	public static void main(String[] args) {

		boolean bool = false;
		System.out.println("a="+bool);  //false
		System.out.println("b="+!bool); //true
		
		boolean bool1 = 5>3;
		System.out.println("c="+bool1); //true
		System.out.println("d="+!(5>3));//false
		//System.out.println("d="+!5); //���ڴ� ������ �� ����(�������� ����)
		
		//�񱳿�����(����): >,<,>=,<=,==,!=
		//��������: &&(and),||(or),!(not)
		int a=5,b=3,c=5;
		
		//������� true,false
		System.out.println("��,�񱳿�����");
		System.out.println(a>b);
		System.out.println(a==b);
		System.out.println(!(a==b));
		System.out.println(a!=b);	//a!=b�� !(a==b)�� ����
		System.out.println(a==c);
		System.out.println(a>b&&b>c); //&&: �Ѵ� ���� �ƴϸ� false
		System.out.println(a>b||b>c); //||: ���߿� �ϳ��� ���̸� true
		
	}

}
