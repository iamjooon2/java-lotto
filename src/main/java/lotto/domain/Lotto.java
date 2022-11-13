package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_RANGE_MAX = 45;
    private static final int LOTTO_RANGE_MIN = 1;
    private static final String ERROR_NUMBERS_COUNT = "[ERROR] 로또 숫자는 6개여야 합니다.";
    private static final String ERROR_NUMBER_DUPLICATION = "[ERROR] 중복된 번호가 존재합니다.";
    private static final String ERROR_NUMBER_RANGE = "[ERROR] 1부터 45 사이의 숫자만 입력가능합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_NUMBERS_COUNT);
        }
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > LOTTO_RANGE_MAX || number < LOTTO_RANGE_MIN) {
                throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_NUMBER_DUPLICATION);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    // TODO: 추가 기능 구현
}
