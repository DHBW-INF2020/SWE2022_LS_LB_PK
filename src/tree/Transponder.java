package tree;

import visitors.Visitor;

/**
 * 
 * @author Lea
 *
 */
public class Transponder extends Node {

	private char _polarisation;
	private int _frequency;
	private int _symmetry;
	
	/**
	 * Constructor for Transponder
	 * @param polarisation
	 * @param frequency
	 * @param symmetry
	 */
	public Transponder(char polarisation, int frequency, int symmetry) {
		super();
		_polarisation = polarisation;
		_frequency = frequency;
		_symmetry = symmetry;
	}

	/**
	 * @return the _polarisation
	 */
	public char getPolarisation() {
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
	public int getSymmetry() {
		return _symmetry;
	}

	@Override
	public Node accept(Visitor<Node> visitor) {
		return null;
	}
}
