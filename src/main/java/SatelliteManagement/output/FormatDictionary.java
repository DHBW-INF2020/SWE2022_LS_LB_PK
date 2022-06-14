package SatelliteManagement.output;

import SatelliteManagement.tree.Channel;
import SatelliteManagement.tree.Node;
import SatelliteManagement.tree.Satellite;
import SatelliteManagement.tree.Transponder;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FormatDictionary {

    private Map<Class, String> typeToArrayName;

    public FormatDictionary(){
        typeToArrayName = new HashMap<>();
        typeToArrayName.put(Satellite.class, "satellites");
        typeToArrayName.put(Transponder.class, "transponders");
        typeToArrayName.put(Channel.class, "channels");
    }

    public String getArrayStartTag(String format, Class childClass){
        var arrayName = typeToArrayName.get(childClass);
        switch (format.toLowerCase(Locale.ENGLISH)){
            case "json" -> { return arrayName + ":["; }
            case "xml" -> { return "<"+arrayName+">"; }
            default -> throw new RuntimeException("Unknown format " + format + " specified");
        }
    }

    public String getArrayEndTag(String format, Class childClass){
        var arrayName = typeToArrayName.get(childClass);
        switch (format.toLowerCase(Locale.ENGLISH)){
            case "json" -> { return "]"; }
            case "xml" -> { return "</"+arrayName+">"; }
            default -> throw new RuntimeException("Unknown format " + format + " specified");
        }
    }

    public String getAttribute(String name, String value, String format){
        switch (format.toLowerCase(Locale.ENGLISH)){
            case "json" -> { return "," + getFirstAttribute(name, value, format); }
            case "xml" -> { return " " + getFirstAttribute(name, value, format); }
            default -> throw new RuntimeException("Unknown format " + format + " specified");
        }
    }

    public String getFirstAttribute(String name, String value, String format){
        switch (format.toLowerCase(Locale.ENGLISH)){
            case "json" -> { return "\"" + name + "\": \"" + value + "\""; }
            case "xml" -> { return name + "=\"" + value + "\""; }
            default -> throw new RuntimeException("Unknown format " + format + " specified");
        }
    }



    /**
     * Escape forbidden characters for given format
     * @param input the input string that has to be normalized
     * @param format specifies the format to normalize the input for
     * @return input with the correct notation of the forbidden characters
     */
    public String normalizeFormat(String input, String format){

        if(format.toLowerCase(Locale.ENGLISH).equals("json")){
            return input.replaceAll("\"", "\\\\\"")
                    .replaceAll("\t", "\\t")
                    .replaceAll("\b", "\\\\\b");
        }

        else if (format.toLowerCase(Locale.ENGLISH).equals("xml")) {
            return input.replaceAll("&", "&amp;")
                    .replaceAll("\"", "&quot;")
                    .replaceAll("'", "&apos;")
                    .replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;");
        }

        else {
            throw new RuntimeException("Unknown format " + format + " specified");
        }
    }

}
