/**
 * 
 */
package SatelliteManagement.output;

import java.util.ArrayList;

import SatelliteManagement.tree.Node;
import SatelliteManagement.tree.NodeType;
import SatelliteManagement.visitor.iVisitor;

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
