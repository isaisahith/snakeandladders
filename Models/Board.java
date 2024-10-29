package Models;

import java.util.HashMap;

public class Board {
    private int dimension;
    private int cellCount;
    private HashMap<Integer, BoardEntity> boardEntityHashMap = new HashMap<>();

    public Board(int dimension){
        this.cellCount = dimension*dimension;
        this.dimension = dimension;
        addBoardEntities();
    }

    public HashMap<Integer, BoardEntity> getBoardEntityHashMap() {
        return boardEntityHashMap;
    }

    public int getCellCount() {
        return cellCount;
    }

    public int getDimension() {
        return dimension;
    }

    public void printBoard(){
        int tempCellCount = cellCount;
        int index;
        for (int row = 0; row < dimension; row++) {
            // Print left to right if even row, right to left if odd
            if (row % 2 == 0) {
                for (int col = 0; col < dimension; col++) {
                    index = tempCellCount;

                    System.out.printf("%4d", tempCellCount);

                    if (boardEntityHashMap.containsKey(index)) {
                        BoardEntity entity = boardEntityHashMap.get(index);
                        entity.printBoardEnity();
                    }

                    tempCellCount-=1;
                }
            } else {
                int temp = tempCellCount - dimension+ 1;
                for (int col = 0; col < dimension; col++) {

                    System.out.printf("%4d", temp);

                    if (boardEntityHashMap.containsKey(temp)) {
                        BoardEntity entity = boardEntityHashMap.get(temp);
                        entity.printBoardEnity();
                    }

                    temp+=1;
                }
                tempCellCount -= dimension;
            }
            System.out.println(); // New line for each row
        }
    }

    public void addBoardEntities(){
        //Snakes
        for(int i=0; i<dimension; i++){
            int max = getCellCount()-1;
            int min = 2;

            int start = (int)Math.floor((Math.random()*(max-min-1)+min));

            max = start-1;

            int end = (int)Math.floor((Math.random()*(max-min-1)+min));

            if(!boardEntityHashMap.containsKey(start)){
                boardEntityHashMap.put(start, new Snake(start, end));
            }


            max = 99;

            end = (int)Math.floor((Math.random()*(max-min-1)+min));

            max = end-1;
            start = (int)Math.floor((Math.random()*(max-min-1)+min));

            if(!boardEntityHashMap.containsKey(start)){
                boardEntityHashMap.put(start, new Ladder(start, end));
            }



        }
    }


}
