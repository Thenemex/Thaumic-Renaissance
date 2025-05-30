package tcreborn.api.exceptions;

import static tcreborn.ThaumicRenaissance.modID;

public abstract class TCRException extends RuntimeException {

    public TCRException(String text) {
        super(modID.concat(" : ").concat(text));
    }
}
