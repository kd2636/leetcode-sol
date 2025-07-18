class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return (1.0 / myPowHelper(x, -1 * (long)n));
        return myPowHelper(x, n);
    }

    private double myPowHelper(double x, long n) {
        if (n == 0) return 1;
        
        double part = myPowHelper(x, n / 2);
        if (n % 2 == 0) {
            return part * part;
        } else {
            return part * part * x;
        }
    }
}