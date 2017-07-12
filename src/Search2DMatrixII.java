//Do again for O(m+n) solution
/**
 * Created by jniu on 7/4/17.
 */
//Iterative 82% (O(m+n))
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0 || matrix[0]==null || matrix[0].length ==0) return false;
        int r = matrix.length-1, c = 0;
        while(r>=0 && c <= matrix[0].length-1) {
            if(target == matrix[r][c]){
                return true;
            } else if(target > matrix[r][c]){
                c++;
            } else {
                r--;
            }
        }
        return false;
    }
}

//recursive 7% O(mn)
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0 || matrix[0]==null || matrix[0].length ==0) return false;
        return helper(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
    }

    private boolean helper(int[][]matrix, int target, int rs, int re, int cs, int ce){
        if(rs > re || cs > ce) return false;
        int rmid = rs + (re-rs)/2;
        int cmid = cs + (ce-cs)/2;
        if(matrix[rmid][cmid]==target){
            return true;
        } else if(matrix[rmid][cmid]>target){
            return helper(matrix, target, rs, rmid-1, cs, cmid-1) || helper(matrix, target, rs, rmid-1, cmid, ce) || helper(matrix, target, rmid, re, cs, cmid-1);
        } else {
            return helper(matrix, target, rs, rmid-1, cmid+1, ce) || helper(matrix, target, rmid, re, cmid+1, ce) || helper(matrix, target, rmid+1, re, cs, cmid);
        }
    }
}