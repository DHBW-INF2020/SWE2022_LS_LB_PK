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
public class JsonParser implements iFormatParser {

    @Override
    public Node parseInputFile(String fileName) {
        Gson gson = new Gson();
        Root root = new Root();

        try(Reader reader = Files.newBufferedReader(Paths.get(fileName))){

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

        if(inputTransponders == null)
            throw new IllegalArgumentException("inputTransponders can not be null");

        for(InputTransponder inputTransponder : inputTransponders){
            String satName = inputTransponder.getSat();
            Transponder transponder = new Transponder(inputTransponder.getPol(), inputTransponder.getFreq(), inputTransponder.getSym());
            ArrayList<Node> channels = new ArrayList<>();
            for(InputChannel channel :  inputTransponder.get_channels()){
                channels.add(new Channel(channel.getName(), parseInt(channel.getSid())));
            }
            transponder.setChildren(channels);
            if(satellites.containsKey(satName)){
                satellites.get(satName).addChild(transponder);
            }
            else{
                Satellite sat = new Satellite(satName, inputTransponder.getOrbital());
                sat.addChild(transponder);
                satellites.put(satName, sat);
            }
        }
        return new ArrayList<>(satellites.values());
    }


}
