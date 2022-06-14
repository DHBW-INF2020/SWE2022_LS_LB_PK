/**
 * 
 */
package SatelliteManagement.tree;

import SatelliteManagement.visitor.iVisitor;

/**
 * Class to represent a Satellite in tree
 * @author Lea Soffel
 * @version 1.0
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
	 * Getter for name of Satellite
	 * @return _name
	 */
	public String getName() {
		return _name;
	}


	/**
	 * Getter for orbital of Satellite
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
