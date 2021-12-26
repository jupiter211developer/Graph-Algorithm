public class MergeSort {

    private int[] num = {5,3,1,4,2,0};

   public void Step(){
        System.out.println("Sorted Process: ");
        for(int i1 =0 ; i1<num.length;i1++)
            System.out.print(num[i1]+" | ");
        System.out.println("\n");

    }

    public void Merge(int[] ar,int l,int m,int r){

        int i,j,k;

        int n1=m-l+1;
        int n2=r-m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(i=0;i<n1;i++){
            L[i]=num[l+i];
        }

        for(j=0;j<n2;j++){
            R[j]=num[m+j+1];
        }

        i=0;
        j=0;
        k=l;

        while(i<n1 && j<n2){

            if(L[i]<=R[j]){
                ar[k]=L[i];
                i++;
            }else{
                ar[k]=R[j];
                j++;
            }
            k++;

        }

        while(i<n1){

            ar[k]=L[i];
            i++;
            k++;

        }

        while(j<n2){

            ar[k]=R[j];
            j++;
            k++;

        }
        Step();
    }

    public void MergeSort(int l,int r){

       if(l<r){

           int m=l+(r-l)/2;
           MergeSort(l,m);
           MergeSort(m+1,r);

           Merge(num,l,m,r);
       }
    }

    public void display(){
        System.out.print("BubbleSorted List: ");
        for(int i =0 ; i<num.length;i++){
            System.out.print(num[i]+" | ");
        }
    }
}
