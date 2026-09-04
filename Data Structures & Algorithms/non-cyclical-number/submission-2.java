class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        while(true){
            slow = solve(slow);
            fast = solve(solve(fast));
            if(fast == 1) return true;
            if(slow == fast) return false;
        }
    }

    private int solve(int n){
        int result = 0;

        while(n > 0){
            result += (n % 10) * (n % 10);
            n /= 10;
        }

        return result;
    }
}
