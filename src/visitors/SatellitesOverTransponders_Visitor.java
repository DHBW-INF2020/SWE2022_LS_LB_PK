/**
 * 
 */
package visitors;

import tree.Channel;
import tree.Root;
import tree.Satellite;
import tree.Transponder;

/**
 * @author Lea
 *
 */
public class SatellitesOverTransponders_Visitor implements IVisitor{
	
	private Root _rootNode;
	
	@Override
	public Object visitChannel(Channel ctx) {
		return ctx.accept(this);
	}

	@Override
	public Object visitSatellite(Satellite ctx) {
		return ctx.accept(this);
	}

	@Override
	public Object visitTransponder(Transponder ctx) {
		return ctx.accept(this);
	}

	@Override
	public Object visitRoot(Root ctx) {
		_rootNode = new Root();
		
		
		return ctx.accept(this);
	}

}
