/*
we have list of list of string

s1 is departure
s2 is arraival


final output is a string reconstructin the path


can we make a map? where
key -> arrival
value -> departure

it would work for the non duplicate values what if there is duplicate.


while loop for the List in jfk



*/

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> path = new HashMap<>();

        for(List<String> flight: tickets){
            String start = flight.get(0);
            String end = flight.get(1);

            path.computeIfAbsent(start, k -> new PriorityQueue<>()).offer(end);
        }

        List<String> route = new LinkedList<>();

        visit("JFK", path, route);

        return route;
    }

    private void visit(String departure, Map<String, PriorityQueue<String>> path, List<String> route){
       PriorityQueue<String> destination = path.get(departure);

       while(destination != null && destination.size() > 0){
        visit(destination.poll(), path, route);
       }
       route.addFirst(departure);
    }
}
