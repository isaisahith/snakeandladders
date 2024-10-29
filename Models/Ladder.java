package Models;

public class Ladder extends  BoardEntity {
    private EntityType entityType;
    public  Ladder(int start, int end){
        super(start,end);
        this.entityType = EntityType.LADDER;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public  void printMessage(){
        System.out.println("Yay.. you have encountered ladder");
    }


    public void printBoardEnity(){
        System.out.print(" L("+this.getEnd()+")");
    }

}
