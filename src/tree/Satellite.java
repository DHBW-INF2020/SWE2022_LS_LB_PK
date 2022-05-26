/**
 * 
 */
package tree;

import visitors.IVisitor;

/**
 * 
 * @author Lea
 *
 */
public class Satellite extends Node{

private String _name;
private String _orbital;

/**
 * Constructor for Satellite
 * @param name
 * @param orbital
 */
public Satellite(String name, String orbital) {
	_name = name;
	_orbital = orbital;
}


/**
 * @return _name
 */
public String getName() {
	return _name;
}


/**
 * @return _orbital
 */
public String getOrbital() {
	return _orbital;
}

	@Override
	public Node accept(IVisitor<Node> visitor) {
		return null;
	}
}
