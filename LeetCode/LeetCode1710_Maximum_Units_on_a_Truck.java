class Solution {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Use an array to count boxes for each unit value (1 to 1000)
        // Index represents unitsPerBox, value represents total numberOfBoxes with that unit value.
        int[] boxesPerUnitValue = new int[1001]; // Indices 0-1000

        // Count the total number of boxes available for each unit value
        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int unitsPerBox = boxType[1];
            boxesPerUnitValue[unitsPerBox] += numberOfBoxes;
        }

        int totalUnits = 0;
        int remainingTruckSize = truckSize;

        // Iterate downwards from the highest possible units per box (1000)
        for (int units = 1000; units >= 1; units--) {
            // If truck is full, no need to check further
            if (remainingTruckSize <= 0) {
                break;
            }

            // Check if there are boxes with the current 'units' value
            if (boxesPerUnitValue[units] > 0) {
                // Determine how many boxes of this type we can actually take
                int boxesToTake = Math.min(
                    boxesPerUnitValue[units],
                    remainingTruckSize
                );

                // Add the units from these boxes to the total
                totalUnits += boxesToTake * units;

                // Decrease the remaining truck capacity
                remainingTruckSize -= boxesToTake;
            }
        }

        return totalUnits;
    }
}
