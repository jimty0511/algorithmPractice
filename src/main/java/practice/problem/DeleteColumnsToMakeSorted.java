package practice.problem;

// 944. Delete Columns to Make Sorted
public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] A) {
        if (A == null || A.length <= 1 || A[0].length() <= 1)
            return 0;
        int count = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j - 1].charAt(i) > A[j].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
