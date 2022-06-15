package SatelliteManagement.output;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import SatelliteManagement.tree.*;

import java.util.ArrayList;

/**
 * A visitor that creates a json string from a given tree
 *
 * @author Lukas Benner
 * @version 1.0
 */
public class JsonOutputVisitor implements iOutputVisitor {

    private final StringBuilder builder = new StringBuilder();

    @Override
    public Node visitTransponder(Transponder ctx) {
        builder.append("{");
        addAttribute("pol", ctx.getPolarisation(), true);
        addAttribute("freq", String.valueOf(ctx.getFrequency()), false);
        addAttribute("sym", ctx.getSymmetry(), false);
        addChildren(ctx.getChildren());
        builder.append("}");
        return null;
    }

    @Override
    public Node visitSatellite(Satellite ctx) {
        builder.append("{");
        addAttribute("sat", ctx.getName(), true);
        addAttribute("orbital", ctx.getOrbital(), false);
        addChildren(ctx.getChildren());
        builder.append("}");

        return null;
    }

    @Override
    public Node visitChannel(Channel ctx) {
        builder.append("{");
        addAttribute("channel", normalizeJSON(ctx.getName()), true);
        addChildren(ctx.getChildren());
        builder.append("}");

        return null;
    }


    @Override
    public Node visitRoot(Root ctx) {
        ArrayList<Node> children = ctx.getChildren();
        builder.append("[");
        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i);
            child.accept(this);
            if(i < children.size()-1) builder.append(",");
        }
        builder.append("]");
        return null;
    }

    @Override
    public String getParsedData() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(builder.toString());
        return gson.toJson(je);
    }

	private void addAttribute(String name, String value, Boolean first){
        if(first) {
            builder.append("\"").append(name).append("\": \"").append(value).append("\"");
        }
        else{
            builder.append(",\"").append(name).append("\": \"").append(value).append("\"");
        }
    }

	private void addChildren(ArrayList<Node> children) {
		if(children.size() > 0){
            builder.append(",");
            builder.append(children.get(0).getCollectionName());
            builder.append(":");
            builder.append("[");
            for (int i = 0; i < children.size(); i++) {
                Node child = children.get(i);
                child.accept(this);
                if(i < children.size()-1) builder.append(",");
            }
            builder.append("]");
        }
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
