package day0119;

public class CastArgsTest_03 {

	public static void main(String[] args) {
		
		/*
		 * ��ǰ��: ������13 mini
		 * ����: 20��
		 * �ܰ�: 95����
		 * �ѱݾ�: ****��
		 */
		
		//����
		String name = args[0];  //"������13 mini"
		int num = Integer.parseInt(args[1]);  //20
		int price = Integer.parseInt(args[2]);  //95
		
		//���
		int tot = num * price;
		
		//���
		System.out.println("��ǰ��: " + name);
		System.out.println("����: " + num + "��");
		System.out.println("�ܰ�: " + price + "����");
		System.out.println("�ѱݾ�: " + tot + "����");
		
	}

}
