import SimpleFBP.util.MyLogger;

public class TestMyLogger {
    public static void main(String[] args) {
        MyLogger logger= new MyLogger("TEST");

        logger.error("Error!!");
        logger.warning("Warning!!");
        logger.info("그냥 알려준다.");
        logger.debug("개발자만 봐라.");
    }
}
