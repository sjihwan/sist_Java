package day0126;

import java.util.Scanner;

public class ArrayScanChange_07 {

	public static void main(String[] args) {
		
		/*
		 * �Է��� �л��� �ο����� ��������� ǥ��(�Է�)��
		 * �л��� �̸��� ������ �Է��� ���
		 * �հ�� ��յ� ���غ���
		 */
		
		int inwon;
		String name[];
		int score[];
		int tot = 0;
		int rank[]; //���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ο����� �Է��Ͻÿ�");
		inwon = Integer.parseInt(sc.nextLine()); //�ڿ� �̸����ڿ��� ���Ƿ�
		/*
		 * nextInt()�� ���� ���ڴ� �Է� ���� �ʴ´ٰ� �Ѵ�. �׷��� nextInt()�� 3�� �ְ� enterŰ�� ġ�ԵǸ�, \n(���๮��)��
		 * ���ۿ� ���� �ǰ� nextLine()������ ���� ������ ġ������ �Է� ���ۿ� ���� \n�� ���� �޾Ƶ鿩 �״�� �Ѿ�� �ſ���.
		 */
		
		//inwon��ŭ �̸�,������ �迭 ����
		name = new String[inwon];
		score = new int[inwon];
		rank = new int[inwon];
		
		//inwon��ŭ �������Է�
		for(int i=0; i<inwon; i++) {
			System.out.print((i+1) +"��° �л���: ");
			name[i] = sc.nextLine();
			
			System.out.print((i+1) +"��° �л�����: ");
			score[i] = Integer.parseInt(sc.nextLine());
			
			//���� ���
			tot += score[i];
		}
		
		//��� ���ϱ�(����for��)
		for(int i=0; i<inwon; i++) {
			rank[i] = 1;
			for(int j=0; j<inwon; j++) {
				//�񱳵Ǵ� ����� ������ �� ������ �ش��л���� 1����
				if(score[i]<score[j])
					rank[i]++;
			}
		}
		
		//���
		System.out.println("��ȣ\t�̸�\t����\t���");
		System.out.println("---------------------------");
		for(int i=0; i<inwon; i++) {
			System.out.println((i+1) + "\t" + name[i] + "\t" + score[i] + "\t" + rank[i]);
		}		
		System.out.println("---------------------------");
		System.out.println("����: " + tot);
		System.out.println("���: " + tot/inwon);

	}

}
