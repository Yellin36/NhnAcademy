package SimpleFBP.wire;

import SimpleFBP.message.Message;

public interface InputConnector extends Connector {
    //void connect(OutputSocket socket);
    //void disconnect(OutputSocket socket);
    void put(Message message);
}
