import java.io.*;

public class FILE {
    String name;
    int line;
    int column;
    int ntok;
    int last;
    int buf[3];
    int buflen;

    BufferedReader reader;

    public FILE() {
        this.line = 1;
        this.column = 1;
        this.name = "";
    }
    public void makeFile(String name) {
        try {
            reader = new BufferedReader(new FileReader(name));
        }
        catch(FileNotFoundException f){
            System.out.println("File not found");
        }
    }
    public void makeFileFromString(String contents){
        reader = new BufferedReader(new CharArrayReader(contents.toCharArray()));
    }
}
