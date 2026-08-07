class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> fleets = new Stack<>();
        List<Car> cars = new ArrayList<>(speed.length);
        for(int i = 0; i < speed.length; i++){
            cars.add(new Car(position[i], speed[i]));
        }

        cars.sort((a, b) -> Integer.compare(a.position, b.position));

        for(Car car : cars){
            double time = car.getTime(target);
            while(!fleets.isEmpty() && fleets.peek() <= time){
                fleets.pop();
            }

            fleets.push(time);
        }

        return fleets.size();   
    }
}

class Car {
    int position;
    int speed;

    public Car(int position, int speed){
        this.position = position;
        this.speed = speed;
    }

    public double getTime(int target){
        return (double) (target - this.position) / (double) this.speed;
    }
}
