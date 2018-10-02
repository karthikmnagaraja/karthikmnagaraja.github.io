package interview.math;

class Sqrt {
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x<4) return 1;
        int left=1,right=x;
        while(true){
            int mid=left+((right-left)/2);
            if(mid<=x/mid &&(mid+1>x/(mid+1))) return mid;
            else if(mid>x/mid) right=mid-1;
            else left=mid+1;
        }
       
     
        
    }
}