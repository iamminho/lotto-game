import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIFTH(5_000, 3),
    FORTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6),
    NONE(0, 0);

    private final int prize;
    private final int count;

    Rank(int prize, int count) {
        this.prize = prize;
        this.count = count;
    }
    public static Rank findRank(int count, boolean hasBonusNumber) {
        if (count == 5) {
            return SecondOrThirdRank(count, hasBonusNumber);
        }
        return otherRank(count);
    }

    private static Rank SecondOrThirdRank(int count, boolean hasBonusNumber) {
        if(count == 5 && hasBonusNumber) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }

    private static Rank otherRank(int count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.count == count)
                .findAny()
                .orElse(NONE);
    }
}
