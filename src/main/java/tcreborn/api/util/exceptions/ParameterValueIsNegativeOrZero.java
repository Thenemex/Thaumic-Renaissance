package tcreborn.api.util.exceptions;

public class ParameterValueIsNegativeOrZero extends TCRException {

    public ParameterValueIsNegativeOrZero(int nb) {
        super("Parameter value is illegal : " + nb);
    }
}
