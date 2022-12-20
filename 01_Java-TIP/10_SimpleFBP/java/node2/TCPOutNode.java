package SimpleFBP2.node;

//TCP 출력 노드는 TCP 서버 노드에 연결되어, 입력으로 들어오는 전송 데이터를 TCP 서버를 이용해 전송한다.
public class TCPOutNode extends InputOutputNode2 {
    public TCPOutNode() {
        super(1, 1);
    }

    @Override
    public synchronized void main() {
       if(getInputPort(0).hasMessage()) {
           //System.out.println("입력으로부터 데이터를 받았습니다.");
           output(getInputPort(0).get());
       }
    }
}
