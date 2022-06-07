/**
 * 
 */
package output;

import java.util.ArrayList;

import tree.Node;
import tree.NodeType;
import visitor.iVisitor;

/**
 * @author Lea
 *
 */
public interface iOutput_Visitor extends iVisitor {
	
	/**
	 * method to add an attribute and its value
	 * @param name
	 * @param value
	 */
	void addAttribute(String name, String value, Boolean first);
	
	/**
	 * method to add children array
	 * @param children
	 * @param childrenType
	 */
	void addChildren(ArrayList<Node> children, NodeType childrenType);


	String getParsedData();

}
