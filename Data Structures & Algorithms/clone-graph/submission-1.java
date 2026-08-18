/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Map<Integer, Node> visited = new HashMap<>();

        Node result = new Node(node.val);
        dfs(node, result, visited);
        return result;
    }

    private void dfs(Node node, Node curr, Map<Integer, Node> visited){
        if(node == null) return;

        if(visited.containsKey(curr.val)) return;
        visited.put(curr.val, curr);

        for(Node neighbor : node.neighbors){
            Node newN = visited.containsKey(neighbor.val) ? visited.get(neighbor.val) : new Node(neighbor.val);
            curr.neighbors.add(newN);
            dfs(neighbor, newN, visited);
        }
    }
}