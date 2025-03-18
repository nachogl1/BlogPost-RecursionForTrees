package solutions;

import model.Node;
import utils.Console;

import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionBFS implements Solution {
    private final Console console;

    public SolutionBFS(Console console) {
        this.console = console;
    }

    @Override
    public boolean search(Node tree, String searchTerm) {
        return recursiveSearch(tree, searchTerm);
    }

    private boolean recursiveSearch(Node node, String searchTerm) {
        //Due to the nature of BFS (Queues) using recursion (STACK) is not the best option
        if(node == null) return false;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();

            console.print(node.getValue());

            if (searchTerm.equals(node.getValue())) return true;
            if (node.getLeft() != null) queue.add(node.getLeft());
            if (node.getRight() != null) queue.add(node.getRight());
        }
        return false;

    }
}
