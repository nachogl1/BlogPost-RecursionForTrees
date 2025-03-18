package solutions;

import model.Node;
import utils.Console;

public class SolutionPostOrder implements Solution {
    private final Console console;

    public SolutionPostOrder(Console console) {
        this.console = console;
    }

    @Override
    public boolean search(Node tree, String searchTerm) {
        return recursiveSearch(tree, searchTerm);
    }

    private boolean recursiveSearch(Node node, String searchTerm) {
        if (node != null) {//If node is null -> return false nothing to search for

            boolean result = false;
            if (node.getLeft() != null) { //As long as I do not have the non-visited far left node, keep going
                result = recursiveSearch(node.getLeft(), searchTerm);
            }

            if (node.getRight() != null) { //As long as I do not have the non-visited far left node, keep going
                result = result || recursiveSearch(node.getRight(), searchTerm);
            }

            console.print(node.getValue());

            if (searchTerm.equals(node.getValue())) {
                result = true; //If found, return true
            }

            return result ;
        }

        return false; //No luck today kid
    }
}
