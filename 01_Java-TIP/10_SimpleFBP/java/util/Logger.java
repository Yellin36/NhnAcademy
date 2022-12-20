package SimpleFBP.util;

import java.util.Date;
import java.util.logging.*;

public class Logger {
    private java.util.logging.Logger logger;
    static Handler handler = null;

    static Handler getHandler() {
        if(Logger.handler == null) {
            handler = new ConsoleHandler();
            handler.setFormatter(new SimpleFormatter() {
                private static final String format = "[%1$tF %1$tT] [%2$-4s] [%3$-16s] %4$s %n";

                @Override
                public synchronized String format(LogRecord lr) {
                    return String.format(format, new Date(lr.getMillis()),
                            lr.getLevel().getLocalizedName(),
                            lr.getLoggerName(),
                            lr.getMessage()
                    );
                }
            });
        }
        return Logger.handler;
    }
    public Logger(String name) {
        this.logger = java.util.logging.Logger.getLogger(name);
        this.logger.setUseParentHandlers(false);
        if(this.logger.getHandlers().length == 0) {
            this.logger.addHandler(Logger.getHandler());
        }
    }
    public void info(String message) {
        this.logger.info(message);
        //this.logger.log(Level.INFO, message);
    }

}
