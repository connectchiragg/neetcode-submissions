class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> arr = new ArrayList<>(Collections.nCopies(n, null));
        int[] result = new int[k];

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        map.forEach((key, v) -> {
            if(arr.get(v - 1) == null){
                arr.set(v - 1, new ArrayList<>(Arrays.asList(key)));
            } else {
                arr.get(v - 1).add(key);
            }
        });

        for(int i = 0, j = n - 1; i < k; j--){
            while(arr.get(j) == null) j--;

            for(int z = 0; z < arr.get(j).size() && i < k; z++){
                result[i] = arr.get(j).get(z);
                i++;
            }
        }

        return result;
    }
}
