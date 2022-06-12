package SatelliteManagement.input;

import java.util.ArrayList;

public class InputTransponder {
    public String sat;
    public String orbital;
    public String pol;
    public String freq;
    public String sym;
    public ArrayList<InputChannel> channels;

    public InputTransponder(String sat, String orbital, String pol, String freq, String sym, ArrayList<InputChannel> channels) {
        this.sat = sat;
        this.orbital = orbital;
        this.pol = pol;
        this.freq = freq;
        this.sym = sym;
        this.channels = channels;
    }
}


