package thuat_toan.ve_hinh_thoi_bang_so;

public class thuat_toan_13sep {
    public static void main(String[] args) {
        int[] array = {1,2,3,3};
        boolean result = solution(array);
        System.out.println(result);
    }
    public static boolean solution(int[] a) {
        boolean check=false;
        if(a.length>10000&a.length<=2){
            check = false;

        }else{
            for(int i=0; i<a.length;i++){
                if(a[i]==0){
                    check=false;
                    break;
                }
            }
            for(int i=1; i<a.length-1; i++){
                int sum1=0;
                int sum2=0;
                for(int j=0;j<i;j++){
                    sum1+= a[j];
                }
                for(int k=a.length-1; k>i;k--){
                    sum2+=a[k];
                }
                System.out.println(sum1 +","+sum2);
                if(sum1==sum2){
                    check = true;
                    break;
                }
            }
        }

        if(check==true){
            return true;
        }else{
            return false;
        }
    }


}
