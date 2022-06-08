package input;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import java.util.*;


public class AggregateArgValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        List<String> allowed = Arrays.asList("ch-sat", "sat-trans");
        if(!allowed.contains(value.toLowerCase(Locale.ENGLISH))){
            System.err.println("Parameter \"" + name + "\" should be in " + allowed + ", (found " + value + ")");
            System.exit(-1);
        }
    }
}
