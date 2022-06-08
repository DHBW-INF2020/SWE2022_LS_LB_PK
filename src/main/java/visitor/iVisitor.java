package visitor;

import tree.*;

/**
 *
 * @author Lukas
 */
public interface iVisitor {
    Node visitChannel(Channel ctx);
    Node visitSatellite(Satellite ctx);
    Node visitTransponder(Transponder ctx);
    Node visitRoot(Root ctx);
}
