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
	
	public Transponder(char polarisation, int frequency, int symmetry) {
		super();
		_polarisation = polarisation;
		_frequency = frequency;
		_symmetry = symmetry;
	}

	/**
	 * @return the _polarisation
	 */
	public char get_polarisation() {
		return _polarisation;
	}


	/**
	 * @return the _frequency
	 */
	public int get_frequency() {
		return _frequency;
	}


	/**
	 * @return the _symmetry
	 */
	public int get_symmetry() {
		return _symmetry;
	}

	@Override
	public Node accept(Visitor<Node> visitor) {
		return null;
	}
}
