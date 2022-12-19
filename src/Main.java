import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SortedTextFile s = new SortedTextFile("test.txt");
        SortedTextFile s1 = new SortedTextFile("test2.txt");
        s.merge("test.txt", "test2.txt", "out.txt");

    }
}
