package output;

import tree.*;
import visitor.BaseVisitor;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class JsonOutput_Visitor extends BaseVisitor<Node> {

    public String jsonString = "";

    @Override
    public Node visitTransponder(Transponder ctx) {
        jsonString += "{";
        addAttribute("pol", ctx.getPolarisation(), true);
        addAttribute("freq", String.valueOf(ctx.getFrequency()), false);
        addAttribute("sym", ctx.getSymmetry(), false);
        addChildren(ctx.getChildren(), ctx.getChildrenType());
        jsonString += "}";
        return null;
    }

    @Override
    public Node visitSatellite(Satellite ctx) {
        jsonString += "{";
        addAttribute("sat", ctx.getName(), true);
        addAttribute("orbital", ctx.getOrbital(), false);
        addChildren(ctx.getChildren(), ctx.getChildrenType());
        jsonString += "}";

        return null;
    }

    @Override
    public Node visitChannel(Channel ctx) {
        jsonString += "{";
        addAttribute("channel", ctx.getName(), true);
        addChildren(ctx.getChildren(), ctx.getChildrenType());
        jsonString += "}";

        return null;
    }


    @Override
    public Node visitRoot(Root ctx) {
        jsonString += "[";
        ArrayList<Node> children = ctx.getChildren();
        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i);
            child.accept(this);
            if(i < children.size()-1) jsonString += ",";

        }
        jsonString += "]";
        return null;
    }

    private void addChildren(ArrayList<Node> children, NodeType childrenType) {
        if(children.size() > 0){
            jsonString += ",";
            switch (childrenType){
                case TRANSPONDER -> jsonString+="\"transponders\":";
                case SATTELITE -> jsonString+="\"satellites\":";
                case CHANNEL -> jsonString+="\"channels\":";
            }
            jsonString += "[";
            for (int i = 0; i < children.size(); i++) {
                Node child = children.get(i);
                child.accept(this);
                if(i < children.size()-1) jsonString += ",";
            }
            jsonString += "]";
        }
    }

    private void addAttribute(String name, String value, Boolean first){
        if(first) {
            jsonString += "\"" + name + "\": \"" + value + "\"";
        }
        else{
            jsonString += ",\"" + name + "\": \"" + value + "\"";
        }
    }
}
