/**
 * 
 */
package SatelliteManagement.tree;

import SatelliteManagement.visitor.iVisitor;

/**
 * 
 * @author Lea
 *
 */
public class Satellite extends Node{

	private final String _name;
	private final String _orbital;


	/**
	 * Constructor for Satellite
	 *
	 * @param name
	 * @param orbital
	 */
	public Satellite(String name, String orbital) {
		_name = name;
		_orbital = orbital;
	}

	/**
	 * Copy Constructor for Satellite
	 *
	 * @param other
	 */
	public Satellite(Satellite other){
		this._name = other._name;
		this._orbital = other._orbital;
		this.setChildren(other.getChildren());
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
	public Node accept(iVisitor visitor) {
		return visitor.visitSatellite(this);
	}

	@Override
	public NodeType getType() {
		return NodeType.SATTELITE;
	}


}
