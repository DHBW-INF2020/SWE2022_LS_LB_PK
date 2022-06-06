import com.google.gson.Gson;
import input.InputHandler;
import tree.Node;
import aggregates.ChannelsOverSatellites_Visitor;
import aggregates.SatellitesOverTransponders_Visitor;

import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Node root = InputHandler.parseJsonToTree("input.json");
        Node newTree = root.accept(new ChannelsOverSatellites_Visitor());
        newTree = root.accept(new SatellitesOverTransponders_Visitor());
        Gson gson = new Gson();
        try{
            gson.toJson(newTree.getChildren(), new FileWriter("output.json"));
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}