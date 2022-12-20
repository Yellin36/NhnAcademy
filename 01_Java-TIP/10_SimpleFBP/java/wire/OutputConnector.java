package SimpleFBP.wire;

public interface OutputConnector extends Connector {
    void connect(InputSocket socket);
    void disconnect(InputSocket socket);
}
