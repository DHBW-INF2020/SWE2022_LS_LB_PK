package output;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import tree.*;
import visitor.BaseVisitor;

import java.util.ArrayList;

public class JsonOutput_Visitor implements iOutput_Visitor {

    private StringBuilder builder = new StringBuilder();

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
        addAttribute("channel", normalizeJSON(ctx.getName()), true);
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

    @Override
    public String getParsedData() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(builder.toString());
        return gson.toJson(je);
    }

    /**
     * Escape forbidden characters for json format
     * @param input
     * @return
     */
    private String normalizeJSON(String input){
        return input.replaceAll("\"", "\\\\\"")
                .replaceAll("\t", "\\t")
                .replaceAll("\b", "\\\\\b");
    }

}