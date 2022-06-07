import aggregates.SatellitesOverTransponders_Visitor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import input.InputHandler;
import output.JsonOutput_Visitor;
import output.XmlOutput_Visitor;
import tree.Node;
import aggregates.ChannelsOverSatellites_Visitor;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        Node root = InputHandler.parseJsonToTree("input.json");
        Node newTree = root.accept(new ChannelsOverSatellites_Visitor());
        newTree = root.accept(new SatellitesOverTransponders_Visitor());

        JsonOutput_Visitor jsonOutput_visitor = new JsonOutput_Visitor();
        newTree.accept(jsonOutput_visitor);
        StringBuilder builderJson = jsonOutput_visitor.builder;

        XmlOutput_Visitor xmlOutput_visitor = new XmlOutput_Visitor();
        newTree.accept(xmlOutput_visitor);
        StringBuilder builderXml = xmlOutput_visitor.builder;
        System.out.println(builderXml.toString());

        try {
            Source xmlInput = new StreamSource(new StringReader(builderXml.toString()));
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer(); // An identity transformer
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "testing.dtd");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(xmlInput, xmlOutput);
            System.out.println(xmlOutput);
        }
        catch (TransformerException e){
            throw new RuntimeException(e);
        }


    }
}