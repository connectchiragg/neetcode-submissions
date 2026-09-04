class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(true){
            if(set.contains(n)) return false;
            if(n == 1) return true;

            set.add(n);
            n = solve(n);
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
