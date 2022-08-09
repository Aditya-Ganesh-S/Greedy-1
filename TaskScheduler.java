//Time: O(n)
//Space: O(1)
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        for(char task: tasks){
            int count = map.getOrDefault(task, 0);
            count++;
            maxFreq = Math.max(maxFreq, count);
            map.put(task, count);
        }
        for(char task: map.keySet()){
            if(map.get(task) == maxFreq){
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int availableSlots = partitions*(n-(maxCount-1));
        int pendingTasks = tasks.length - (maxCount*maxFreq);
        int idle = Math.max(0, availableSlots - pendingTasks);

        return tasks.length + idle;

    }
}
