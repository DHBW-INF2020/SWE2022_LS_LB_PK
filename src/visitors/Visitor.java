package visitors;

import tree.Channel;
import tree.Node;

/**
 *
 * @author Lukas
 */
public interface Visitor<T> {
    T visitChannel(Channel ctx);
    T visitSatellite(Satellite ctx);
    T visitTransponder(Transponder ctx);
}
