class Task {
    char name;
    int freq;
    int availableAt;

    public Task(char name, int freq, int availableAt){
        this.name = name;
        this.freq = freq;
        this.availableAt = availableAt;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int currCycle = 0;
        int cycles = 0;
        int[] freq = new int[26];
        PriorityQueue<Task> activeTasks = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.freq, a.freq)
        );

        PriorityQueue<Task> readyTasks = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.availableAt, b.availableAt)
        );

        for(Character task : tasks){
            freq[task - 'A']++;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] == 0){
                // this task is not a part of system
                continue;
            }

            activeTasks.add(new Task((char)('A' + i), freq[i], 0));
        }

        while(!activeTasks.isEmpty() || !readyTasks.isEmpty()){
            if(!activeTasks.isEmpty()){
                Task task = activeTasks.poll();
                // execution logic of task

                task.freq = task.freq - 1;

                if(task.freq > 0){
                    // sent for cooldown
                    task.availableAt = currCycle + n;
                    readyTasks.add(task);
                }
            }

            while(!readyTasks.isEmpty() && readyTasks.peek().availableAt <= currCycle){
                // submit ready tasks into execution queue
                activeTasks.add(readyTasks.poll());
            }

            cycles++;
            currCycle++;
        }

        // number of current cycles passed
        return currCycle;
    }
}








