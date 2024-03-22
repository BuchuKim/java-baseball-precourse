package presentation;

import application.ScoreCalculator;
import domain.AnswerGenerator;
import domain.Score;

public class BaseBallController {
	private final InputReceiver inputReceiver;
	private final ScoreCalculator scoreCalculator;
	private final AnswerGenerator answerGenerator;

	public BaseBallController(InputReceiver inputReceiver,
		ScoreCalculator scoreCalculator,
		AnswerGenerator answerGenerator) {
		this.inputReceiver = inputReceiver;
		this.scoreCalculator = scoreCalculator;
		this.answerGenerator = answerGenerator;
	}

	/**
	 * 사용자가 정답을 맞힐 때까지 숫자를 입력받으며 점수를 출력합니다.
	 */
	public void start() {
		String answer = answerGenerator.generateAnswer();

		while (true) {
			try {
				String input = inputReceiver.getPlayerInput();
				Score score = scoreCalculator.calculate(answer, input);
				if (score.isFinished()) {
					break;
				}
				System.out.println(score.generateScoreMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 숫자로 구성된 3자리 숫자를 입력해주세요!!");
			}
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}
}
