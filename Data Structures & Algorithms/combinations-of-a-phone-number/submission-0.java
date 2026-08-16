class Solution {
    Map<Character, String> map = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0) return result;

        StringBuilder sb = new StringBuilder();

        solve(result, sb, digits, 0);
        return result;
    }

    private void solve(List<String> result, StringBuilder sb, String digits, int idx){
        if(idx == digits.length()){
            result.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(idx));
        for(int i = 0; i < letters.length(); i++){
            sb.append(letters.charAt(i));
            solve(result, sb, digits, idx + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
