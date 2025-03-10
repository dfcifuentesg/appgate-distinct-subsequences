package org.appgate;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the Solution class.
 */
public class DistinctSubsequencesTest {

    private DistinctSubsequences solution;

    @BeforeEach
    public void setUp() {
        solution = new DistinctSubsequences();
    }

    @Test
    public void testCountDistinctSubsequences_BasicCase1() {
        String source = "rabbbit";
        String target = "rabbit";
        int result = solution.countDistinctSubsequences(source, target);
        assertEquals(3, result, "Expected 3 ways to form 'rabbit' from 'rabbbit'");
    }

    @Test
    public void testCountDistinctSubsequences_BasicCase2() {
        String source = "babgbag";
        String target = "bag";
        int result = solution.countDistinctSubsequences(source, target);
        assertEquals(5, result, "Expected 5 ways to form 'bag' from 'babgbag'");
    }

    @Test
    public void testCountDistinctSubsequences_EmptyTarget() {
        String source = "abc";
        String target = "";
        int result = solution.countDistinctSubsequences(source, target);
        assertEquals(1, result, "There is 1 way to form an empty target string");
    }

    @Test
    public void testCountDistinctSubsequences_EmptySource() {
        String source = "";
        String target = "abc";
        int result = solution.countDistinctSubsequences(source, target);
        assertEquals(0, result, "Cannot form a non-empty target from an empty source");
    }

    @Test
    public void testCountDistinctSubsequences_NoMatch() {
        String source = "abc";
        String target = "xyz";
        int result = solution.countDistinctSubsequences(source, target);
        assertEquals(0, result, "Expected 0 ways since 'xyz' is not in 'abc'");
    }

    @Test
    public void testCountDistinctSubsequences_SameStrings() {
        String source = "abc";
        String target = "abc";
        int result = solution.countDistinctSubsequences(source, target);
        assertEquals(1, result, "Expected 1 way when source and target are the same");
    }
}
