import java.util.List;

public class LottoBonusNumber {
    private String OVERLAP_NUMBER = "[ERROR] 보너스 숫자가 로또 당첨번호와 중첩되면 안됩니다.";
    private int bonusNumber;

    public LottoBonusNumber(int bonusNumber, LottoNumber lottoNumber) {
        validateOverlap(bonusNumber, lottoNumber.getNumbers());
        this.bonusNumber = bonusNumber;
    }

    private void validateOverlap(int bonusNumber, List<Integer> lottoNumber) {
        if (lottoNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(OVERLAP_NUMBER);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
