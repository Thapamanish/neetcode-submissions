/*

use map to store departure: destination

then start from the start and once find the leaf start pushing in the final array we do this to ensure we use all the tickets

Since we need lexographically sorted ticket we use priority queue

TC -> O(nLogk)
SC -> O(n)

*/


class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket: tickets){
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        List<String> path = new LinkedList<>();

        traversePath("JFK", map, path);

        return path;
    }

    private void traversePath(String start, Map<String, PriorityQueue<String>> map, List<String> path){
        PriorityQueue<String> dest = map.get(start);
        if(dest == null || dest.isEmpty()){
            path.addFirst(start);
            return;
        }

        while(!dest.isEmpty()){
            String newStart = dest.poll();
            traversePath(newStart, map, path);
           
        }
         path.addFirst(start);
    }
}
