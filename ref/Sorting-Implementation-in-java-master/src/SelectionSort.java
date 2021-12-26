
public class SelectionSort {

    private int[] num = {5,3,0,4,2,1,3,5};
    private int temp;

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

    public int smallestIndex(int[] num,int i1,int temp){
        int b=0;
        for(int i=i1;i<num.length;i++) {
                if(temp>num[i]){
                    temp=num[i];
                }
        }
        for(int i=0;i<num.length;i++){
            if(num[i] ==temp){
                b=i;
            }
        }
        return b;
    }


    public void Process(){

            for(int i=0;i<num.length-1;i++) {
                    int b=(smallestIndex(num,i,num[i]));
                    swap(num,i,b);
                    Step();
                }

    }
    public void display(){
        System.out.print("SelectionSort List: ");
        for(int i =0 ; i<num.length;i++){
            System.out.print(num[i]+" | ");
        }
    }
}
