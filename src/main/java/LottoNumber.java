import java.util.List;

public class LottoNumber {
    private final String INVALID_SIZE = "[ERROR] 당첨번호의 개수가 6개여야 합니다.";
    private final String INVALID_BOUNDARY = "[ERROR] 당첨번호가 1과 45사이의 숫자여야 합니다.";
    private final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private final int MAX_NUMBER = 45;
    private final int MIN_NUMBER = 1;
    private List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validateNumbers(numbers);
        validateNumberBoundary(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    private void validateNumberBoundary(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> {
                    if (number < MIN_NUMBER || number > MAX_NUMBER) {
                        throw new IllegalArgumentException(INVALID_BOUNDARY);
                    }
                });
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
