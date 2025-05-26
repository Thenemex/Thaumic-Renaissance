package tcreborn.api;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import static tcreborn.ThaumicRenaissance.modID;

public class Logger {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(modID);

    public static void logInfo(String message) {
        logger.log(Level.INFO, modID.concat(" : ").concat(message));
    }
    public static void logError(String message) {
        logger.log(Level.ERROR, modID.concat(" : ").concat(message));
    }
}
