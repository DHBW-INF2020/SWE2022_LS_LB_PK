package SatelliteManagement.input;

import com.google.gson.Gson;
import SatelliteManagement.tree.*;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * A class to read the json input and create a tree
 * @author Lukas Benner
 * @version 1.0
 */
public class InputHandler {
    
    /**
     * Creates a tree of Nodes from the input file
     *
     * @param filename Path to the input file
     * @return Root Node of the input tree
     */
    // JsonReader
    public static Node parseJsonToTree(String filename) {
        Gson gson = new Gson();
        Root root = new Root();

        try(Reader reader = Files.newBufferedReader(Paths.get(filename))){

            InputTransponder[] list = gson.fromJson(reader, InputTransponder[].class);

            var satellites = getSatellitesFromInputFormat(new ArrayList<InputTransponder>(List.of(list)));
            root.setChildren(satellites);

        } catch(IOException e) {
           throw new RuntimeException(e);
        }
        return root;
    }

    /**
     * Turns a list of InputTransponders into a list of Satellites
     *
     * @param inputTransponders A list of InputTransponders
     * @return A list of Satellites
     */
    protected static ArrayList<Node> getSatellitesFromInputFormat(ArrayList<InputTransponder> inputTransponders) {
        HashMap<String, Satellite> satellites = new HashMap<>();
        for(InputTransponder inputTrasponder : inputTransponders){
            String satName = inputTrasponder.sat;
            Transponder transponder = new Transponder(inputTrasponder.pol, inputTrasponder.freq, inputTrasponder.sym);
            ArrayList<Node> channels = new ArrayList<>();
            for(InputChannel channel :  inputTrasponder.channels){
                channels.add(new Channel(channel.name, parseInt(channel.sid)));
            }
            transponder.setChildren(channels);
            if(satellites.containsKey(satName)){
                satellites.get(satName).addChild(transponder);
            }
            else{
                Satellite sat = new Satellite(satName, inputTrasponder.orbital);
                sat.addChild(transponder);
                satellites.put(satName, sat);
            }
        }
        return new ArrayList<>(satellites.values());
    }
}
