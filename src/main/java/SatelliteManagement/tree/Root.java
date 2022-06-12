package SatelliteManagement.tree;

import SatelliteManagement.visitor.iVisitor;

public class Root extends Node{
    @Override
    public Node accept(iVisitor visitor) {
        return visitor.visitRoot(this);
    }

    @Override
    public NodeType getType() {
        return NodeType.ROOT;
    }
}
