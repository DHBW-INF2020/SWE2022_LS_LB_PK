package SatelliteManagement.input;

/**
 * A class to easily map between json and java objects
 * @author Lukas Benner
 * @version 1.0
 */
public class InputChannel {

	//the private member variables don't start with a _ because they have to be mapped
	//from a json string
	private String sid;
    private String name;

    /**
     * Constructor to map channel from json to java object 
     * @param sid
     * @param name
     */
    public InputChannel(String sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    /**
     * Getter for sid
     * @return sid
     */
	public String getSid() {
		return sid;
	}

	/**
	 * Getter for name
	 * @return name
	 */
	public String getName() {
		return name;
	}
}
