package SimpleFBP2.node;



public abstract class OutputNode2 extends ActiveNode2 {
    protected InputPort[] inputPorts;
    protected OutputNode2(int count) {
        super();
        this.inputPorts = new InputPort[count];
        for (int i = 0; i < count; i++) {
            inputPorts[i] = new InputPort(this);
        }
    }
    public int getInputPortCount() {
        return this.inputPorts.length;
    }
    public InputPort getInputPort(int index) {
        return this.inputPorts[index];
    }

}
