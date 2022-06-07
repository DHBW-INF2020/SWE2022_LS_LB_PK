package output;


import java.util.ArrayList;

import tree.Channel;
import tree.Node;
import tree.NodeType;
import tree.Root;
import tree.Satellite;
import tree.Transponder;
import visitor.BaseVisitor;

public class XmlOutput_Visitor extends BaseVisitor<Node> implements IOutput_Visitor {

    public StringBuilder builder = new StringBuilder();

    @Override
    public Node visitTransponder(Transponder ctx) {
        builder.append("<transponder ");
        addAttribute("pol", ctx.getPolarisation(), true);
        addAttribute("freq", String.valueOf(ctx.getFrequency()), false);
        addAttribute("sym", ctx.getSymmetry(), false);
        builder.append(">");
        addChildren(ctx.getChildren(), ctx.getChildrenType());
        builder.append("</transponder>");
        return null;
    }

    @Override
    public Node visitSatellite(Satellite ctx) {
        builder.append("<sat ");
        addAttribute("sat", ctx.getName(), true);
        addAttribute("orbital", ctx.getOrbital(), false);
        builder.append(">");
        addChildren(ctx.getChildren(), ctx.getChildrenType());
        builder.append("</sat>");

        return null;
    }

    @Override
    public Node visitChannel(Channel ctx) {
        builder.append("<channel ");
        addAttribute("name", ctx.getName(), true);
        addChildren(ctx.getChildren(), ctx.getChildrenType());
        builder.append("</channel>");

        return null;
    }


    @Override
    public Node visitRoot(Root ctx) {
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        addChildren(ctx.getChildren(), ctx.getType());
        
        return null;
    }



	@Override
	public void addAttribute(String name, String value, Boolean first) {
		if(first) {
			builder.append(name + "=\"" + value + "\"");
        }
        else{
            builder.append(" " + name + "=\"" + value + "\"");
        }
		
	}

	@Override
	public void addChildren(ArrayList<Node> children, NodeType childrenType) {
		if(children.size() > 0){
        	String endtag = "";
            switch (childrenType){
                case TRANSPONDER -> { builder.append("<transponders>"); endtag = "</transponders>";}
                case SATTELITE -> { builder.append("<satellites>"); endtag = "</satellites>"; }
                case CHANNEL -> { builder.append("<channels>"); endtag = "</channels>"; }
            }
            for (int i = 0; i < children.size(); i++) {
                Node child = children.get(i);
                child.accept(this);
            }
            builder.append(endtag);
        }
		
	}
}
