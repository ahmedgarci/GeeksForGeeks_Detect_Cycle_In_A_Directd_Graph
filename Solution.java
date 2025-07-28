class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = convert(edges,V);
        boolean[] visited = new boolean[V];
        for(int i=0; i< V ; i++){
            if(!visited[i] && DFS(i,adjList,visited,new ArrayList<>())){
                return true;
            }
        }
        return false;
    }
    
    public boolean DFS(int v ,  ArrayList<ArrayList<Integer>> adjList,
    boolean[] visited,ArrayList<Integer> path){
        visited[v] = true;
        path.add(v);
        for(int neighbor : adjList.get(v)){
            if(!visited[neighbor] && DFS(neighbor,adjList,visited,path)){
                return true;
            }else if (path.contains(neighbor)) {
                return true;
            }
        }
        path.remove(path.size()-1);
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