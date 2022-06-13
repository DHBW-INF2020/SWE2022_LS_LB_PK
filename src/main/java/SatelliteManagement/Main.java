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


public class Main {
    public static void main(String[] argv) {

        CliArgs args = CliArgs.getInstance(argv);

        Node inputTree = InputHandler.parseJsonToTree(args.getInputPath());
        iVisitor aggregate = AggregateVisitorFactory.produceVisitor(args.getAggregate());
        Node aggregatedTree = inputTree.accept(aggregate);

        iOutputVisitor outputVisitor =  OutputVisitorFactory.produceVisitor(args.getOutputFormat());
        aggregatedTree.accept(outputVisitor);

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