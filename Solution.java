class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = convert(edges,V);
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];
        for(int i=0;i < V ; i++){
            if(!visited[i] && DFS(i,adjList,visited,path)){
                return true;
            }
        }
        return false;
    }
    
    public boolean DFS(int node ,ArrayList<ArrayList<Integer>> adjList,
    boolean[] visited,boolean[] path){
        if(path[node]){return true;}
        if(visited[node]){return false;}
        
        visited[node] = true;
        path[node]=true;
        
        for(Integer adj : adjList.get(node)){
            if(DFS(adj,adjList,visited,path)){
                return true;
            }
        }
        path[node]=false;
        return false;
        
    }
    
    public ArrayList<ArrayList<Integer>> convert(int[][] edges,int V){
        ArrayList<ArrayList<Integer>>result = new ArrayList<>();
        for(int i=0; i < V ;i++){
            result.add(new ArrayList<>());
        }
        
        for(int[] edge: edges ){
            int from = edge[0];
            int to = edge[1];
            result.get(from).add(to);   
        }
        return result;
        
    }
}
