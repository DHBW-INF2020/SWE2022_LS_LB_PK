package tree;

import visitor.IVisitor;

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
		return visitor.visitTransponder(this);
	}

	@Override
	public NodeType getType() {
		return NodeType.TRANSPONDER;
	}


}
