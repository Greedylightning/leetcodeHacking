public class HeapMax{

    int[] heap;
    int maxsize;
    int size;

    public HeapMax(int max){
        maxsize = max;
        this.heap = new int[maxsize];
        heap[0] = Integer.MAX_VALUE;
    }

    private int leftchild(int pos){
        return pos * 2;
    }

    private int rightchild(int pos){
        return pos * 2 + 1;
    }

    private int parent(int pos){
        return pos / 2;
    }

    private boolean isleaf(int pos){
        return (pos > size / 2) && (pos <= size);
    }

    public void swap(int pos1, int pos2){
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    public void insert(int element){
        this.size++;
        heap[size] = element;
        int current = size;
        while(heap[current] > heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);  
        }
    }

    public int removeMax(){
        swap(1,size);
        this.size--;
        if(size != 0)pushdown(1);
        return heap[size + 1];
    }

    private void pushdown(int pos){
        int temp;
        while(!isleaf(pos)){
            temp = leftchild(pos);
            if(temp <= size && heap[temp] < heap[temp + 1]) temp = temp + 1;
            if(heap[pos] > heap[temp]) return;
            swap(pos,temp);
            pos = temp;
        }
    }

}