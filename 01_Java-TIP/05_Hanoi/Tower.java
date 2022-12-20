package Hanoi;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private String name;
    private int size = getList().size();
    private List<Disk> list;

    public Tower(String name) {
        this.name = name;
        list = new ArrayList<>();
    }
    public void push(Disk disk) {
        list.add(disk);
    }
    public Disk pop() {
        //
        return list.get(list.size());
    }
    public String getName() { return name; }
    public List<Disk> getList() { return list; }
}
