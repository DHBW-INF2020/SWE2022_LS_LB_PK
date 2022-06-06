package input;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import tree.*;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class InputHandler {
    // JsonReader
    public Node parseJsonToTree(String filename) {
        Gson gson = new Gson();
        Root root = new Root();
        HashMap<String, Satellite> sattelites = new HashMap<>();

        try(Reader reader = Files.newBufferedReader(Paths.get("C:\\Daten\\projects\\SWE2022_LS_LB_PK\\input.json"));){

            List<LinkedTreeMap<String, Object>> list = gson.fromJson(reader, List.class);

            for(LinkedTreeMap<String, Object> trans : list){
                String satName = (String) trans.get("sat");
                Transponder transponder = new Transponder((String) trans.get("pol"), parseInt((String) trans.get("freq")), (String) trans.get("sym"));
                ArrayList<Node> channels = new ArrayList<>();
                for(LinkedTreeMap<String, String> channel : (ArrayList<LinkedTreeMap<String, String>>) trans.get("channels")){
                    channels.add(new Channel(channel.get("name"), parseInt(channel.get("sid"))));
                }
                transponder.setChildren(channels);
                if(sattelites.containsKey(satName)){
                    sattelites.get(satName).addChild(transponder);
                }
                else{
                    Satellite sat = new Satellite(satName, (String) trans.get("orbital"));
                    sat.addChild(transponder);
                    sattelites.put(satName, sat);
                }
            }

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Node> children
                = sattelites.values().stream().collect(
                Collectors.toCollection(ArrayList::new));
        root.setChildren(children);
        return root;
    }
}
