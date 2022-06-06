import aggregates.SatellitesOverTransponders_Visitor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import input.InputHandler;
import output.JsonOutput_Visitor;
import tree.Node;
import aggregates.ChannelsOverSatellites_Visitor;

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
        StringBuilder builder = jsonOutput_visitor.builder;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(builder.toString());
        String prettyJsonString = gson.toJson(je);

        System.out.println(prettyJsonString);
    }
}