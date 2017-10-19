import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FILE {
    public BufferedReader reader;
    String name;
    int line;
    int column;
    int ntok;
    int last;

    public FILE() {
        this.line = 1;
        this.column = 1;
        this.name = "";
    }

    public void makeFile(String name) {
        try {
            reader = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException f) {
            System.out.println("File not found");
        }
    }

    public void makeFileFromString(String contents) {
        reader = new BufferedReader(new CharArrayReader(contents.toCharArray()));
    }

    public void ul(int l) {
        this.line = l;
    }

    public void uc(int c) {
        this.column = c;
    }

    public int getl() {
        return this.line;
    }

    public int getc() {
        return this.column;
    }
}
