class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        long p = n;

        if(p < 0){
            x = 1 / x;
            p = -p;
        }

        while(p > 0){
            if(p % 2 == 1){
                result *= x;
                p--;
                continue;
            }

            x *= x;
            p /= 2;
        }

        return result;
    }
}
