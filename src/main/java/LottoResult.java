import java.util.Arrays;
import java.util.EnumMap;

public class LottoResult {
    private EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);

    public LottoResult() {
        setUp();
    }

    private void setUp() {
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> result.put(rank, 0));
    }

    public void addResult(Rank rank) {
        if (rank != Rank.NONE) {
            result.put(rank, result.get(rank) + 1);
        }
    }

    public EnumMap<Rank, Integer> getResult() {
        return this.result;
    }
}
