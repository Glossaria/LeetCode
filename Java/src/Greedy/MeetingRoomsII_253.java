class Solution {

    public int minMeetingRooms(int[][] array) {
        
        java.util.Arrays.sort(array, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                
                if(a[0] == b[0]){
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        Queue<Integer> q = new PriorityQueue<>();
    	q.offer(array[0][1]);
    	for(int i = 1; i < array.length; ++i)
    	{
    		if(array[i][0] >= q.peek())
    		{
    			q.poll();
    		}
    		q.offer(array[i][1]);
    	}
    	return q.size();
        
    }
}