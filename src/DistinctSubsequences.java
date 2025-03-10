    import java.util.logging.Logger;

    /**
     * The DistinctSubsequences class provides methods to count the number of distinct subsequences
     * of a source string that match a target string using dynamic programming.
     */
    public class DistinctSubsequences {

        private static final Logger logger = Logger.getLogger(DistinctSubsequences.class.getName());

        /**
         * Calculates the number of distinct subsequences of the source string that match the target string.
         *
         * @param source the source string (s)
         * @param target the target string (t)
         * @return the number of distinct subsequences
         */
        public int countDistinctSubsequences(String source, String target) {
            int sourceLength = source.length();
            int targetLength = target.length();
            logger.info("Calculating distinct subsequences for Source: " + source + ", Target: " + target);

            int[][] subsequenceCount = initializeSubsequenceCount(sourceLength, targetLength);
            fillSubsequenceCountTable(source, target, subsequenceCount, sourceLength, targetLength);

            logger.info("Result: " + subsequenceCount[sourceLength][targetLength]);
            return subsequenceCount[sourceLength][targetLength];
        }

        /**
         * Initializes the subsequence count table with base cases.
         *
         * @param sourceLength the length of the source string
         * @param targetLength the length of the target string
         * @return initialized subsequence count table
         */
        private int[][] initializeSubsequenceCount(int sourceLength, int targetLength) {
            int[][] subsequenceCount = new int[sourceLength + 1][targetLength + 1];
            for (int i = 0; i <= sourceLength; i++) {
                subsequenceCount[i][0] = 1; // An empty target can always be formed by deleting all characters from source
            }
            logger.fine("Initialized DP table with base cases.");
            return subsequenceCount;
        }

        /**
         * Fills the subsequence count table using dynamic programming.
         *
         * @param source the source string
         * @param target the target string
         * @param subsequenceCount the dp table
         * @param sourceLength the length of the source string
         * @param targetLength the length of the target string
         */
        private void fillSubsequenceCountTable(String source, String target, int[][] subsequenceCount, int sourceLength, int targetLength) {
            for (int i = 1; i <= sourceLength; i++) {
                for (int j = 1; j <= targetLength; j++) {
                    if (source.charAt(i - 1) == target.charAt(j - 1)) {
                        subsequenceCount[i][j] = subsequenceCount[i - 1][j - 1] + subsequenceCount[i - 1][j];
                    } else {
                        subsequenceCount[i][j] = subsequenceCount[i - 1][j];
                    }
                }
            }
            logger.fine("DP table filled successfully.");
        }
    }
