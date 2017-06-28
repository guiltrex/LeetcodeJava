//Write DFS in the future
/**
 * Created by jniu on 6/27/17.
 */
//BFS 4%
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length == 0 || grid[0]==null) return 0;
        int num = 0;
        boolean[][] set = new boolean[grid.length][grid[0].length];
        Queue<int[]> dfs = new ArrayDeque<int[]>();
        for(int i = 0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                int[] cord = {i, j};
                if(grid[i][j]=='1' && !set[i][j]){
                    num++;
                    dfs.add(cord);
                    set[i][j] = true;
                    while(!dfs.isEmpty()){
                        int[] cur = dfs.remove();
                        int ci = cur[0], bi=ci+1, ai=ci-1, cj = cur[1], rj = cj+1, lj = cj - 1;
                        List<int[]> sur = new ArrayList<int[]>();
                        if(bi!=grid.length && grid[bi][cj] == '1' && !set[bi][cj]) {
                            sur.add(new int[]{bi, cj});
                        }
                        if(rj!=grid[ci].length && grid[ci][rj] == '1' && !set[ci][rj]) {
                            sur.add(new int[]{ci, rj});
                        }
                        if(ai!=-1 && grid[ai][cj] == '1' && !set[ai][cj]) {
                            sur.add(new int[]{ai, cj});
                        }
                        if(lj!=-1 && grid[ci][lj] == '1' && !set[ci][lj]) {
                            sur.add(new int[]{ci, lj});
                        }
                        for(int[] nc: sur){
                            dfs.add(nc);
                            set[nc[0]][nc[1]]=true;
                        }
                    }
                }
            }
        }
        return num;
    }
}

////The solution below doesn't work since array1.equals(array2) only compares the address, rather than the elements.
////To compare arrays element by element, we need to use Arrays.equals(arr1, arr2)
//public class NumberOfIslands {
//    public int numIslands(char[][] grid) {
//        if(grid==null) return 0;
//        int num = 0;
//        Set<int[]> set = new HashSet<int[]>();
//        Queue<int[]> dfs = new ArrayDeque<int[]>();
//        for(int i = 0; i<grid.length; i++){
//            for(int j=0; j<grid[i].length; j++){
//                int[] cord = {i, j};
//                if(grid[i][j]=='1' && !set.contains(cord)){
//                    num++;
//                    dfs.add(cord);
//                    set.add(cord);
//                    while(!dfs.isEmpty()){
//                        int[] cur = dfs.remove();
//                        int ci = cur[0], bi=ci+1, ai=ci-1, cj = cur[1], rj = cj+1, lj = cj - 1;
//                        List<int[]> sur = new ArrayList<int[]>();
//                        if(bi!=grid.length && grid[bi][cj] == '1') {
//                            sur.add(new int[]{bi, cj});
//                        }
//                        if(rj!=grid[ci].length && grid[ci][rj] == '1') {
//                            sur.add(new int[]{ci, rj});
//                        }
//                        if(ai!=-1 && grid[ai][cj] == '1') {
//                            sur.add(new int[]{ai, cj});
//                        }
//                        if(lj!=-1 && grid[ci][lj] == '1') {
//                            sur.add(new int[]{ci, lj});
//                        }
//                        for(int[] nc: sur){
//                            if(!set.contains(nc)) {
//                                dfs.add(nc);
//                                set.add(nc);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return num;
//    }
//}