package tree;

import visitors.IVisitor;

public class Root extends Node{
    @Override
    public Node accept(IVisitor<Node> visitor) {
        return visitor.visitRoot(this);
    }

    @Override
    public NodeType getType() {
        return NodeType.ROOT;
    }
}
