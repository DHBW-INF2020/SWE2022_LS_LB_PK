package SatelliteManagement.input;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FormatArgValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        List<String> allowed = Arrays.asList("xml", "json");
        if(!allowed.contains(value.toLowerCase(Locale.ENGLISH))){
            System.err.println("Parameter \"" + name + "\" should be in " + allowed + ", (found " + value + ")");
            System.exit(-1);
        }
    }
}
