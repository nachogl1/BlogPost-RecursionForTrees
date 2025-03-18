package model;

public class Node {

    private String value;
    private Node left;
    private Node right;

    public Node(Node left, Node right, String value) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(Node left, String value) {
        this.value = value;
        this.left = left;
    }

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
