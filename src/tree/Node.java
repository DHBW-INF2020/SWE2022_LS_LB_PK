package tree;

import visitors.IVisitor;

import java.util.ArrayList;

/**
 * @author Lukas
 */
public abstract class Node {

    private ArrayList<Node> _children;
    private String _childrenType;

    public Node(){
        _children = new ArrayList<>();
    }

    /**
     *
     * @param visitor
     * @return Node
     */
    public abstract Node accept(IVisitor<Node> visitor);

	/**
	 * @return the _childrenType
	 */
	public String getChildrenType() {
		return _childrenType;
	}

	/**
	 * @return the _children
	 */
	public ArrayList<Node> getChildren() {
		return _children;
	}

}
