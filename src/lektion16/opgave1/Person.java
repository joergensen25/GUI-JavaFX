package lektion16.opgave1;

public class Person {
    private final String name;
    private final String title;
    private final boolean senior;

    public Person(String name, String title, boolean senior) {
        this.name = name;
        this.title = title;
        this.senior = senior;
    }

    public String toString() {
        String s = title + " " + name;
        if (senior) {
            s += " (senior)";
        }
        return s;
    }
}
