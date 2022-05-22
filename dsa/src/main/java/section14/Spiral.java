package section14;

public class Spiral {
    public int[][] create(int size) {
        int[][] spiral = new int[size][size];

        int rowStart = 0;
        int rowEnd = size - 1;
        int columnStart = 0;
        int columnEnd = size - 1;

        int count = 1;
        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            // (row-static)(column->) TOP ROW: top left -> top right
            for(int col=columnStart; col<=columnEnd; col++){
                spiral[rowStart][col] = count++;
            }
            rowStart = rowStart + 1;

            // (row-v)(column-static) RIGHT COLUMN: top right -> bottom right
            for(int row=rowStart; row<=rowEnd; row++){
                spiral[row][columnEnd]= count++;
            }
            columnEnd = columnEnd - 1;

            // (row-static)(column<-) BOTTOM ROW: bottom right -> bottom left
            for(int col=columnEnd; col>=columnStart; col--){
                spiral[rowEnd][col] = count++;
            }
            rowEnd = rowEnd - 1;

            // (row-static)(column-^) LEFT COLUMN: bottom left -> top left
            for(int row=rowEnd; row>=rowStart; row--){
                spiral[row][columnStart] = count++;
            }
            columnStart = columnStart + 1;
        }

        return spiral;
    }
}
