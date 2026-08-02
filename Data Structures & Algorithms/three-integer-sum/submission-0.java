class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1, k = n - 1; j < k;){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    j++;
                    continue;
                }

                if(k < n - 1 && nums[k] == nums[k + 1]){
                    k--;
                    continue;
                }

                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    result.add(List.of(nums[i], nums[j], nums[k]));
                }
                
                if(sum <= 0){
                    j++;
                }

                if(sum >= 0){
                    k--;
                }
            }
        }

        return result;
    }
}
