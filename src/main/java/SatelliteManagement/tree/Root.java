package SatelliteManagement.tree;

import SatelliteManagement.visitor.iVisitor;
/**
 * Class reprents the root of the tree
 * @author Lukas Benner
 * @version 1.0
 */
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
