package SatelliteManagement.output;


import java.io.*;
import java.util.ArrayList;

import SatelliteManagement.tree.Channel;
import SatelliteManagement.tree.Node;
import SatelliteManagement.tree.Root;
import SatelliteManagement.tree.Satellite;
import SatelliteManagement.tree.Transponder;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * A visitor that creates a xml string from a given tree
 *
 * @author Lea Soffel
 * @version 1.0
 */
public class XmlOutputVisitor implements iOutputVisitor {

    private final StringBuilder builder = new StringBuilder();

    @Override
    public Node visitTransponder(Transponder ctx) {
        builder.append("<transponder ");
        addAttribute("pol", ctx.getPolarisation(), true);
        addAttribute("freq", String.valueOf(ctx.getFrequency()), false);
        addAttribute("sym", ctx.getSymmetry(), false);
        builder.append(">");
        addChildren(ctx.getChildren());
        builder.append("</transponder>");
        return null;
    }

    @Override
    public Node visitSatellite(Satellite ctx) {
        builder.append("<sat ");
        addAttribute("name", ctx.getName(), true);
        addAttribute("orbital", ctx.getOrbital(), false);
        builder.append(">");
        addChildren(ctx.getChildren());
        builder.append("</sat>");

        return null;
    }

    @Override
    public Node visitChannel(Channel ctx) {
        builder.append("<channel ");
        addAttribute("name", normalizeXML(ctx.getName()), true);
        builder.append(">");
        addChildren(ctx.getChildren());
        builder.append("</channel>");

        return null;
    }

    @Override
    public Node visitRoot(Root ctx) {
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        addChildren(ctx.getChildren());
        return null;
    }

    @Override
    public String getParsedData() {
        try {
            Source xmlInput = new StreamSource(new StringReader(builder.toString()));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer(); // An identity transformer
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(xmlInput, xmlOutput);
            return stringWriter.toString();
        }
        catch (TransformerException e){
            throw new RuntimeException(e);
        }
    }

	private void addAttribute(String name, String value, Boolean first) {
		if(first) {
			builder.append(name).append("=\"").append(value).append("\"");
        }
        else{
            builder.append(" ").append(name).append("=\"").append(value).append("\"");
        }

	}

	private void addChildren(ArrayList<Node> children) {
		if(children.size() > 0){
            builder.append("<").append(children.get(0).getCollectionName()).append(">");
            for (int i = 0; i < children.size(); i++) {
                Node child = children.get(i);
                child.accept(this);
            }
            builder.append("</").append(children.get(0).getCollectionName()).append(">");
        }
	}

    /**
     * Escape forbidden characters for XML format
     * @param input is a string that holds unescaped characters
     * @return A string where the special characters are escaped
     */
    private String normalizeXML(String input){
        return input.replaceAll("&", "&amp;")
                .replaceAll("\"", "&quot;")
                .replaceAll("'", "&apos;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;");
    }
}
