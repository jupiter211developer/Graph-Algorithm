public class BubbleSort {

    private int[] num = {5,3,1,4,2,0};

    public void swap(int[] ar,int a,int b){
       int temp= ar[a];
        ar[a]=ar[b];
        ar[b]=temp;
    }

    public void Step(){
        System.out.println("Sorted Process: ");
        for(int i1 =0 ; i1<num.length;i1++)
            System.out.print(num[i1]+" | ");
        System.out.println("\n");

    }

    public void Process(){

        for(int m=num.length-1;m>=0;m--){
            for(int i=0;i<num.length-1;i++) {

                int k=i+1;
                if(num[i]>num[k]){
                    swap(num,i,k);
                }
            }
            Step();
        }

    }
    public void display(){
        System.out.print("BubbleSorted List: ");
        for(int i =0 ; i<num.length;i++){
            System.out.print(num[i]+" | ");
        }
    }
}
