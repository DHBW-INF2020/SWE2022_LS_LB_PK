/**
 * 
 */
package SatelliteManagement.output;

import java.util.ArrayList;

import SatelliteManagement.tree.Node;
import SatelliteManagement.tree.NodeType;
import SatelliteManagement.visitor.iVisitor;

/**
 * An abstract class that extends iVisitor to centralize redundant methods of output visitors.
 *
 * @author Lea
 * @version 1.0
 */
public interface iOutputVisitor extends iVisitor {
	
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


	/**
	 * @return A string with the parsed data
	 */
	String getParsedData();

}
