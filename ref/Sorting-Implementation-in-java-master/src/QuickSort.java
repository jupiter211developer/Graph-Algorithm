public class QuickSort {

    private int[] num={3,6,1,4,2,5};
    private int m,n;

    public void swap(int[] ar,int a,int b){
        int temp=ar[a];
        ar[a]=ar[b];
        ar[b]=temp;
    }

    public void Step(){

        System.out.println("Sorted Process: ");
        for(int i =0 ; i<num.length;i++)
            System.out.print(num[i]+" | ");
        System.out.println("\n");
    }

    public int Partition(int[] ar,int low, int high){

        int pivot= num[high];
        int i=low-1;
        for(int j=low;j<num.length;j++){
                if(num[j]<pivot){
                    i++;
                    swap(num,i,j);
                }
                Step();
        }
        swap(num,i+1,high);
        return i+1;
    }

    public void Process(int low, int high){

        if(low<high){
            int pi = Partition(num,low,high);
            Process(low,pi-1);
            Process(pi+1,high);
        }
    }

    public void display(){
        System.out.print("BubbleSorted List: ");
        for(int i =0 ; i<num.length;i++){
            System.out.print(num[i]+" | ");
        }
    }
}
