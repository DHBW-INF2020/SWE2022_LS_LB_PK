/**
 * 
 */
package tree;

import visitor.IVisitor;

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
	 * Copy Constructor for Satellite
	 * @param origin
	 */
	public Satellite(Satellite origin){
		this._name = origin._name;
		this._orbital = origin._orbital;
		this.setChildren(origin.getChildren());
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
		return visitor.visitSatellite(this);
	}

	@Override
	public NodeType getType() {
		return NodeType.SATTELITE;
	}


}
