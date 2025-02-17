package baseball.domain.baseballAlgorithm;

import static baseball.domain.baseballAlgorithm.BallAndStrike.*;

import java.util.ArrayList;
import java.util.List;

public class BaseballAlgorithmImpl implements BaseballAlgorithm {


    @Override
    public String checkBaseballResult(List<Integer> randomNumber, String userInput) {
        List<String> inputNumbers = new ArrayList<>(List.of(userInput.split("")));
        BallAndStrikeResult ballAndStrikeResult = new BallAndStrikeResult();

        for (int i = 0; i < inputNumbers.size(); i++) {
            int number = Integer.parseInt(inputNumbers.get(i));
            if (randomNumber.contains(number)) {
                countStrikeAndBall(randomNumber, inputNumbers, number, ballAndStrikeResult);
            }
        }

        String baseballResultMessage = makeBaseballResultMessage(ballAndStrikeResult);
        ballAndStrikeResult.clear();
        return baseballResultMessage;
    }

    private String makeBaseballResultMessage(BallAndStrikeResult ballAndStrikeResult) {
        int ballCount = ballAndStrikeResult.getBallCount();
        int strikeCount = ballAndStrikeResult.getStrikeCount();

        if (ballCount + strikeCount == 0) {
            return nothing.getKoreanTag();
        }
        if (ballCount != 0 && strikeCount == 0) {
            return ballCount + ball.getKoreanTag();
        }
        if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + strike.getKoreanTag();
        }
        return ballCount + ball.getKoreanTag() + " " + strikeCount + strike.getKoreanTag();
    }

    private void countStrikeAndBall(List<Integer> randomNumber, List<String> inputNumber, int number,
                                    BallAndStrikeResult ballAndStrikeResult) {
        if (randomNumber.indexOf(number) == inputNumber.indexOf(String.valueOf(number))) {
            ballAndStrikeResult.update(strike);
            return;
        }
        ballAndStrikeResult.update(ball);
    }
}
