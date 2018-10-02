package interview.greedy;
class ContainerWithMostWater {
    public int maxArea(int[] a) {
        if(a.length==0) return 0;
        int left=0,right=a.length-1, res=0;
        while(left<right){
            res=Math.max(Math.min(a[right],a[left])*(right-left),res);
            if(a[right]<a[left]) right--;
            else left++;
        }
        return res;
    }
    
}