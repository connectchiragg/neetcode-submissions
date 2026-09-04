class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;
        int result = 0;
        boolean negative = false;

        if(x < 0){
            x = -x;
            negative = true;
        }

        while(x > 0){
            int digit = x % 10;
            if(result > Integer.MAX_VALUE / 10) return 0;
            result *= 10;

            if(result > Integer.MAX_VALUE - digit) return 0;
            result += digit;
            x /= 10;
        }

        return negative ? -result : result;
    }
}
