package SatelliteManagement.input;

import SatelliteManagement.aggregates.Aggregate;
import SatelliteManagement.output.Format;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.Locale;

public class CliArgs {
    @Parameter(names = {"-o", "--output"}, description = "Output path", required = true)
    private final String outputPath = "SatelliteManagement/output";

    @Parameter(names = {"-a", "--aggregate"}, description = "How the data should be aggregated", required = true)
    private final String aggregate = "";

    @Parameter(names = {"-f", "--format"}, description = "How the data should be aggregated", required = true)
    private final String outputFormat = "";

    @Parameter(description = "Input path", required = true)
    private final String inputPath = "";
    
    public static CliArgs getInstance(String[] argv){
        CliArgs args = new CliArgs();
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);
        return args;
    }
    
    public Aggregate getAggregate(){
        Aggregate ag;
        switch (aggregate.toLowerCase(Locale.ENGLISH)){
            case "ch-sat" -> ag = Aggregate.CHANNEL_SAT;
            case "sat-trans" -> ag = Aggregate.SAT_TRANSPONDER;
            default -> throw new RuntimeException("Argument -a should be \"ch-sat\" or \"sat-trans\", found " + "\"" + aggregate + "\"");
        }
        return ag;
    }

    public String getOutputPath(){
        return outputPath;
        //No Validation here because of the validation of the arguments itself
    }

    public Format getOutputFormat(){
        Format format;
        switch (outputFormat.toLowerCase(Locale.ENGLISH)){
            case "xml" -> format = Format.XML;
            case "json" -> format = Format.JSON;
            default -> throw new RuntimeException("Parameter -f should be \"json\" or \"xml\", found " + "\"" + outputFormat + "\"");
        }
        return format;
    }

    public String getInputPath(){
        return inputPath;
    }
    
}
