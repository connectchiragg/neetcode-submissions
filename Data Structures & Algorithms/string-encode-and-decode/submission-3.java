class Solution {
    public String encode(List<String> strs) {
        String joinStr = "";
        String counts = "";

        for(String s : strs){
            joinStr += s;
            counts += s.length() + "-";
        }

        return strs.size() + "-" + counts + joinStr;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        String currStr = "";
        List<Integer> lengths = new ArrayList<>();
        Integer start = 0;
        Integer numStrs = null;
        Integer currIdx = 0;

        while(str.charAt(start) != '-'){
            currStr += str.charAt(start);
            start++;
        }

        numStrs = Integer.parseInt(currStr);
        // start is right at the firs hyphen (-), we wanna get it       started at lengths
        start++;
        currStr = "";

        while(lengths.size() < numStrs){
            if(str.charAt(start) == '-'){
                lengths.add(Integer.parseInt(currStr));
                currStr = "";
            } else {
                currStr += str.charAt(start);
            }

            start++;
        }

        while(start < str.length()){
            while(result.size() < numStrs && currStr.length() == lengths.get(currIdx)){
                result.add(currStr);
                currStr = "";
                currIdx++;
            }

            currStr += str.charAt(start);
            start++;
        }

        while(result.size() < numStrs){
            result.add(currStr);
            currStr = "";
        }

        return result;
    }
}
