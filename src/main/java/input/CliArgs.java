package input;

import aggregates.Aggregate;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import output.Format;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CliArgs {
    @Parameter(names = {"-o", "--output"}, description = "Output path", required = true)
    private String outputPath = "output";

    @Parameter(names = {"-a", "--aggregate"}, description = "How the data should be aggregated", required = true, validateWith = AggregateArgValidator.class)
    private String aggregate = "";

    @Parameter(names = {"-f", "--format"}, description = "How the data should be aggregated", required = true, validateWith = FormatArgValidator.class)
    private String outputFormat = "";

    @Parameter(description = "Input path", required = true)
    private String inputPath = "";
    
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
            default -> throw new RuntimeException("No matching aggregate");
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
            default -> throw new RuntimeException("No matching format");
        }
        return format;
    }

    public String getInputPath(){
        return inputPath;
    }
    
}
