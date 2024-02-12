package fileStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TEST2 {
	public static void main(String[] args) {
		// 실습
		// 1) DataOutputStream을 이용하여 국어, 영어, 수학 점수 3개를 입력을 받아
		// OutputFolder 내에 myScoreFile이라는 이름으로 기록하세요.
		// 2) myScoreFile에 있는 내용을 DataInputStream으로 읽어들여
		// 성적의 평균을 구하고 이를 출력하세요.
		// 소수점 1번째 자리까지만 출력합니다.
		// ※ Input, Output 모두 try with resource로 예외처리를 진행합니다.
		String fileName = "OutputFolder/myScoreFile";
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
			Scanner sc = new Scanner(System.in);
			System.out.println("국어, 영어, 수학 점수를 입력하세요 > ");
			for (int i = 0; i < 3; i += 1) {
				while (true) {
					System.out.print(">> ");
					double data = sc.nextDouble();
					if (data >= 0 && data <= 100) {
						dos.writeDouble(data);
						break;
					} else
						System.out.println("재입력하세요.");
				}
			}
		} catch (IOException e) {
			System.out.println("파일로 출력하는데 문제가 발생하였습니다.");
		}

		try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
			double avg = 0;
			int count = 0;
			while (true) {
				try {
					avg += dis.readDouble();
					count += 1;
				} catch (EOFException e) {
					break; // EOF는 잘못 읽었거나, 대부분의 경우 더이상 읽을 내용이 없음
				}
			}
			System.out.printf("평균 : %.1f점\n", avg / count);
		} catch (IOException e) {
			System.out.println("파일을 읽는 중에 문제가 발생하였습니다.");
		}
	}
}
