package tcreborn.api.util.exceptions;

public class ParameterArraysSizeException extends TCRException {

    public ParameterArraysSizeException(int size1, int size2) {
        super("Parameters Arrays should be the same size : " + size1 + " " + size2);
    }
}
