package output;

import tree.*;
import visitor.BaseVisitor;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class JsonOutput_Visitor extends BaseVisitor<Node> implements IOutput_Visitor{

    public StringBuilder builder = new StringBuilder();

    @Override
    public Node visitTransponder(Transponder ctx) {
        builder.append("{");
        addAttribute("pol", ctx.getPolarisation(), true);
        addAttribute("freq", String.valueOf(ctx.getFrequency()), false);
        addAttribute("sym", ctx.getSymmetry(), false);
        addChildren(ctx.getChildren(), ctx.getChildrenType());
        builder.append("}");
        return null;
    }

    @Override
    public Node visitSatellite(Satellite ctx) {
        builder.append("{");
        addAttribute("sat", ctx.getName(), true);
        addAttribute("orbital", ctx.getOrbital(), false);
        addChildren(ctx.getChildren(), ctx.getChildrenType());
        builder.append("}");

        return null;
    }

    @Override
    public Node visitChannel(Channel ctx) {
        builder.append("{");
        addAttribute("channel", ctx.getName(), true);
        addChildren(ctx.getChildren(), ctx.getChildrenType());
        builder.append("}");

        return null;
    }


    @Override
    public Node visitRoot(Root ctx) {
        builder.append("[");
        ArrayList<Node> children = ctx.getChildren();
        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i);
            child.accept(this);
            if(i < children.size()-1) builder.append(",");

        }
        builder.append("]");
        return null;
    }


    @Override
	public  void addAttribute(String name, String value, Boolean first){
        if(first) {
            builder.append("\"" + name + "\": \"" + value + "\"");
        }
        else{
            builder.append(",\"" + name + "\": \"" + value + "\"");
        }
    }


	@Override
	public void addChildren(ArrayList<Node> children, NodeType childrenType) {
		if(children.size() > 0){
            builder.append(",");
            switch (childrenType){
                case TRANSPONDER -> builder.append("\"transponders\":");
                case SATTELITE -> builder.append("\"satellites\":");
                case CHANNEL -> builder.append("\"channels\":");
            }
            builder.append("[");
            for (int i = 0; i < children.size(); i++) {
                Node child = children.get(i);
                child.accept(this);
                if(i < children.size()-1) builder.append(",");
            }
            builder.append("]");
        }
	}
}
