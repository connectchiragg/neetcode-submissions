class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] curr = new int[3];

        for(int[] triplet : triplets){
            boolean useful = false;
            for(int i = 0; i < 3; i++){
                if(triplet[i] == target[i]){
                    useful = true;
                } else if(triplet[i] > target[i]){
                    useful = false;
                    break;
                }
            }

            if(useful){
                merge(curr, triplet);
            }
        }

        for(int i = 0; i < 3; i++){
            if(curr[i] != target[i]) return false;
        }

        return true;
    }

    private void merge(int[] curr, int[] triplet){
        for(int i = 0; i < 3; i++){
            curr[i] = Math.max(curr[i], triplet[i]);
        }
    }
}