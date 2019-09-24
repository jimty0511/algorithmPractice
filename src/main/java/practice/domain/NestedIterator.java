package practice.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// 341. Flatten Nested List Iterator
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger nestedInteger = stack.peek();
            if (nestedInteger.isInteger()) {
                return true;
            }
            stack.pop();
            for (int i = nestedInteger.getList().size() - 1; i >= 0; i--) {
                stack.push(nestedInteger.getList().get(i));
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }
}
