package SatelliteManagement.input;

import java.util.ArrayList;

/**
 * A class to easily map between json and java objects
 * @author Lukas Benner
 * @version 1.0
 */
public class InputTransponder {
    private String _sat;
    private String _orbital;
    private String _pol;
    private String _freq;
    private String _sym;
    private ArrayList<InputChannel> _channels;

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
        this._sat = sat;
        this._orbital = orbital;
        this._pol = pol;
        this._freq = freq;
        this._sym = sym;
        this._channels = channels;
    }

    /**
	 * Getter for satellite
	 * @return _sat
	 */
	public String get_sat() {
		return _sat;
	}

	/**
	 * Getter for orbital
	 * @return _orbital
	 */
	public String get_orbital() {
		return _orbital;
	}

	/**
	 * Getter for polarisation
	 * @return _pol
	 */
	public String get_pol() {
		return _pol;
	}

	/**
	 * Getter for frequency
	 * @return _freq
	 */
	public String get_freq() {
		return _freq;
	}

	/**
	 * Getter for symmetry
	 * @return _sym
	 */
	public String get_sym() {
		return _sym;
	}

	/**
	 * Getter for channels
	 * @return _channels
	 */
	public ArrayList<InputChannel> get_channels() {
		return _channels;
	}
}


