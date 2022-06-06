package output;

import tree.Root;
import visitor.BaseVisitor;

public class JsonOutput_Visitor extends BaseVisitor {

    String jsonString = "";

    @Override
    public Object visitRoot(Root ctx) {
        return super.visitRoot(ctx);
    }
}
