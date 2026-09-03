class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        int[] map = new int[1001];

        for(int num : hand){
            map[num]++;
        }

        Arrays.sort(hand);

        for(int num : hand){
            if(map[num] == 0) continue;

            for(int i = num; i < num + groupSize; i++){
                if(i > map.length || map[i] == 0){
                    return false;
                }

                map[i]--;
            }
        }

        return true;
    }
}