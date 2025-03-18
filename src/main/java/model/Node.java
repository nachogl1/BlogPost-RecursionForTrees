package model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Node {

    private String value;
    private Node left;
    private Node right;


}
