class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int found = 0;
        for(int[] triplet : triplets){
            int mask = 0;
            for(int i = 0; i < 3; i++){
                if(triplet[i] == target[i]){
                    mask |= (1 << i);
                } else if(triplet[i] > target[i]){
                    mask = 0;
                    break;
                }
            }

            found |= mask;
            if(found == 7) break;
        }

        return found == 7;
    }
}