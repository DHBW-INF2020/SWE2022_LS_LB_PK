package SatelliteManagement.tree;

import SatelliteManagement.visitor.iVisitor;

import java.util.ArrayList;

/**
 * @author Lukas
 */
public abstract class Node {

    private ArrayList<Node> _children;
    private NodeType _childrenType;

    public Node(){
        _children = new ArrayList<>();
    }

    /**
     *
     * @param visitor
     * @return Node
     */
    public abstract Node accept(iVisitor visitor);

	/**
	 * @return the _childrenType
	 */
	public NodeType getChildrenType() {
		return _childrenType;
	}

	/**
	 * @return the _children
	 */
	public ArrayList<Node> getChildren() {
		return _children;
	}

	public void setChildren(ArrayList<Node> children){
		this._children = children;
		this._childrenType = children.get(0).getType();
	}

	public void clearChildren(){
		this._children = new ArrayList<>();
		this._childrenType = null;
	}

	public void addChild(Node child){
		this._children.add(child);
		this._childrenType = child.getType();
	}

	public abstract NodeType getType();
}
