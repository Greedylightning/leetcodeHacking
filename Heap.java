public class HeapMin{

    private int[] heap;
    private int maxsize;
    private int size;

    public HeapMin(int size){
        this.size = size;
        size = 0;
        heap[0] = Integer.MIN_VALUE;
    }

    private int leftchild(int pos){
        return 2 * pos;
    }
  
    private int rightchild(int pos){
        return 2 * pos + 1;
    }

    private int parent(int pos){
        return pos / 2;
    }

    private boolean isleaf(int pos){
        return(pos > size / 2) && (pos <= size);
    }


    public void swap(int pos1, int pos2{
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }   
    public int insert(int element){
        size++;
        heap[size] = element;
        int current = size;
        while(current <= size && heap[current] < heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int removeMin(){
        swap(1,size);
        size--;
        pushdown(1);
        reuturn heap[size + 1];
    }

    public void pushdown(int pos){
        int temp;
        while(isleaf(pos)){
            temp = leftchild(pos);
            if(temp <= size && heap[temp] > heap[temp + 1]) temp = temp + 1;
            if(heap[temp] > heap[pos]) return ;
            swap(temp, pos);
            pos = temp;
        }
            
    }
        

}