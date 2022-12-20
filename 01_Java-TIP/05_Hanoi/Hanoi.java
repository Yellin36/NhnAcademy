package Hanoi;

public class Hanoi {
    public static void run(Tower base, Tower target, Tower temp, long count) {
        move(base, target, temp, count);
    }
    public static void move(Tower base, Tower target, Tower temp, long count) {
        if(count== 1) {
            System.out.println("Move " + 1 + " from tower " + base.getName() + " to " + target.getName());
        }
        else {
            move(base, temp, target, count - 1);
            System.out.println("Move " + count + " from tower " + base.getName() + " to " + target.getName());
            move(temp, target, base, count - 1);
        }
        /*
         * if(count != 1) {
         *      move(base, temp, target, count - 1);
         * }
         * Disk disk = base.pop();
         * target.push(disk);
         * System.out.println("Move " + disk.size() + "from tower " + base.getName() + " to tower " + target.getName());
         * if(count != 1) {
         *      move(temp, target, base, count - 1);
         * }
         */
    }
    public static void main(String[] args) {
        Tower A = new Tower("A");
        Tower B = new Tower("B");
        Tower C = new Tower("C");

        A.push(new Disk("5", 5));
        A.push(new Disk("4", 4));
        A.push(new Disk("3", 3));
        A.push(new Disk("2", 2));
        A.push(new Disk("1", 1));

        System.out.println("Tower " + A.getName() + ": " + A.getList().toString());
        System.out.println("Tower " + B.getName() + ": " + B.getList().toString());
        System.out.println("Tower " + C.getName() + ": " + C.getList().toString());

        Hanoi.run(A, C, B, 5);
    }
}
