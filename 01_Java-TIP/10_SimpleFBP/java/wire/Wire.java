package SimpleFBP.wire;

import SimpleFBP.message.Message;
import SimpleFBP.util.Logger;

import java.util.NoSuchElementException;

public class Wire implements InputConnector, OutputConnector {
    private static int count = 0;
    private final String id;
    //private OutputSocket outputSocket;
    private InputSocket inputSocket;
    private Logger logger;

    public Wire() {
        this.id = String.format("%s@%08d", this.getClass().getSimpleName(), ++Wire.count);
    }

    public String getId() {
        return id;
    }

    //OutputConnector
    public void connect(InputSocket inputSocket) {
        //if(this.inputSocket == null)
            this.inputSocket = inputSocket;
    }
    public void disconnect(InputSocket inputSocket) {
        if(this.inputSocket == inputSocket) this.inputSocket = null;
        else {
            throw new NoSuchElementException();
        }
    }
    /*
    public void disconnect(OutputSocket outputSocket) {
            if(this.outputSocket == outputSocket) this.outputSocket = null;
            else {
                throw new NoSuchElementException();
            }
        }
    public void connect(OutputSocket outputSocket) {
        if(this.outputSocket == null) this.outputSocket = outputSocket;
    }*/


    //InputConnector
    @Override
    public void put(Message message) {
        if(inputSocket != null) this.inputSocket.put(message);
        else {
            throw new NoSuchElementException();
        }
    }

    public Logger getLogger() {
        return logger;
    }
}
