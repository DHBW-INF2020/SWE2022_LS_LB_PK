package visitor;

import tree.*;

public class BaseVisitor implements iVisitor {
    @Override
    public Node visitChannel(Channel ctx) {
        return null;
    }

    @Override
    public Node visitSatellite(Satellite ctx) {
        return null;
    }

    @Override
    public Node visitTransponder(Transponder ctx) {
        return null;
    }

    @Override
    public Node visitRoot(Root ctx) {
        return null;
    }
}
