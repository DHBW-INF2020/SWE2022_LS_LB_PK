/**
 * 
 */
package output;

import java.util.ArrayList;

import tree.Node;
import tree.NodeType;

/**
 * @author Lea
 *
 */
public interface IOutput_Visitor {
	
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

}
