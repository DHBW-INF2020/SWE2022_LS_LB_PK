package SatelliteManagement.tree;

import SatelliteManagement.visitor.iVisitor;

import java.util.ArrayList;

/**
 * Basic class for all nodes of tree
 * @author Lukas Benner
 * @version 1.0
 */
public abstract class Node {

	// List with all child nodes
    private ArrayList<Node> _children;
    // variable to store type of child nodes
    private NodeType _childrenType;

    public Node(){
        _children = new ArrayList<>();
    }

    /**
     * Accept method
     * @param visitor
     * @return Node
     */
    public abstract Node accept(iVisitor visitor);

	/**
	 * Getter for childrenType
	 * @return the _childrenType
	 */
	public NodeType getChildrenType() {
		return _childrenType;
	}

	/**
	 * Getter for array of children
	 * @return the _children
	 */
	public ArrayList<Node> getChildren() {
		return _children;
	}

	/**
	 * Set array of child nodes
	 * @param children
	 */
	public void setChildren(ArrayList<Node> children){
		this._children = children;
		this._childrenType = children.get(0).getType();
	}

	/**
	 * Clear array of child nodes
	 */
	public void clearChildren(){
		this._children = new ArrayList<>();
		this._childrenType = null;
	}

	/**
	 * Add child to array of child nodes
	 * @param child
	 */
	public void addChild(Node child){
		this._children.add(child);
		this._childrenType = child.getType();
	}

	/**
	 * Getter for the Type of node
	 * @return nodeType
	 */
	public abstract NodeType getType();
}
