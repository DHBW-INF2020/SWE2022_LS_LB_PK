package tree;

import visitors.IVisitor;

import java.util.ArrayList;

/**
 * @author Lukas
 */
public abstract class Node {

    ArrayList<Node> children;
    String childrenType;

    public Node(){
        children = new ArrayList<>();
    }

    /**
     *
     * @param visitor
     * @return Node
     */
    public abstract Node accept(IVisitor<Node> visitor);
}
