package day0125;

import java.util.Scanner;

public class RandomSuMatch_04 {

	public static void main(String[] args) {
		
		// ����ȸ���� ���ļ� ���� �˾Ƹ��߱�(1~100)
		// 1: 77
		// 77���� �۽��ϴ�
		// 2: 66
		// �¾ƿ�~������ 66�Դϴ�.. ���α׷�����
		// while(true)
		
		Scanner sc= new Scanner(System.in);
		
		int rnd = (int)(Math.random()*100)+1;	//1~100������ ���� ����
		int su;									//�Է��� ��
		int cnt = 0; 							//�Է��� Ƚ��
		
		while(true) {
			cnt++; //ī��Ʈ
			
			System.out.print(cnt + "ȸ: ");
			su = sc.nextInt();
			
			if(su > rnd) {
				System.out.println(su+"���� �۽��ϴ�");
			}
			else if(su < rnd) {
				System.out.println(su+"���� Ů�ϴ�");
			}
			else {
				System.out.println("�����Դϴ�~ " + rnd + "�Դϴ�~");
				break;
			}
		}
		
		System.out.println("���α׷� ����");
		
	}
	
}
