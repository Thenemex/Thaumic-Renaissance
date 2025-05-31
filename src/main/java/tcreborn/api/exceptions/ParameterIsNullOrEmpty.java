package tcreborn.api.exceptions;

public class ParameterIsNullOrEmpty extends TCRException{

    public ParameterIsNullOrEmpty() {
        super("One of the parameters is null or empty.");
    }
}
