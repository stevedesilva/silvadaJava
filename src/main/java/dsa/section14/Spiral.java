package dsa.section14;

public class Spiral {
    public int[][] create(int size) {
        int[][] spiral = new int[size][size];

        int rowStart = 0;
        int rowEnd = size;
        int columnStart = 0;
        int columnEnd = size;

        // (row-static)(column->) top left -> top right
        int count = 1;
        while (rowStart <= rowEnd || columnStart <= columnEnd) {
            for(int col=columnStart; col<=columnEnd-1; col++){
                spiral[rowStart][col] = count++;
            }
            rowStart = rowStart + 1;

            // (row-v)(column-static) top right -> bottom right
            for(int row=rowStart; row<=rowEnd-1; row++){
                spiral[row][columnEnd-1]= count++;
            }
            columnEnd = columnEnd - 1;

            // (row-static)(column<-) bottom right -> bottom left
            for(int col=columnEnd-1; col>=columnStart; col--){
                spiral[rowEnd-1][col] = count++;
            }
            rowEnd = rowEnd - 1;

            // (row-static)(column-^) bottom left -> top left
            for(int row=rowEnd-1; row>=rowStart; row--){
                spiral[row][columnStart] = count++;
            }
            columnStart = columnStart + 1;
        }


        return spiral;
    }
}
