import aggregates.*;
import input.InputHandler;
import output.*;
import tree.Node;
import visitor.iVisitor;


public class Main {
    public static void main(String[] args) {
        Node inputTree = InputHandler.parseJsonToTree("input.json");
        iVisitor aggregate = AggregateVisitorFactory.produceAggregateVisitor(Aggregate.CHANNEL_SAT);
        Node aggregatedTree = inputTree.accept(aggregate);

        iOutput_Visitor outputVisitor =  OutputVisitorFactory.produceVisitor(Format.JSON);
        aggregatedTree.accept(outputVisitor);
        System.out.println(outputVisitor.getParsedData());
    }
}