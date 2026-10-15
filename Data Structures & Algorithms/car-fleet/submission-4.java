/*
we have 3 inpout aspec

1. target, position and speed

target is when the journey end in miles

position means where the car is starting from

and speed is what is the speed of the car

so if a car has high speed but it has a slow car infront of it then it can't surpass it so they reach the destination as a single fleet

if faster car is ahead then slower and they reach at separte time they are two fleet

e.g

t = 10

cars postion(sort)
0 1 -> 10 - 0 -> 10 / 1 -> 10 hour
1 2 -> 10 - 1 -> 9 / 2 -> 5 hour
4 2 -> 10 - 4 -> 6/2 -> 3 hour 
7 1 -> 10 - 7 -> 3 / 1 -> 3 hour

1

lst = 3 <= 3 -> 1
lst = 5 <= 1 -> false 1 + 1
lst = 10 <= 5 -> false 2 + 1


so I have to figure out that even if the rate is fast but its is behind slower vechicle doesn't matter


*/
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<double[]> cars = new ArrayList<>();
        int fleet = 1;

        for(int i = 0; i < position.length; i++){
            double rate = (double)(target - position[i]) / speed[i];
            cars.add(new double[]{position[i], rate});

        }

        cars.sort((a, b) -> Double.compare(b[0], a[0]));

        double recentFleet = cars.get(0)[1];
        for(int i = 1; i < cars.size(); i++){
            if(cars.get(i)[1] <= recentFleet) continue;

            recentFleet = cars.get(i)[1];
            fleet++;
        }

        return fleet;
    }
}
