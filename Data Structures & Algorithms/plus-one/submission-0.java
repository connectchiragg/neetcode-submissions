class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1]++;
        for(int i = digits.length - 1; i >= 0; i--){
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        int[] result = new int[digits.length + (carry == 0 ? 0 : 1)];
        int i = 0;
        if(carry != 0){
            result[i] = carry;
            i++;
        }

        while(i < result.length){
            result[i] = digits[i - (carry == 0 ? 0 : 1)];
            i++;
        }

        return result;
    }
}
