package day0126;

import java.util.Scanner;

public class ArrayStringSearchEx_09 {

	public static void main(String[] args) {
		
		/*
		 * �̸��� �Է��ؼ� ���̸��� ���° �ִ��� 
		 * ���̸��� �����ϴ� �� ���
		 * �� �̶�� �Է��ϸ� �˻��� �����մϴ� ��� ������ ����ǰ� �Ұ�!!
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String[] data = {"���ؿ�","������","������","�����","���ƶ�","�̿��","�̰��","����ȣ","������"};
		boolean flag; //(�߰߿���)ã�Ҵ�&��ã�Ҵٸ� �˸��� ���� ����
		String name; //�˻����̸�
		
		while(true) {
			System.out.println("ã���� �ϴ� �̸��� �Է��ϼ���(����:��)");
			name = sc.nextLine();
			
			//==�� ����Ÿ�� �񱳳�������
			//StringŸ���� ������ equals()�޼��带 ���
			
			//���� �Է½�..����
			if(name.equals("��")) {
				System.out.println("�˻��� �����մϴ�");
				break;
			}
			
			flag = false; //�߰߿��� false�� �ʱ�ȭ
			for(int i=0; i<data.length; i++) {
				if(name.equals(data[i])) {
					flag = true;
					System.out.println(name+ "�� " + i + "��°�� �ֽ��ϴ�");
				}
			}
			
			//ã�� ��������..
			if(!flag) {
				System.out.println(name + "�� �����ϴ�");
			}
		}

	}

}