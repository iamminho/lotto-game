import java.util.Random;

public class LottoRandomNumberGenerator {
    private final int MAX_NUMBER = 45;
    private final int MIN_NUMBER = 1;
    private Random random = new Random();


    public int generate() {
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }
}
