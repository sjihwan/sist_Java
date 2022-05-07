package day0118;

public class EscapeSequence_03 {

	public static void main(String[] args) {
		
		//Escape Sequence: 문자열 내에서 특별한 의미로 해석
		// 모두 \로 시작함
		// \t: 다음 탭(tab) 위치로 이동
		// \n: 다음 라인으로 이동
		// \': 따옴표(쌍따움표 안에 따옴표 출력)
		// \": 쌍따옴표(쌍따옴표 안에 쌍따옴표 출력)
		// \\: 역슬래시(쌍따옴표 안에 역슬래시 출력)
		
		System.out.println("Apple\tOrange");	//Apple	Orange
		System.out.println("Apple\"");			//Apple"
		System.out.println("\"Hello\"");		//"Hello"
		System.out.println("C:\\");				//C:\
		System.out.println("\"apple\", \"banana\", \"kiwi\"");  //"apple", "banana", "kiwi"
		
	}

}
