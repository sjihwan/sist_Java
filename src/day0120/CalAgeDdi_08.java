package day0120;

import java.util.Calendar;
import java.util.Scanner;

public class CalAgeDdi_08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); //new�� ������,��ü�� �����ϰڴٴ� Ű����
		Calendar cal = Calendar.getInstance();
				
		//��������
		int curYear = cal.get(Calendar.YEAR);
		int myYear,age;
		String name,ddi;
				
		//�Է�
		System.out.print("�̸��Է�: ");
		name = sc.nextLine();
		System.out.print("�¾ ���� �Է�: ");
		myYear = sc.nextInt();
				
		//���̰��
		age = curYear - myYear + 1;
				
		//���ǿ�����(���׿�����)
		//���ǽ� ? (������ ���̸�)��1 : (������ �����̸�)��2
		ddi = myYear%12==0?"������":
			myYear%12==1?"��":
				myYear%12==2?"��":
					myYear%12==3?"����":
						myYear%12==4?"��":
							myYear%12==5?"��":
								myYear%12==6?"ȣ����":
									myYear%12==7?"�䳢":
										myYear%12==8?"��":
											myYear%12==9?"��":
												myYear%12==10?"��":"��";	
				
		//�������
		System.out.println("���� �� ���ϱ�");
		System.out.println("�̸�: " + name);
		System.out.println("���糪��: " + age + "��");
		System.out.println("��: " + ddi + "��");
		
		sc.close();
		
	}

}
