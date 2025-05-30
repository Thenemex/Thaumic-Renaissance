package tcreborn.api.exceptions;

public class ParameterIsNull extends TCRException{

    public ParameterIsNull() {
        super("One of the parameters is null or empty.");
    }
}
