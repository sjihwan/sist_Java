package day0118;

public class EscapeSequence_03 {

	public static void main(String[] args) {
		
		//Escape Sequence: ���ڿ� ������ Ư���� �ǹ̷� �ؼ�
		// ��� \�� ������
		// \t: ���� ��(tab) ��ġ�� �̵�
		// \n: ���� �������� �̵�
		// \': ����ǥ(�ֵ���ǥ �ȿ� ����ǥ ���)
		// \": �ֵ���ǥ(�ֵ���ǥ �ȿ� �ֵ���ǥ ���)
		// \\: ��������(�ֵ���ǥ �ȿ� �������� ���)
		
		System.out.println("Apple\tOrange");	//Apple	Orange
		System.out.println("Apple\"");			//Apple"
		System.out.println("\"Hello\"");		//"Hello"
		System.out.println("C:\\");				//C:\
		System.out.println("\"apple\", \"banana\", \"kiwi\"");  //"apple", "banana", "kiwi"
		
	}

}
