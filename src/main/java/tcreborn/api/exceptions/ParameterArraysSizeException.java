package tcreborn.api.exceptions;

public class ParameterArraysSizeException extends TCRException {

    public ParameterArraysSizeException(String arraysSize) {
        super("Parameters Arrays should be the same size : ".concat(arraysSize));
    }
}
