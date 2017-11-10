public class Token {
    TokenType kind;
    FILE file;
    int line;
    int column;
    boolean space;
    boolean bol;
    int count;
    Data data;

    class Data {
        int id;
        protected class Str {
            protected String sval;
            protected int slen;
            protected int c;
            protected int enc;
        }
        protected class MacroParam {
            boolean isVarArg;
            int position;
        }
        Str str = new Str();
        MacroParam macroParam = new MacroParam();
    }
}
