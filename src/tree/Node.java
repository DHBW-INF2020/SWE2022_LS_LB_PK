package tree;

import java.util.ArrayList;

/**
 * @author Lukas
 */
public abstract class Node {

    ArrayList<Node> children;
    String childrenType;

    /**
     *
     * @param visitor
     * @return Node
     */
    public abstract Node accept(Object visitor);
}
