public class SpecialPositionsInMatrix {

    public static void main(String[] args){
        int[][] matrix = {{1,0,0}, {0,0,1}, {1,0,0}};
//        int[][] matrix = {{1,0,0}, {0,0,1}, {1,0,1}};
//        int[][] matrix = {{1,0,0}, {0,1,0}, {0,0,1}};
//        int[][] matrix = {{0,0}, {0,0}, {1, 0}};
        int noOfRows = matrix.length;
        int noOfColumns = matrix[0].length;
        boolean isSpecialPositionInRow, isSpecialPositionInColumn;
        int noOfSpecialPositions = 0;

        for(int i=0; i<noOfRows; i++){
            for(int j=0; j< noOfColumns; j++) {
                if(matrix[i][j] == 1){
                    isSpecialPositionInColumn = false;
                    isSpecialPositionInRow = checkRow(matrix, i, noOfColumns);
                    if(isSpecialPositionInRow){
                        isSpecialPositionInColumn =  checkColumn(matrix, j, noOfRows);
                    }
                    if(isSpecialPositionInRow && isSpecialPositionInColumn) {
                        noOfSpecialPositions++;
                    }
                }
            }
        }
        System.out.println("No of special positions : "+noOfSpecialPositions);
    }

    private static boolean checkRow(int[][] matrix, int rowIndex, int noOfColumns) {
        int  noOfOccurrencesOfOne = 0;
        for(int colIndex=0; colIndex< noOfColumns; colIndex++){
            if( matrix[rowIndex][colIndex] == 1) {
                noOfOccurrencesOfOne++;
            }
        }
        return noOfOccurrencesOfOne==1;
    }

    private static boolean checkColumn(int[][] matrix, int colIndex, int noOfRows) {
        int noOfOccurrencesOfOne = 0;
        for(int rowIndex=0; rowIndex< noOfRows; rowIndex++){
            if( matrix[rowIndex][colIndex] == 1) {
                noOfOccurrencesOfOne++;
            }
        }
        return noOfOccurrencesOfOne==1;
    }


}
