package visitors;

import tree.Channel;
import tree.Root;
import tree.Satellite;
import tree.Transponder;

/**
 *
 * @author Lukas
 */
public interface IVisitor<T> {
    T visitChannel(Channel ctx);
    T visitSatellite(Satellite ctx);
    T visitTransponder(Transponder ctx);
    T visitRoot(Root ctx);
}
