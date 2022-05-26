package visitors;

import tree.*;

import java.util.HashMap;
import java.util.TooManyListenersException;

public class ChannelsOverSatellites_Visitor implements IVisitor {

    HashMap<String, Channel> channels = new HashMap<>();

    @Override
    public Object visitChannel(Channel ctx) {
        if(!channels.containsKey(ctx.getName())){
            channels.put(ctx.getName(), ctx);
        }
        return null;
    }

    @Override
    public Object visitSatellite(Satellite ctx) {
        return null;
    }

    @Override
    public Object visitTransponder(Transponder ctx) {
        for(Node child : ctx.getChildren()){
            if(child instanceof Channel) {
            }

        }
        return null;
    }

    @Override
    public Object visitRoot(Root ctx) {
        for(Node child : ctx.getChildren()){
            child.accept(this);
        }
        Root rootNode = new Root();
        return rootNode;
    }
}
