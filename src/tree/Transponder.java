package tree;

import visitors.IVisitor;

/**
 * 
 * @author Lea
 *
 */
public class Transponder extends Node {

	private String _polarisation;
	private int _frequency;
	private String _symmetry;
	
	/**
	 * Constructor for Transponder
	 * @param polarisation
	 * @param frequency
	 * @param symmetry
	 */
	public Transponder(String polarisation, int frequency, String symmetry) {
		super();
		_polarisation = polarisation;
		_frequency = frequency;
		_symmetry = symmetry;
	}

	/**
	 * @return the _polarisation
	 */
	public String getPolarisation() {
		return _polarisation;
	}


	/**
	 * @return the _frequency
	 */
	public int getFrequency() {
		return _frequency;
	}


	/**
	 * @return the _symmetry
	 */
	public String getSymmetry() {
		return _symmetry;
	}

	@Override
	public Node accept(IVisitor<Node> visitor) {
		return null;
	}

	@Override
	public NodeType getType() {
		return NodeType.TRANSPONDER;
	}


}
