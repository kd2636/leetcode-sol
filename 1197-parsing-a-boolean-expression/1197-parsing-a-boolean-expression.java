class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> operator = new Stack<>();


        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '!' || c == '|' || c == '&') {
                operator.push(c);
            } else if (c == ')') {
                List<Character> expPartial = new ArrayList<>();
                while (stack.peek() != '(') {
                    expPartial.add(stack.pop());
                }
                Character op = operator.pop();
                Character res = solve(op, expPartial);
                stack.pop();
                stack.push(res);
            } else {
                stack.push(c);
            }
            
        }

        char ans = stack.pop();
        return ans == 't' ? true : false;
    }

    private char solve(char operator, List<Character> expression) {
        if (operator == '!') {
            return solveNot(expression);
        } else if (operator == '|') {
            return solveOr(expression);
        } else {
            return solveAnd(expression);
        }
    } 

    private char solveNot(List<Character> expression) {
        if (expression.get(0) == 't') {
            return 'f';
        }
        return 't';
    }

    private char solveOr(List<Character> expression) {
        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i) == 't') {
                return 't';
            }
        }
        return 'f';
    }

    private char solveAnd(List<Character> expression) {
        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i) == 'f') {
                return 'f';
            }
        }
        return 't';
    }
}