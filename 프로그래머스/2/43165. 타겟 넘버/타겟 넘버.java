class Solution {
    static int res;
    
    public int solution(int[] numbers, int target) {
        res = 0;
        int length = numbers.length;
        dfs(numbers, 0, length, 0, target);
        return res;
    }
    
    static void dfs(int[] numbers, int lev, int depth, int sum, int t) {
        if (lev == depth) {
            if (sum == t) res++;
            return;
        }
        
        dfs(numbers, lev + 1, depth, numbers[lev] + sum, t);
        dfs(numbers, lev + 1, depth, -numbers[lev] + sum, t);
    }
}