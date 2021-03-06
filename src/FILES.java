import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class FILES {

    boolean isEndOfFiles = false;
    Deque<FILE> files = new ArrayDeque<>();
    Deque<Character> buffer = new ArrayDeque<>();

    public FILES addFile(FILE file) {
        files.add(file);
        return this;
    }

    private FILE popTail() {
        if (files.size() > 0)
            return files.pollLast();
        return null;
    }

    public FILE currentFile() {
        return files.getLast();
    }

    public Character get() {
        fillLine();
        if (isEndOfFiles)
            return null;

        currentFile().uc(1+currentFile().getc());
        return buffer.pollFirst();
    }

    public void unget(Character c) {
        buffer.addFirst(c);
    }

    public void fillLine() {
        String newLine;
        if (buffer.size() == 0) {
            try {
                newLine = currentFile().reader.readLine();
                while (newLine == null && files.size() > 1) {
                    popTail();
                    newLine = currentFile().reader.readLine();
                }

                currentFile().uc(0);
                currentFile().ul(1+currentFile().getl());

                if (newLine == null) {
                    isEndOfFiles = true;
                } else {
                    if (!newLine.trim().equals("")) {
                        newLine = newLine.replaceAll("\\\n","");
                        for (char c : newLine.toCharArray()) {
                            buffer.add(new Character(c));
                        }
                    } else {
                        buffer.add(new Character(' '));
                    }
                }
            } catch (IOException e) {
                System.out.println("fillLine Exception");
            }
        }
    }
}
