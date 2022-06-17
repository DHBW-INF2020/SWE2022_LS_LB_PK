package SatelliteManagement.input;

import java.util.ArrayList;

/**
 * A class to easily map between json and java objects
 * @author Lukas Benner
 * @version 1.0
 */
public class InputTransponder {

	//the private member variables don't start with a _ because they have to be mapped
	//from a json string
	private String sat;
    private String orbital;
    private String pol;
    private String freq;
    private String sym;
    private ArrayList<InputChannel> channels;

    /**
     * Constructor to map transponder from json to java object
     * @param sat
     * @param orbital
     * @param pol
     * @param freq
     * @param sym
     * @param channels
     */
    public InputTransponder(String sat, String orbital, String pol, String freq, String sym, ArrayList<InputChannel> channels) {
        this.sat = sat;
        this.orbital = orbital;
        this.pol = pol;
        this.freq = freq;
        this.sym = sym;
        this.channels = channels;
    }

    /**
	 * Getter for satellite
	 * @return _sat
	 */
	public String getSat() {
		return sat;
	}

	/**
	 * Getter for orbital
	 * @return _orbital
	 */
	public String getOrbital() {
		return orbital;
	}

	/**
	 * Getter for polarisation
	 * @return _pol
	 */
	public String getPol() {
		return pol;
	}

	/**
	 * Getter for frequency
	 * @return _freq
	 */
	public String getFreq() {
		return freq;
	}

	/**
	 * Getter for symmetry
	 * @return _sym
	 */
	public String getSym() {
		return sym;
	}

	/**
	 * Getter for channels
	 * @return _channels
	 */
	public ArrayList<InputChannel> get_channels() {
		return channels;
	}
}


