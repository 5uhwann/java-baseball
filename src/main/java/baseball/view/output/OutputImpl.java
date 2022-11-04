package baseball.view.output;


public class OutputImpl implements Output {

    private final String START_MESSAGE = "숫자 야구를 시작합니다.";
    private final String NUMBER_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";

    @Override
    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    @Override
    public void printNumberRequest() {
        System.out.print(NUMBER_REQUEST_MESSAGE);
    }
}
