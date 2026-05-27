public class AssertsFila {

    public static void assertsFilaAddLast() {
        Fila fila = new Fila(5);
        assert fila.isEmpty();
        assert !fila.isFull();
        assert fila.size() == 0;

        fila.addLast(10);
        assert !fila.isEmpty();
        assert !fila.isFull();
        assert fila.getFirst() == 10;
        assert fila.getLast() == 10;
        assert fila.size() == 1;

        fila.addLast(20);
        assert !fila.isEmpty();
        assert !fila.isFull();
        assert fila.getFirst() == 10;
        assert fila.getLast() == 20;
        assert fila.size() == 2;

        fila.addLast(30);
        fila.addLast(40);
        assert !fila.isEmpty();
        assert !fila.isFull();
        assert fila.getFirst() == 10;
        assert fila.getLast() == 40;
        assert fila.size() == 4;

        fila.addLast(50);
        assert !fila.isEmpty();
        assert fila.isFull();
        assert fila.getFirst() == 10;
        assert fila.getLast() == 50;
        assert fila.size() == 5;

        fila.addLast(60);
        assert !fila.isEmpty();
        assert fila.isFull();
        assert fila.getFirst() == 20;
        assert fila.getLast() == 60;
        assert fila.size() == 5;
    }

    public static void assertsFilaRemoveFirst() {
        Fila fila = new Fila(5);
        fila.addLast(10);
        fila.removeFirst();
        assert fila.isEmpty();
        assert !fila.isFull();
        assert fila.size() == 0;

        fila.addLast(10);
        fila.addLast(20);
        fila.addLast(30);
        fila.addLast(40);
        fila.addLast(50);

        assert !fila.isEmpty();
        assert fila.isFull();
        assert fila.getFirst() == 10;
        assert fila.size() == 5;

        fila.addLast(500);
        assert fila.isFull();
        assert fila.getFirst() == 20;
        assert fila.getLast() == 500;
        assert fila.size() == 5;

        fila.removeFirst();
        fila.addLast(60);
        assert fila.getFirst() == 30;
        assert fila.getLast() == 60;
        assert fila.size() == 5;

        fila.removeFirst();
        fila.removeFirst();
        fila.removeFirst();

        assert !fila.isFull();
        assert fila.size() == 2;
        assert fila.getFirst() == 500;
        fila.removeFirst();
        fila.removeFirst();

        boolean removeFirstFalhou = false;
        try {
            fila.removeFirst();
        } catch (Exception e) {
            removeFirstFalhou = true;
        }
        assert removeFirstFalhou;

        boolean getLastFalhou = false;
        try {
            fila.getLast();
        } catch (Exception e) {
            getLastFalhou = true;
        }
        assert getLastFalhou;
    }

    public static void assertsFilaToString() {
        Fila fila = new Fila(5);
        assert fila.toString().equals("");
        fila.addLast(10);
        assert fila.toString().equals("10");
        fila.addLast(20);
        assert fila.toString().equals("10, 20");
        fila.addLast(30);
        assert fila.toString().equals("10, 20, 30");
        fila.removeFirst();
        assert fila.toString().equals("20, 30");
        fila.addLast(30);
        fila.addLast(40);
        fila.addLast(50);
        assert fila.toString().equals("20, 30, 30, 40, 50");
        fila.addLast(60);
        assert fila.toString().equals("30, 30, 40, 50, 60");
    }

    public static void assertsFilaIndexOf() {
        Fila fila = new Fila(5);
        assert fila.indexOf(10) == -1;
        fila.addLast(10);
        assert fila.indexOf(10) == 0;
        fila.addLast(20);
        assert fila.indexOf(20) == 1;
        assert fila.indexOf(10) == 0;

        fila.addLast(30);
        fila.addLast(10);
        assert fila.indexOf(10) == 0;
        fila.addLast(40);
        fila.addLast(50);
        assert fila.indexOf(50) == 4;
        fila.addLast(60);
        assert fila.indexOf(20) == -1;
        assert fila.indexOf(30) == 0;
        assert fila.indexOf(60) == 4;
    }

    public static void assertsFilaLastIndexOf() {
        Fila fila = new Fila(5);
        fila.addLast(10);
        fila.addLast(20);
        fila.addLast(30);
        fila.addLast(40);
        fila.addLast(50);

        assert fila.lastIndexOf(50) == 4;
        assert fila.lastIndexOf(10) == 0;
        assert fila.lastIndexOf(30) == 2;
        fila.removeFirst();
        fila.addLast(50);
        assert fila.lastIndexOf(30) == 1;

        assert fila.indexOf(50) == 3;
        assert fila.lastIndexOf(50) == 4;

        fila.addLast(60);
        assert fila.lastIndexOf(20) == -1;
        assert fila.lastIndexOf(60) == 4;
    }

    public static void main(String[] args) {
        assertsFilaAddLast();
        assertsFilaRemoveFirst();
        assertsFilaToString();
        assertsFilaIndexOf();
        assertsFilaLastIndexOf();
        System.out.println("Todos os asserts de Fila passaram com sucesso.");
    }
}
