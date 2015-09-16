/**
 * Created by drandhaw on 9/16/15.
 */
public class JumpFrogJump {

    public int solution(int[] A, int X, int D) {
        // write your code in Java SE 8
        return tmpSolution(A, X, D);
    }

    /**
     * a helper function w/ better names for convenience.
     *
     * @param arrLeaves
     * @param totalDistance
     * @param jumpDistance
     * @return
     */
    public int tmpSolution(int[] arrLeaves, int totalDistance, int jumpDistance) {
        if (totalDistance <= jumpDistance) return 0;
        if (totalDistance - maxArray(arrLeaves) > jumpDistance) return -1;

        // Everything starts at false, so we don't need to initialize it to false
        boolean[] isLeafAtThisPosition = new boolean[totalDistance];
        int currentFrogPosition = 0;
        int totalTime = 0;
        for (int i = 0; i < arrLeaves.length; i++, totalTime++) {
            isLeafAtThisPosition[arrLeaves[i]] = true;
            int canFrogJumpAnyForward = canJumpForward(currentFrogPosition, isLeafAtThisPosition, jumpDistance);
            while (canFrogJumpAnyForward != -1) {
                currentFrogPosition = canFrogJumpAnyForward;
                canFrogJumpAnyForward = canJumpForward(currentFrogPosition, isLeafAtThisPosition, jumpDistance);

            }

            if (totalDistance - currentFrogPosition <= jumpDistance) return totalTime;
        }

        return -1;
    }

    /**
     * helper function to check if the frog can jump
     * on any previously fallen leaves
     *
     * @param currentPosition
     * @param fallenLeaves
     * @param jumpDistance
     * @return
     */
    public int canJumpForward(int currentPosition, boolean[] fallenLeaves, int jumpDistance) {
        int maxDistance = -1;
        for (int i = currentPosition + 1; i <= currentPosition + jumpDistance && i < fallenLeaves.length; i++) {
            if (fallenLeaves[i] == true) {
                maxDistance = i;
            }
        }
        return maxDistance;
    }

    /**
     * returns the max element in the array
     *
     * @param array
     * @return
     */
    public int maxArray(int[] array) {
        int maxVal = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxVal) maxVal = array[i];
        }
        return maxVal;
    }

    public static void main(String[] args) {
        JumpFrogJump t = new JumpFrogJump();
        int[] a = {13, 10, 7, 4, 1, 2, 1, 2};
        System.out.println(t.solution(a, 15, 4));
    }
}
