class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            if(Set.of("+", "-", "*", "/").contains(tokens[i])){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(operate(first, second, tokens[i]));
                continue;
            }

            stack.push(Integer.parseInt(tokens[i]));
        }

        return stack.pop();

    }

    private int operate(int first, int second, String operation){
        return switch(operation){
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> 0;
        };
    }
}
