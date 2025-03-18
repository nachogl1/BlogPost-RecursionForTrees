package solutions;

import model.Node;
import utils.Console;

public class SolutionPreOrder implements Solution {
    private final Console console;

    public SolutionPreOrder(Console console) {
        this.console = console;
    }

    @Override
    public boolean search(Node tree, String searchTerm) {
        return recursiveSearch(tree, searchTerm);
    }

    private boolean recursiveSearch(Node node, String searchTerm) {
        if (node != null) {//If node is null -> return false nothing to search for

            boolean result = false;
            console.print(node.getValue());

            if (searchTerm.equals(node.getValue())) {
                return true; //If found, return true and STOP the recursion
            }

            if (node.getLeft() != null) { //As long as I do not have the non-visited far left node, keep going
                result = recursiveSearch(node.getLeft(), searchTerm);
            }

            return result || recursiveSearch(node.getRight(), searchTerm); // result is found OR try right side now
        }

        return false; //No luck today kid
    }
}
