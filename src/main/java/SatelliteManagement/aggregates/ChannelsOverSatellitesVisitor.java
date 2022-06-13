package SatelliteManagement.aggregates;

import SatelliteManagement.tree.*;
import SatelliteManagement.visitor.BaseVisitor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A Visitor that aggregates channels over satellites
 *
 * @author Lea Soffel
 * @version 1.0
 */
public class ChannelsOverSatellitesVisitor extends BaseVisitor {

    HashMap<String, Channel> channels = new HashMap<>();
    Satellite currentSatellite = null;

    @Override
    public Node visitChannel(Channel ctx) {
        if(!channels.containsKey(ctx.getName())){
            Channel channel = new Channel(ctx.getName(), ctx.getSid());
            channel.addChild(currentSatellite);
            channels.put(ctx.getName(), channel);
        }
        else{
            Channel channel = channels.get(ctx.getName());
            channel.addChild(currentSatellite);
            channels.put(ctx.getName(), channel);
        }
        return null;
    }

    @Override
    public Node visitSatellite(Satellite ctx) {
        currentSatellite = new Satellite(ctx);
        currentSatellite.clearChildren();
        for(Node child : ctx.getChildren()){
            child.accept(this);
        }
        return null;
    }

    @Override
    public Node visitTransponder(Transponder ctx) {
        for(Node child : ctx.getChildren()){
            child.accept(this);
        }
        return null;
    }

    @Override
    public Node visitRoot(Root ctx) {
        for(Node child : ctx.getChildren()){
            child.accept(this);
        }
        Root rootNode = new Root();
        rootNode.setChildren(new ArrayList<>(channels.values()));
        return rootNode;
    }
}
