package day0126;

public class RankReview_08 {

	public static void main(String[] args) {
		/*
		 * �� �л����� ������ ���� ����,���,����� ���Ͽ� ���
		 * ��¾����...
		 * ��ȣ �̸� �ڹ� ����Ŭ ���� ��� ���
		 */
		
		//�迭��������
		String[] name = {"������","������","������","������","������"};
		int[] java = {99,78,89,67,100};
		int[] oracle = {77,66,88,99,56};
		//tot,avg,rank�� 5��(�ο�����ŭ) ������ ���� ��
		int[] tot = new int[5];
		double[] avg = new double[5];
		int[] rank = new int[5];
		
		//����&��� ���ϱ�
		for(int i=0; i<name.length; i++) {
			tot[i] = java[i] + oracle[i];
			avg[i] = tot[i]/2.0;
		}
		
		//��� ���ϱ�...�񱳸� ���� ����for��
		for(int i=0; i<name.length; i++) {
			rank[i] = 1;
			for(int j=0; j<name.length; j++) {
				if(avg[i]<avg[j])
					rank[i]++;
			}
		}
		
		//���
		System.out.println("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���\t���\t");
		for(int i=0; i<name.length; i++) {
			System.out.println((i+1)+"\t"+name[i]+"\t"+java[i]+"\t"+oracle[i]+"\t"+tot[i]+"\t"+avg[i]+"\t"+rank[i]);
		}
	}
	
}
