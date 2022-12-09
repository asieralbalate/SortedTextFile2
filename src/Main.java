import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SortedTextFile s = new SortedTextFile("test.txt");
        s.put("ccccc");
        s.put("aaaaa");
        s.put("bbbbb");
        s.put("ddddd");
        s.print();

    }
}
