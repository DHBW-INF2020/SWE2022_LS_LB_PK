package visitor;

import tree.Channel;
import tree.Root;
import tree.Satellite;
import tree.Transponder;

public class BaseVisitor<T> implements IVisitor<T>{
    @Override
    public T visitChannel(Channel ctx) {
        return null;
    }

    @Override
    public T visitSatellite(Satellite ctx) {
        return null;
    }

    @Override
    public T visitTransponder(Transponder ctx) {
        return null;
    }

    @Override
    public T visitRoot(Root ctx) {
        return null;
    }
}
