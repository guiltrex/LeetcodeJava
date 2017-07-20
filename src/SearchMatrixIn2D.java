/**
 * Created by jniu on 7/13/17.
 */
//Consider the matrix as a sorted array 73.21%
public class SearchMatrixIn2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length ==0 || matrix[0]==null || matrix[0].length==0) return false;
        int h = matrix.length, w=matrix[0].length;
        int i = 0, j=h*w-1, mid;
        int r, c;
        while(i<=j){
            mid = i+(j-i)/2;
            r = mid/w;
            c = mid%w;
            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c] < target){
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return false;
    }
}

//2D binary search
public class SearchMatrixIn2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length ==0 || matrix[0]==null || matrix[0].length==0) return false;
        int i = 0, j=matrix.length-1, mid;
        int width = matrix[0].length;
        while(i<=j){
            mid = i + (j-i)/2;
            if(target == matrix[mid][0] || target == matrix[mid][width-1] ) return true;
            if(target > matrix[mid][0] && target < matrix[mid][width-1]){
                i = mid;
                j = mid;
                break;
            } else if(target <matrix[mid][0]) {
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        if(i>matrix.length-1 || j<0) return false;
        int row = i;
        i = 0;
        j=matrix[row].length-1;
        while(i<=j){
            mid = i + (j-i)/2;
            if(target == matrix[row][mid]) return true;
            if(target < matrix[row][mid]){
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return false;
    }
}