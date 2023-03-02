package SystemDesign.LoggingFramework;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
//        logger.info("This is info");
//        logger.error("This is error");
        logger.debug("This is debug");
    }
}
