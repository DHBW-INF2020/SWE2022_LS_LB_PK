package visitors;

import tree.Channel;
import tree.Root;
import tree.Satellite;
import tree.Transponder;

public class ChannelsOverSatellites_Visitor implements IVisitor {
    @Override
    public Object visitChannel(Channel ctx) {
        return null;
    }

    @Override
    public Object visitSatellite(Satellite ctx) {
        return null;
    }

    @Override
    public Object visitTransponder(Transponder ctx) {
        return null;
    }

    @Override
    public Object visitRoot(Root ctx) {
        return null;
    }
}
