/*
This problem was asked by Snapchat.

Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.

The input list is not necessarily ordered in any way.

For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].
 */

package Easy;

import java.util.*;

class tuple {
    int x, y;

    tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}

public class Problem637 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<tuple> arr = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(new tuple(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(arr, new Comparator<tuple>() {
            @Override
            public int compare(tuple o1, tuple o2) {
                if (o2.x - o1.x != 0)
                    return o1.x - o2.x;
                else
                    return o1.y - o2.y;
            }
        });

        int start = arr.get(0).x, end = arr.get(0).y;

        for (int i = 1; i < n; i++) {
            if (arr.get(i).x >= start && arr.get(i).x <= end) {
                end = Math.max(end, arr.get(i).y);
            } else {
                System.out.println("(" + start + "," + end + ")");
                start = arr.get(i).x;
                end = arr.get(i).y;
            }
        }
        System.out.println("(" + start + "," + end + ")");
    }
}
