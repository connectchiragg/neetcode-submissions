class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for(int num : nums){
            int idx = search(tails, size, num);
            if(idx == size) size++;
            tails[idx] = num;
        }

        return size;
    }

    private int search(int[] tails, int high, int x){
        int result = -1;
        for(int i = high; i > 0; i /= 2){
            while(result + i < high && tails[result + i] < x){
                result += i;
            }
        }

        return result + 1;
    }
}