package solutions;

import model.Node;

public class Utils {
    public final static Node TREE = Node.builder()
            .left(Node.builder()
                    .left(Node.builder()
                            .right(Node.builder().value("8").build())
                            .value("4")
                            .build())
                    .right(Node.builder()
                            .value("5")
                            .build())
                    .value("2").build())
            .right(Node.builder()
                    .left(Node.builder()
                            .left(Node.builder().value("9").build())
                            .value("6")
                            .build())
                    .right(Node.builder()
                            .value("7")
                            .build())
                    .value("3").build())
            .value("1").build();

}
