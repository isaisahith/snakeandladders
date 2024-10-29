package Models;

public class Snake extends  BoardEntity{
    private EntityType entityType;

    public Snake(int start, int end) {
        super(start, end);
        this.entityType = EntityType.SNAKE;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public  void printMessage(){
        System.out.println("Oops.. you have encountered snake");
    }


    public void printBoardEnity(){
        System.out.print(" S("+this.getEnd()+")");
    }
}
