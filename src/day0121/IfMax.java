package day0121;

import java.util.Scanner;

public class IfMax {

	public static void main(String[] args) {
		
		/*
		 * 세수를 입력하여 더 큰 수를 출력하시오 x,y,z
		 * if or 조건연산자를 이용하여 결과 출력할 것
		 * 3개의 수: 10,20,30
		 * max=30 이라고 출력하세요
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("세개의 수를 입력하세요");
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		
		int max;
		
		System.out.println("입력한 수: " + x + "," + y + "," + z);
		
		System.out.println("**if문**");
		if(x>y&&x>z)
			max=x;
		else if(y>x&&y>z)
			max=y;
		else
			max=z;
		System.out.println("max="+max);
		
		System.out.println("**삼항연산자**");
		max = x>y&&x>z ? x:
			  y>x&&y>z ? y:z;
		System.out.println("max="+max);
	}

}
