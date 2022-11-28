import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public int checkLottoNumberCount(List<Integer> lottoNumber) {
        return (int) lotto.stream()
                .filter(number -> lottoNumber.contains(number))
                .count();
    }

    public boolean checkHasBonusNumber(int bonusNumber) {
        return lotto.stream()
                .anyMatch(number -> number == bonusNumber);
    }
}


