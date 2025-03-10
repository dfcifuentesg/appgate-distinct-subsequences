import java.util.logging.Logger;

/**
 * The Main class runs the program to calculate the number of distinct subsequences
 * of a source string that match a target string.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        String source = "babgbag";
        String target = "bag";

        logger.info("Source: " + source + ", Target: " + target);

        DistinctSubsequences solution = new DistinctSubsequences();
        int result = solution.countDistinctSubsequences(source, target);

        logger.info("Number of distinct subsequences: " + result);
    }
}
