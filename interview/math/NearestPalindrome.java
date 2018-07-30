package interview.string;


/**
Case 1: 99
Case 2: 101
Case 3: 125
Case 4: 531

mirror(127)-> 121
mirror(987)-> 989

2 things to note:
1.pre will be calculated by mirror of (num/pow)*pow -1; why -1  why not pow 
example:
19-> ((19/10)*10) -10 will be 0 which is not right thats why it wont work
19-> ((19/10)*10) -1 will be 9

2.next will be calculated by mirror of ((num/pow)*pow +pow);
*/
public class NearestPalindrome{
public String nearestPalindromic(String n) {
        if(n.length()==0) return "0";
        
        Long order=(long)Math.pow(10,n.length()/2);

        Long num=Long.valueOf(n);
         Long temp=((num/order)*order);
        Long cur= mirror(n);
        Long pre= mirror(String.valueOf(temp-1));
         Long next= mirror(String.valueOf(temp+order));
       
        if(num<cur){
           next=Math.min(cur,next);
        }else if(num>cur){
                pre=Math.max(cur,pre);
        }

        return String.valueOf((num-pre<=next-num)?pre:next);
        
    }
    
    public Long mirror(String s){
        char[] a=s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j){
            
            a[j]=a[i];
            
            i++;
            j--;
        }
        return Long.valueOf(new String(a));
        
    }
    public static void main(String[] args) {
    	
    }
}