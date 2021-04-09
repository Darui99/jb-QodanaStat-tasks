package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    private void testForCheck(final String[] names) {
        assertTrue(new Checker().check(names, new Solver().solve(names)));
    }

    private void testImpossible(final String[] names) {
        assertNull(new Solver().solve(names));
    }

    @Test
    public void test1() {
        testForCheck(new String[]{"suzumiya", "haruhi", "itsuki", "koizumi", "ken"});
    }

    @Test
    public void test2() {
        testImpossible(new String[]{"aboba", "baobab", "abacaba"});
    }

    @Test
    public void test3() {
        testImpossible(new String[]{"prefix", "pref"});
    }

    @Test
    public void test4() {
        testForCheck(new String[]{"equal", "equal", "equal"});
    }

    @Test
    public void test5() {
        testForCheck(new String[]{"solo"});
    }

    @Test
    public void test6() {
        testForCheck(new String[]{"pref", "prefi", "prefix"});
    }

    @Test
    public void test7() {
        testImpossible(new String[]{"sakura", "hori", "mikasiba", "nozaki", "kashima", "yuzuki", "mikoto"});
    }

    @Test
    public void test8() {
        testForCheck(new String[]{"qwerty", "qwefal", "qwefared", "qszxc", "qszxcp", "hello", "helsing"});
    }

    @Test
    public void test9() {
        testForCheck(new String[]{"abc", "bca", "bcc", "dzc", "dzd"});
    }

    @Test
    public void test10() {
        testForCheck(new String[]{"a", "bc", "bde", "bdf"});
    }
}