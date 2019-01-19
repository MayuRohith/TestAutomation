package com.javabasic;

import java.util.Scanner;

public class Triangle {

	/*
	 * 
	 **
	 ***
	 ****
	 *****

	* 
   * * 
  * * * 
 * * * * 

	 */
	public static void main(String a[]) {
		squre();
		triangle();

	}

	@SuppressWarnings("unused")
	public static void squre() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int row = s.nextInt();

		rowCounter: for (int i = 0; i < row; i++) {
			coloumnCounter: for (int j = 0; j < row; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		//NextLoop
		rowCounter: for (int i = 1; i < row; i++) {

			spacecolCounter: for (int j = row; j > i; j--) {
				System.out.print(" ");
			}
			starcolCounter: for (int m = i; m < 2 * i; m++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	@SuppressWarnings("unused")
	public static void triangle() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int row = s.nextInt();

		rowCounter: for (int i = 1; i < row; i++) {

			spacecolCounter: for (int j = row; j > i; j--) {
				System.out.print(" ");
			}
			starcolCounter: for (int m = i; m < 2 * i; m++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		//Next Loop
		rowCounter: for (int i = 0; i < row; i++) {
			coloumnCounter: for (int j = 0; j < row; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
