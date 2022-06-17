package SatelliteManagement.input;

/**
 * A class to easily map between json and java objects
 * @author Lukas Benner
 * @version 1.0
 */
public class InputChannel {
    private String _sid;
    private String _name;

    /**
     * Constructor to map channel from json to java object 
     * @param sid
     * @param name
     */
    public InputChannel(String sid, String name) {
        this._sid = sid;
        this._name = name;
    }

    /**
     * Getter for sid
     * @return sid
     */
	public String get_sid() {
		return _sid;
	}

	/**
	 * Getter for name
	 * @return name
	 */
	public String get_name() {
		return _name;
	}
}
