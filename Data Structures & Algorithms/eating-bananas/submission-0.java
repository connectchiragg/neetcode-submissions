class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;

        for(int i = 0; i < piles.length; i++){
            maxSpeed = Math.max(maxSpeed, piles[i]);
        }

        // starting min speed at max value to decrease gradually
        int result = maxSpeed;

        for(int i = maxSpeed; i > 0; i /= 2){
            while(result - i > 0 && getHours(piles, result - i) <= h){
                result -= i;
            }
        }

        return result;
    }

    private int getHours(int[] piles, int speed){
        int result = 0;

        for(int i = 0; i < piles.length; i++){
            result += Math.ceil((double) piles[i] / speed);
        }

        return result;
    }
}
