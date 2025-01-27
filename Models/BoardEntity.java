package Models;

public abstract class BoardEntity {
    private int start;
    private int end;
    public BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }


    public void printBoardEnity(){
        System.out.print(" E("+this.getEnd()+")");
    }

    public abstract void printMessage();

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

}
