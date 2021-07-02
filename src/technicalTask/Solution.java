package technicalTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Solution {

    private static final int[] ROW_CHANGER = new int[] {0, 0, -1, 1};
    private static final int[] COLUMN_CHANGER = new int[] {-1, 1, 0, 0};

    public String getResult(String matrixString, String word) {
        int matrixSize = (int) sqrt(matrixString.length());
        char[][] matrix = getMatrix(matrixString, matrixSize);
        for (int row = 0; row < matrixSize; row++) {
            for (int column = 0; column < matrixSize; column++) {
                List<Integer[]> result
                        = addCell(row, column, matrix, word, 0, new ArrayList<>());
                if (!result.isEmpty()) {
                    return result.stream()
                            .map(intArray -> "[%d,%d]".formatted(intArray[0], intArray[1]))
                            .collect(Collectors.joining("->"));
                }
            }
        }
        return "There is no this word";
    }

    private char[][] getMatrix(String matrixString, int matrixSize) {
        char[][] matrix = new char[matrixSize][matrixSize];
        var charArray = matrixString.toCharArray();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = charArray[i * matrixSize + j];
            }
        }
        return matrix;
    }

    private List<Integer[]> addCell(
            int row, int col, char[][] matrix, String word, int charIndex, List<Integer[]> path) {
        Integer[] node = new Integer[] {row, col};
        if (matrix[row][col] != word.charAt(charIndex) || path.contains(node)) {
            return Collections.EMPTY_LIST;
        }
        List<Integer[]> localResult = new ArrayList<>(path);
        localResult.add(node);
        if (localResult.size() == word.length()) {
            return localResult;
        }
        for (int i = 0; i < ROW_CHANGER.length; i++) {
            int newRow = row + ROW_CHANGER[i];
            int newCol = col + COLUMN_CHANGER[i];
            if (isValid(newRow, newCol, matrix.length)) {
                List<Integer[]> maybeResult
                        = addCell(newRow, newCol, matrix, word, charIndex + 1, localResult);
                if (!maybeResult.isEmpty()) {
                    return maybeResult;
                }
            }
        }
        return Collections.EMPTY_LIST;
    }

    private boolean isValid(int newRow, int newCol, int matrixSize) {
        return newRow >= 0 && newCol >= 0 && newRow < matrixSize && newCol < matrixSize;
    }
}
