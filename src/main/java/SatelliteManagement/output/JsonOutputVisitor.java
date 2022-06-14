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
    private final FormatDictionary dictionary;

    public JsonOutputVisitor(FormatDictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public Node visitTransponder(Transponder ctx) {
        builder.append("{");
        builder.append(dictionary.getFirstAttribute("pol", ctx.getPolarisation(), "json"));
        builder.append(dictionary.getAttribute("freq", ctx.getFrequency(), "json"));
        builder.append(dictionary.getAttribute("sym", ctx.getSymmetry(), "json"));
        addChildren(ctx.getChildren());
        builder.append("}");
        return null;
    }

    @Override
    public Node visitSatellite(Satellite ctx) {
        builder.append("{");
        builder.append(dictionary.getFirstAttribute("sat", ctx.getName(), "json"));
        builder.append(dictionary.getAttribute("orbital", ctx.getOrbital(), "json"));
        addChildren(ctx.getChildren());
        builder.append("}");

        return null;
    }

    @Override
    public Node visitChannel(Channel ctx) {
        builder.append("{");
        var name = dictionary.normalizeFormat(ctx.getName(), "json");
        builder.append(dictionary.getFirstAttribute("name", name, "json"));
        addChildren(ctx.getChildren());
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

	public void addChildren(ArrayList<Node> children) {
		if(children.size() > 0){
            builder.append(",");
            builder.append(dictionary.getArrayStartTag("json", children.get(0).getClass()));
            for (int i = 0; i < children.size(); i++) {
                Node child = children.get(i);
                child.accept(this);
                if(i < children.size()-1) builder.append(",");
            }
            builder.append(dictionary.getArrayEndTag("json", children.get(0).getClass()));
        }
	}

    @Override
    public String getParsedData() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(builder.toString());
        return gson.toJson(je);
    }
}