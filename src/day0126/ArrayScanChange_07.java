package day0126;

import java.util.Scanner;

public class ArrayScanChange_07 {

	public static void main(String[] args) {
		
		/*
		 * 입력할 학생의 인원수가 몇명인지를 표시(입력)후
		 * 학생의 이름과 점수를 입력후 출력
		 * 합계와 평균도 구해보자
		 */
		
		int inwon;
		String name[];
		int score[];
		int tot = 0;
		int rank[]; //등수
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("인원수를 입력하시오");
		inwon = Integer.parseInt(sc.nextLine()); //뒤에 이름문자열이 오므로
		/*
		 * nextInt()는 개행 문자는 입력 받지 않는다고 한다. 그래서 nextInt()에 3을 넣고 enter키를 치게되면, \n(개행문자)는
		 * 버퍼에 남게 되고 nextLine()에서는 내가 문장을 치기전에 입력 버퍼에 남은 \n을 먼저 받아들여 그대로 넘어가는 거였다.
		 */
		
		//inwon만큼 이름,점수의 배열 생성
		name = new String[inwon];
		score = new int[inwon];
		rank = new int[inwon];
		
		//inwon만큼 데이터입력
		for(int i=0; i<inwon; i++) {
			System.out.print((i+1) +"번째 학생명: ");
			name[i] = sc.nextLine();
			
			System.out.print((i+1) +"번째 학생점수: ");
			score[i] = Integer.parseInt(sc.nextLine());
			
			//총점 계산
			tot += score[i];
		}
		
		//등수 구하기(다중for문)
		for(int i=0; i<inwon; i++) {
			rank[i] = 1;
			for(int j=0; j<inwon; j++) {
				//비교되는 대상이 점수가 더 높으면 해당학생등수 1증가
				if(score[i]<score[j])
					rank[i]++;
			}
		}
		
		//출력
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("---------------------------");
		for(int i=0; i<inwon; i++) {
			System.out.println((i+1) + "\t" + name[i] + "\t" + score[i] + "\t" + rank[i]);
		}		
		System.out.println("---------------------------");
		System.out.println("총점: " + tot);
		System.out.println("평균: " + tot/inwon);

	}

}
