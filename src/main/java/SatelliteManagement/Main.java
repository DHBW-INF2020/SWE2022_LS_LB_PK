package SatelliteManagement;

import SatelliteManagement.aggregates.AggregateVisitorFactory;
import SatelliteManagement.output.OutputVisitorFactory;
import SatelliteManagement.output.iOutputVisitor;
import SatelliteManagement.input.CliArgs;
import SatelliteManagement.input.InputHandler;
import SatelliteManagement.tree.Node;
import SatelliteManagement.visitor.iVisitor;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Main for Satellite Management
 * @author Lea Soffel
 * @version 1.0
 */
public class Main {
    public static void main(String[] argv) {
    	
    	// save input args
        CliArgs args = CliArgs.getInstance(argv);
        
        // build tree from input JSON
        Node inputTree = InputHandler.parseJsonToTree(args.getInputPath());
        
        // save the aggregate from the args
        iVisitor aggregate = AggregateVisitorFactory.produceVisitor(args.getAggregate());
        Node aggregatedTree = inputTree.accept(aggregate);

        // save output format from args
        iOutputVisitor outputVisitor =  OutputVisitorFactory.produceVisitor(args.getOutputFormat());
        aggregatedTree.accept(outputVisitor);

        // write output file
        Writer fstream = null;
        try{
           fstream = new OutputStreamWriter(new FileOutputStream(args.getOutputPath()), StandardCharsets.UTF_8);
           fstream.write(outputVisitor.getParsedData());
           fstream.flush();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}