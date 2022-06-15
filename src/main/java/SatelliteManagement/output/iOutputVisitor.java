package SatelliteManagement.output;

import SatelliteManagement.visitor.iVisitor;

/**
 * An abstract class that extends iVisitor to centralize redundant methods of output visitors.
 *
 * @author Lea Soffel
 * @version 1.0
 */
public interface iOutputVisitor extends iVisitor {

	/**
	 * @return A string with the parsed data
	 */
	String getParsedData();
}
