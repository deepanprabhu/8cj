public class TokenHelper {
    State state;

    public void setState(State state) {
        this.state = state;
    }

    public Token makeToken(){
        Token r = new Token();
        FILE f = state.f.currentFile();
        r.file = f;
        r.line = state.pos.line;
        r.column = state.pos.column;
        r.count = f.getTok();
        r.data = r.new Data();
        f.incTok();
        return r;
    }

    public Token makeIdentifier(String str){
        Token token = makeToken();
        token.kind = TokenType.TIDENT;
        token.data.str.sval = str;
        return token;
    }

    public Token makeStrToken(String str, int len, int enc){
        Token token = makeToken();
        token.kind = TokenType.TSTRING;
        token.data.str.sval = str;
        token.data.str.slen = len;
        token.data.str.enc = enc;
        return token;
    }

    public Token makeKeyword(int id){
        Token token = makeToken();
        token.kind = TokenType.TKEYWORD;
        token.data.id = id;
        return token;
    }

    public Token makeNumber(String str){
        Token token = makeToken();
        token.kind = TokenType.TNUMBER;
        token.data.str.sval = str;
        return token;
    }

    public Token makeInvalid(char c){
        Token token = makeToken();
        token.kind = TokenType.TINVALID;
        token.data.str.c = (int)c;
        return token;
    }

    public Token makeChar(char c, int enc) {
        Token token = makeInvalid(c);
        token.data.str.enc = enc;
        return token;
    }

    public boolean isWhiteSpace(int c){
        return c == ' ' || c == '\t' || c == '\f';
    }
}
