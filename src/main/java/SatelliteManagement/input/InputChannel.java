package SatelliteManagement.input;

/**
 * A class to easily map between json and java objects
 * @author Lukas Benner
 * @version 1.0
 */
public class InputChannel {
    public String sid;
    public String name;

    public InputChannel(String sid, String name) {
        this.sid = sid;
        this.name = name;
    }
}
