public class Test {
    public static void main(String[] args) {
        System.out.println("Тесты");
        System.out.println("Наносекунд на добавление 100 элементов через метод add(1.6):");
        long end;
        long start = System.nanoTime();
        demoCollection test = new demoCollection(100);
        for (int i = 0; i < test.length();i++) {
            test.add("qwerty");
        }
        end = System.nanoTime();
        System.out.println(end-start);

        System.out.println();
        System.out.println("Наносекунд на добавление 100 элементов через метод add(+1):");
        start = System.nanoTime();
        test = new demoCollection(100);
        for (int i = 0; i < test.length();i++) {
            test.addExp("qwerty");
        }
        end = System.nanoTime();
        System.out.println(end-start);

        System.out.println();
        System.out.println("Наносекунд на добавление 10000 элементов через метод add(1.6):");
        start = System.nanoTime();
        test = new demoCollection(10000);
        for (int i = 0; i < test.length();i++) {
            test.add("qwerty");
        }
        end = System.nanoTime();
        System.out.println(end-start);

        System.out.println();
        System.out.println("Наносекунд на добавление 10000 элементов через метод add(+1):");
        start = System.nanoTime();
        test = new demoCollection(10000);
        for (int i = 0; i < test.length();i++) {
            test.addExp("qwerty");
        }
        end = System.nanoTime();
        System.out.println(end-start);

        System.out.println();
        System.out.println("Наносекунд на добавление 1000000 элементов через метод add(1.6):");
        start = System.nanoTime();
        test = new demoCollection(1000000);
        for (int i = 0; i < test.length();i++) {
            test.add("qwerty");
        }
        end = System.nanoTime();
        System.out.println(end-start);

        System.out.println();
        System.out.println("Наносекунд на добавление 1000000 элементов через метод add(+1):");
        start = System.nanoTime();
        test = new demoCollection(1000000);
        for (int i = 0; i < test.length();i++) {
            test.addExp("qwerty");
        }
        end = System.nanoTime();
        System.out.println(end-start);
    }
}
