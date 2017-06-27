//More methods using transpose & horizontal/vertical reflection

/**
 * Created by jniu on 6/26/17.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int k=0, l=matrix.length-1;
        int tmp;
        while(k<l){
            for(int i = 0; i<l-k; i++){
                tmp = matrix[k][k+i];
                matrix[k][k+i] = matrix[l-i][k];
                matrix[l-i][k] = matrix[l][l-i];
                matrix[l][l-i] = matrix[k+i][l];
                matrix[k+i][l]= tmp;
            }
            l--;
            k++;
        }
    }
}