import aggregates.*;
import input.CliArgs;
import input.InputHandler;
import output.*;
import tree.Node;
import visitor.iVisitor;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class Main {
    public static void main(String[] argv) {

        CliArgs args = CliArgs.getInstance(argv);

        Node inputTree = InputHandler.parseJsonToTree(args.getInputPath());
        iVisitor aggregate = AggregateVisitorFactory.produceAggregateVisitor(args.getAggregate());
        Node aggregatedTree = inputTree.accept(aggregate);

        iOutput_Visitor outputVisitor =  OutputVisitorFactory.produceVisitor(args.getOutputFormat());
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