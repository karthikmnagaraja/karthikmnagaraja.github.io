package interview.sorting;
public class InsertInterval{
public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //Collections.sort(intervals,(a,b)->a.start-b.start);
        int start=newInterval.start;
        int end=newInterval.end;
        List<Interval> result= new ArrayList<Interval>();
        for(Interval i:intervals){
            if(end<i.start){
                result.add(new Interval(start,end));
                start=i.start;
                end=i.end;
            }else if(start>i.end)
            {
                 result.add(i);
                
            }else{
               start=Math.min(start,i.start);
                end=Math.max(end,i.end);
            }
            
            
        }
        result.add(new Interval(start,end));
        return result;
        
    }
}