package SatelliteManagement.input;

import SatelliteManagement.aggregates.Aggregate;
import SatelliteManagement.output.Format;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.Locale;

/**
 * Class to handle the user input.
 *
 * @author Lukas Benner
 * @version 1.0
 */
public class CliArgs {
    @Parameter(names = {"-o", "--output"}, description = "Output path", required = true)
    private String outputPath = "SatelliteManagement/output";

    @Parameter(names = {"-a", "--aggregate"}, description = "How the data should be aggregated", required = true)
    private String aggregate = "";

    @Parameter(names = {"-f", "--format"}, description = "How the data should be aggregated", required = true)
    private String outputFormat = "";

    @Parameter(description = "Input path", required = true)
    private String inputPath = "";


    /**
     * Gets an instance of the class.
     *
     * @param argv the input arguments as an array of strings
     * @return a CliArgs object
     */
    public static CliArgs getInstance(String[] argv){
        CliArgs args = new CliArgs();
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);
        return args;
    }

    /**
     * Gets the aggregate based on the user input
     *
     * @return A value from the Aggregate enum
     * @exception RuntimeException if the user input matches no aggregate
     */
    public Aggregate getAggregate(){
        Aggregate ag;
        switch (aggregate.toLowerCase(Locale.ENGLISH)){
            case "ch-sat" -> ag = Aggregate.CHANNEL_SAT;
            case "sat-trans" -> ag = Aggregate.SAT_TRANSPONDER;
            default -> throw new RuntimeException("Argument -a should be \"ch-sat\" or \"sat-trans\", found " + "\"" + aggregate + "\"");
        }
        return ag;
    }

    /**
     * @return The output path specified by the user
     */
    public String getOutputPath(){
        return outputPath;
    }

    /**
     * Gets the output format based on the user input
     *
     * @return A value from the Format enum
     * @exception RuntimeException if the user input matches no format
     */
    public Format getOutputFormat(){
        Format format;
        switch (outputFormat.toLowerCase(Locale.ENGLISH)){
            case "xml" -> format = Format.XML;
            case "json" -> format = Format.JSON;
            default -> throw new RuntimeException("Parameter -f should be \"json\" or \"xml\", found " + "\"" + outputFormat + "\"");
        }
        return format;
    }

    /**
     * @return The input path specified by the user
     */
    public String getInputPath(){
        return inputPath;
    }
    
}
