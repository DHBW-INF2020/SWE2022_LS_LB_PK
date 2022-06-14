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

    private final FormatDictionary dictionary;

    public XmlOutputVisitor(FormatDictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public Node visitTransponder(Transponder ctx) {
        builder.append("<transponder ");
        builder.append(dictionary.getFirstAttribute("pol", ctx.getPolarisation(), "xml"));
        builder.append(dictionary.getAttribute("freq", ctx.getFrequency(), "xml"));
        builder.append(dictionary.getAttribute("sym", ctx.getSymmetry(), "xml"));
        builder.append(">");
        addChildren(ctx.getChildren());
        builder.append("</transponder>");
        return null;
    }

    @Override
    public Node visitSatellite(Satellite ctx) {
        builder.append("<sat ");
        builder.append(dictionary.getFirstAttribute("sat", ctx.getName(), "xml"));
        builder.append(dictionary.getAttribute("orbital", ctx.getOrbital(), "xml"));
        builder.append(">");
        addChildren(ctx.getChildren());
        builder.append("</sat>");

        return null;
    }

    @Override
    public Node visitChannel(Channel ctx) {
        builder.append("<channel ");
        var name = dictionary.normalizeFormat(ctx.getName(), "xml");
        builder.append(dictionary.getFirstAttribute("name", name, "xml"));
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

	public void addChildren(ArrayList<Node> children) {
		if(children.size() > 0){
            builder.append(dictionary.getArrayStartTag("xml", children.get(0).getClass()));
            for (int i = 0; i < children.size(); i++) {
                Node child = children.get(i);
                child.accept(this);
            }
            builder.append(dictionary.getArrayEndTag("xml", children.get(0).getClass()));
        }
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
}
