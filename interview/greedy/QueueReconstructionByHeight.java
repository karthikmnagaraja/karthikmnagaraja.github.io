package interview.greedy;
/**
Step 1. Sort descending by height and ascending by number of people infron of him.
Step 2: Insertion Sort.
*/
public class QueueReconstructionByHeight{
	
	public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0|| people[0].length==0) return people;
         Arrays.sort(people, (a, b) -> ((b[0] == a[0]) ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] p:people)
            res.add(p[1], p);
       
        return res.toArray(new int[people.length][]);
    }
}