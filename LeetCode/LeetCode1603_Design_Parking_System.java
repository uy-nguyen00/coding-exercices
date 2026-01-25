class LeetCode1603_Design_Parking_System {

    private int[] slots = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        this.slots = new int[] { big, medium, small };
    }

    public boolean addCar(int carType) {
        return this.slots[carType - 1]-- > 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
