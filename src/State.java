public class State {
    FILES f;
    public class Pos {
        public int line;
        public int column;
    }
    public Pos pos;
    public void setFILES(FILES f){
        this.f = f;
    }
    public void mark(){
        assert(this.f != null);
        this.pos = getPos(0);
    }
    public Pos getPos(int delta){
        Pos pos = new Pos();
        pos.line = f.currentFile().line;
        pos.column = f.currentFile().column + delta;
        return pos;
    }
}
