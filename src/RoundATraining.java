import java.util.*;
public class RoundATraining {
    public static int compute(int[] skills, int n) {
        Arrays.sort(skills);
        int last = 0;
        for (int i = skills.length - n; i < skills.length; i++) {
            last += (skills[skills.length-1] - skills[i]);
        }
        int min = last;
        int prev = skills[skills.length - 1];
        for (int i = skills.length - 2; i >= n - 1; i--) {
            int cur = skills[i];
            int added = skills[i-n+1];
            int hours = last - (n-1) * (prev - cur) + (cur - added);
            min = Math.min(min, hours);
            last = hours;
            prev = cur;
        }
        return min;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numTest = in.nextInt();
        for (int i = 0; i < numTest; i++) {
            int N = in.nextInt();
            int P = in.nextInt();
            int[] skills = new int[N];
            for (int j = 0; j < N; j++) {
                skills[j] = in.nextInt();
            }
            System.out.println("Case #" + (i+1) + ": " + compute(skills, P));
        }
    }
}
