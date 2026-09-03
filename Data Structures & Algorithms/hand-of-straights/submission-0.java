class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand);

        for(int num : hand){
            if(map.get(num) == 0) continue;

            for(int i = num; i < num + groupSize; i++){
                Integer count = map.get(i);

                if(count == null || count == 0){
                    return false;
                }

                map.put(i, count - 1);
            }
        }

        return true;
    }
}