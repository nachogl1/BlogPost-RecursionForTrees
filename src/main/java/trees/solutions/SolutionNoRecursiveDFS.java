package trees.solutions;

import trees.model.Node;
import trees.utils.Console;

import java.util.Stack;

public class SolutionNoRecursiveDFS implements Solution {
    private final Console console;

    public SolutionNoRecursiveDFS(Console console) {
        this.console = console;
    }

    @Override
    public boolean search(Node tree, String searchTerm) {
        return recursiveSearch(tree, searchTerm);
    }

    private boolean recursiveSearch(Node node, String searchTerm) {
        if(node == null) return false;

        Stack<Node> stack = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()) {
            node = stack.pop();

            console.print(node.getValue());

            if (searchTerm.equals(node.getValue())) return true;
            if (node.getRight() != null) stack.add(node.getRight());
            if (node.getLeft() != null) stack.add(node.getLeft());
        }
        return false;

    }
}
