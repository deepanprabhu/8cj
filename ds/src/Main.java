import java.nio.file.FileSystems;

/**
 * Created by dpanprbu on 10/19/17.
 */
public class Main {
    public static void main(String[] args) {
        FILES f = new FILES();
        FILE f1 = new FILE();
        FILE f2 = new FILE();
        f1.makeFile("./ds/src/FILE.java");
        f2.makeFile("./ds/src/FILES.java");
        f.addFile(f1).addFile(f2);

        Character c;
        System.out.println("");
        while((c = f.get()) != null){
            System.out.print(c);
        }
    }
}
