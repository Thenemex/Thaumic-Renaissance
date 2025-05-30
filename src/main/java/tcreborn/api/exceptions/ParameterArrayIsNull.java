package tcreborn.api.exceptions;

public class ParameterArrayIsNull extends TCRException{

    public ParameterArrayIsNull() {
        super("One of the arrays in parameters is null or empty.");
    }
}
