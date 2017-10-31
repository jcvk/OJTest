package firstfit;

/**
 * Created by lenovo on 2017/10/29.
 */
public class Memory {

    private int position;
    private int length;
    private Memory nextMemory;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Memory getNextMemory() {
        return nextMemory;
    }

    public void setNextMemory(Memory nextMemory) {
        this.nextMemory = nextMemory;
    }
}
