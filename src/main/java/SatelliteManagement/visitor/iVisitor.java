package SatelliteManagement.visitor;

import SatelliteManagement.tree.*;

/**
 * Interface for Visitor Pattern with the specific visit methods for all type of nodes
 * @author Lukas Benner
 * @version 1.0
 */
public interface iVisitor {
	/**
	 * Visit method for node type Channel
	 * @param ctx (Channel to visit)
	 * @return Node
	 */
    Node visitChannel(Channel ctx);
	/**
	 * Visit method for node type Satellite
	 * @param ctx (Satellite to visit)
	 * @return Node
	 */
    Node visitSatellite(Satellite ctx);
	/**
	 * Visit method for node type Transponder
	 * @param ctx (Transponder to visit)
	 * @return Node
	 */
    Node visitTransponder(Transponder ctx);
	/**
	 * Visit method for node type Root
	 * @param ctx (Root to visit)
	 * @return Node
	 */
    Node visitRoot(Root ctx);
}
