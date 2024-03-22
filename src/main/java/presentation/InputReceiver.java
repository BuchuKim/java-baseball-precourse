package presentation;

import java.util.Scanner;

import domain.Score;

public class InputReceiver {
	private final static Scanner scanner = new Scanner(System.in);

	/**
	 * 플레이어가 문제를 맞히기 위해 입력하는 입력값을 받습니다.
	 * @return
	 */
	public String getPlayerInput() throws IllegalArgumentException {
		System.out.print("숫자를 입력해주세요 : ");
		String input = scanner.nextLine();
		validateInput(input);
		return input;
	}

	/**
	 * 길이 3의 숫자로 된 문자열이 맞는지 검증합니다.
	 * @param input
	 */
	private void validateInput(String input) {
		if (input.length() != Score.ANSWER_LENGTH) {
			throw new IllegalArgumentException();
		}
		for (char c : input.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException();
			}
		}
	}
}
