public class MinHeap{

    int[] heap;
    int maxSize;
    int curSize;

    public MinHeap(int size){
        maxSize = size;
        curSize = 0;
        heap = new int[maxSize];
        heap[0] = Integer.MIN_VALUE;
    }

    public int leftChild(int pos){
        return 2 * pos;
    }

    public int rightChild(int pos){
        return 2 * pos + 1;
    }

    public int parent(int pos){
        return pos / 2;
    }

    public boolean isLeaf(int pos){
        return (pos > curSize / 2) && (pos <= curSize);
    }

    public void swap(int p1, int p2){
        int temp = heap[p1];
        heap[p1] = heap[p2];
        heap[p2] = temp;
    }

    public void insertNode(int val){
        curSize++;
        heap[curSize] = val;
        int cur = curSize;
        while(cur <= curSize && heap[cur] < heap[parent(cur)]){
            swap(cur, parent(cur));
            cur = parent(cur);
        }
    }

    public void removeMin(){
        swap(0, curSize);
        curSize--;
        pushdown(1);
    }

    public void pushdown(int pos){
        while(!isLeaf(pos)){
            int temp = leftChild(pos);
            if(temp <= curSize && heap[temp] < heap[temp + 1]) temp += 1;
            if(heap[temp] < heap[pos]){
                swap(temp, pos);
                pos = temp;
            }
            else return;
        }
    }

    public void print(){
        for(int i = 1; i < curSize; i++){
            System.out.println(heap[i]);
        }
        System.out.println();
    }
    public static void main(String[] args){
        MinHeap test = new MinHeap(10);
        test.insertNode(1);
        test.insertNode(2);
        test.insertNode(3);
        test.insertNode(-4);
        test.insertNode(5);
        test.insertNode(-6);

        //test.print();
        
        test.insertNode(100);

        test.insertNode(-100);

        //test.print();

        test.insertNode(-1000);

        test.print();

        test.removeMin();
        test.removeMin();
        test.removeMin();
        test.removeMin();
        test.print();
    }
}