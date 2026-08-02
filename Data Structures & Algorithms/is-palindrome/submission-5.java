    class Solution {
        public boolean isPalindrome(String s) {
            for(int i = 0, j = s.length() - 1; i < j; i++, j--){
                Character c = lower(s, i);
                Character d = lower(s, i);

                while(i < j && !isAlphaNumeric(s, i)) i++;
                while(i < j && !isAlphaNumeric(s, j)) j--;

                if(i >= j) break;

                if(lower(s, i) != lower(s, j)){
                    return false;
                }
            }

            return true;
        }

        private boolean isAlphaNumeric(String s, int i){
            Character c = lower(s, i);
            return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
        }

        private Character lower(String s, int i){
            return Character.toLowerCase(s.charAt(i));
        }
    }
