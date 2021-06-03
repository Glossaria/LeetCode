import java.util.Arrays;
import java.util.List;

public class CloudFrontCaching {

    public static int connectedSum(int n, List<String> edges) {
        if(n < 2) return n;
        int[] parent = new int[n + 1];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(String d : edges){
            String[] node = d.split(" ");
            int node1 = Integer.parseInt(node[0]) ;
            int node2 = Integer.parseInt(node[1]) ;
            union(parent, node1, node2);
        }

        parent = Arrays.copyOf(parent, n);
        Arrays.sort(parent);

        int res = 0;
        int curSum = 1;
        int pre = parent[0];

        for( int i = 1; i < n; i++){
            if(pre == parent[i]){
                curSum++;
            }else{
                res += Math.ceil(Math.sqrt(curSum));
                curSum = 1;
                pre = parent[i];
            }
        }
        res += Math.ceil(Math.sqrt(curSum));
        return res;
    }

    private static void union(int[] parent, int i, int j){
        parent[find(parent, j)] = find(parent, i);
    }

    private static int find(int[] parent, int i){
        if(parent[i] != i){
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}
