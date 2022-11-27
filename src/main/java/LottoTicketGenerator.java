import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {
    private LottoGenerator lottoGenerator;

    public LottoTicketGenerator(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> generate(int purchaseNumber) {
        List<Lotto> lottoTicket = new ArrayList<>();
        while (purchaseNumber-- > 0) {
            Lotto lotto = new Lotto(lottoGenerator.generate());
            lottoTicket.add(lotto);
        }
        return lottoTicket;
    }
}
