class Solution {
    public int climbStairs(int n) {
        return f(n);
    }

    // f(i) -> 0 to i

    private int f(int i) {
        if (i < 0) return 0;
        if (i == 0) return 1;

        return f(i - 1) + f(i - 2);
    }
}