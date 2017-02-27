enum State{Unvisited, Visiting, Visited}

public boolean search(Graph g, Node start, Node end){

    if(start == end) return true;
    Queue<Node> queue = new LinkedList<Node>();
    
    for(Node n : g.getNodes()){
        n.state = State.Unvisited;
    }

    queue.add(start);
    while(queue.size() > 0){
        Node temp = queue.poll();
        for(Node n : temp.getAdjacent()){
            if(n.state == State.Unvisited){
                if(n == end) return true;
                else{
                    n.state = State.Visiting;
                    queue.add(n);
                }
            }
        }
        temp.state = State.Visited;
    }
    return false;
}