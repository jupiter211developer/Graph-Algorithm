public class InsertionSort {

    private int[] num = {5,3,6,4,2,1};

    public void swap(int[] ar,int a,int b){
        int temp= ar[a];
        ar[a]=ar[b];
        ar[b]=temp;
    }

    public void Step(){

        System.out.print("Sorted Process: "+" | ");
        for(int i=0;i<num.length;i++) {
            System.out.print(num[i] + " | ");
        }
        System.out.println("\n");
    }

    public void Process(){

        for(int i=1;i<num.length;i++){
            for(int j=i;j>0;j--){
                if(num[j]<num[j-1]){
                    swap(num,j,j-1);
                }

            }
            Step();
         }
        }

    public void display(){
        System.out.print("InsertionSort List: ");
        for(int i =0 ; i<num.length;i++){
            System.out.print(num[i]+" | ");
        }
    }
}
