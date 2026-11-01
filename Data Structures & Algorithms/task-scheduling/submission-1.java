/*

X X Y Y

n = 2

I have to wait 2 sec before starting the same task
X _ _ X Y _ _ Y

I have to find minimum to do it

X Y _ X Y

5 sec to complete it.

need to track last 

and we should take care of task which come most


e.g 2

A A A B C

A : 3
B : 1
C: 1

pq = A:3 B:1 C:1

n = 1 A

pq = A : 2

1 
2

quee = A:2
we will not put it back in the pq until the time we use is curr - used time > n


*/

class Solution {
    static class Entry {
        Character task;
        int count;
        int time;

        public Entry(Character task, int count, int time) {
            this.task = task;
            this.count = count;
            this.time = time;
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));

        HashMap<Character, Integer> freq = new HashMap<>();

        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        Deque<Entry> q = new ArrayDeque<>();

        int totalTime = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {pq.offer(new Entry(entry.getKey(), entry.getValue(), 0));
        }

         while (!pq.isEmpty() || !q.isEmpty() ) {
            while(!q.isEmpty() && q.peek().time <= totalTime){
                pq.offer(q.poll());
            }

            if(!pq.isEmpty()) {
                Entry curr = pq.poll();

                if (curr.count - 1 != 0)
                    q.offer(new Entry(curr.task, curr.count - 1, totalTime + n +   1));
            }
            totalTime++;

        }


        return totalTime;


    }
}
