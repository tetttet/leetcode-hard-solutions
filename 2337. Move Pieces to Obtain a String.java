class Solution {
    public boolean canChange(String start, String target) {
        if (start.equals(target)) {
            return true;
        }

        int leftBalance = 0;  // Tracks unmatched 'L'
        int rightBalance = 0; // Tracks unmatched 'R'

        for (int i = 0; i < start.length(); i++) {
            char startChar = start.charAt(i);
            char targetChar = target.charAt(i);

            if (startChar == 'R') {
                if (leftBalance > 0) return false; // Cannot move 'R' past unmatched 'L'
                rightBalance++;
            }

            if (targetChar == 'L') {
                if (rightBalance > 0) return false; // Cannot move 'L' past unmatched 'R'
                leftBalance++;
            }

            if (targetChar == 'R') {
                if (rightBalance == 0) return false; // No 'R' available to move
                rightBalance--;
            }

            if (startChar == 'L') {
                if (leftBalance == 0) return false; // No 'L' available to match
                leftBalance--;
            }
        }

        return leftBalance == 0 && rightBalance == 0;
    }
}
