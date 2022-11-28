import java.util.EnumMap;
import java.util.List;

public class LottoTicket {
    private LottoResult lottoResult = new LottoResult();
    private List<Lotto> ticket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.ticket = lottoTicket;


    }

    public LottoResult getResult(LottoNumber lottoNumber, LottoBonusNumber bonusNumber) {
        ticket.stream()
                .forEach(lotto -> addRank(lotto, lottoNumber.getNumbers(), bonusNumber.getBonusNumber()));
        return lottoResult;
    }

    private void addRank(Lotto lotto, List<Integer> lottoNumber, int bonusNumber) {
        int count = lotto.checkLottoNumberCount(lottoNumber);
        boolean hasBonusNumber = lotto.checkHasBonusNumber(bonusNumber);
        Rank rank = Rank.findRank(count, hasBonusNumber);
        lottoResult.addResult(rank);
    }
}
