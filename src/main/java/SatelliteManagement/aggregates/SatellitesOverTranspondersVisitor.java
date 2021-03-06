/**
 * 
 */
package SatelliteManagement.aggregates;

import SatelliteManagement.tree.*;
import SatelliteManagement.visitor.BaseVisitor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A Visitor that aggregates satellites over transponders
 *
 * @author Lukas Benner
 * @version 1.0
 */
public class SatellitesOverTranspondersVisitor extends BaseVisitor {

	HashMap<String, Satellite> satellites = new HashMap<>();

	@Override
	public Node visitSatellite(Satellite ctx) {
		Satellite satellite = new Satellite(ctx);
		satellite.clearChildren();
		for (Node child : ctx.getChildren()){
			if (child instanceof Transponder){
				child.clearChildren();
				satellite.addChild(child);
			}
		}
		satellites.put(satellite.getName(), satellite);
		return null;
	}

	@Override
	public Node visitRoot(Root ctx) {
		for(Node child : ctx.getChildren()){
			child.accept(this);
		}
		Root rootNode = new Root();
		rootNode.setChildren(new ArrayList<>(satellites.values()));
		return rootNode;
	}

}
