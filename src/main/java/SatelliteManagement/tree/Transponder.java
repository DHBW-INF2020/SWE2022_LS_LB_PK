package SatelliteManagement.tree;

import SatelliteManagement.visitor.iVisitor;

/**
 * Class to represent a Transponder in tree
 * @author Lea
 *
 */
public class Transponder extends Node {

	private final String _polarisation;
	private final String _frequency;
	private final String _symmetry;
	
	/**
	 * Constructor for Transponder
	 * @param polarisation
	 * @param frequency
	 * @param symmetry
	 */
	public Transponder(String polarisation, String frequency, String symmetry) {
		super();
		_polarisation = polarisation;
		_frequency = frequency;
		_symmetry = symmetry;
	}

	/**
	 * Copy Constructor for Transponder
	 * @param origin
	 */
	public Transponder(Transponder origin){
		this._frequency = origin._frequency;
		this._polarisation = origin._polarisation;
		this._symmetry = origin._symmetry;
		this.setChildren(origin.getChildren());
	}

	/**
	 * Getter for polarisation of Transponder
	 * @return the _polarisation
	 */
	public String getPolarisation() {
		return _polarisation;
	}


	/**
	 * Getter for frequency of Transponder
	 * @return the _frequency
	 */
	public String getFrequency() {
		return _frequency;
	}


	/**
	 * Getter for symmetry of Transponder
	 * @return the _symmetry
	 */
	public String getSymmetry() {
		return _symmetry;
	}

	@Override
	public Node accept(iVisitor visitor) {
		return visitor.visitTransponder(this);
	}

	@Override
	public NodeType getType() {
		return NodeType.TRANSPONDER;
	}


}
