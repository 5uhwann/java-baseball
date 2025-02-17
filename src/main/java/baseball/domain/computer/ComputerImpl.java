package baseball.domain.computer;

import baseball.domain.baseballAlgorithm.BaseballAlgorithm;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerImpl implements Computer {

    private final BaseballAlgorithm baseballAlgorithm;

    public ComputerImpl(BaseballAlgorithm baseballAlgorithm) {
        this.baseballAlgorithm = baseballAlgorithm;
    }

    @Override
    public List<Integer> generateRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(pickedNumber)) {
                randomNumber.add(pickedNumber);
            }
        }
        return randomNumber;
    }

    @Override
    public String checkBallAndStrike(List<Integer> randomNumber, String userInput) {
        return baseballAlgorithm.checkBaseballResult(randomNumber, userInput);
    }
}
