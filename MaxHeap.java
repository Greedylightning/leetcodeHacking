public class Maxheap{

    int[] heap;
    int size;
    int maxSize;

    public Maxheap(int size){
        this.maxSize = size + 1;
        heap = new int[maxSize];
        size = 0;
        heap[0] = Integer.MAX_VALUE;
    }

    public int leftChild(int pos){
        return 2 * pos;
    }

    public int rightChild(){
        return 2 * pos + 1;
    }

    public int isLeaf(int pos){
        return (pos > size / 2) && (pos <= size);
    }

    public int parent(int pos){
        return pos / 2;
    }

    public void swap(int p1, int p2){
        int temp = heap[p1];
        heap[p1] = heap[p2];
        heap[p2] = temp;
    }

    public insert(int val){
        size++;
        heap[size] = val;
        int current = size;
        while(current <= size && heap[current] > heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void removeMax(){
        swap(1, size);
        size--;
        pushdown(1);
    }

    public void pushdown(int pos){
        int temp;
        while(!isLeaf(pos)){
            temp = leftChild(pos);
            if(temp <= size && heap[temp] < heap[temp + 1]) temp += 1;
            if(heap[pos] < heap[temp]){
                swap(pos, temp);
                pos = temp;
            }
            else return ;
        }
    }
}