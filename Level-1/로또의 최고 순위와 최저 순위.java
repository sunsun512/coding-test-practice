class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zeroCnt = 0;
        for(int lotto: lottos){
            if(lotto == 0) {
                zeroCnt ++;
                continue;
            }
            for(int win_num:win_nums){
                if(win_num == lotto){
                    cnt ++;
                    break;
                }
            }
        }
        return new int[]{7-Math.max(cnt+zeroCnt,1),7-Math.max(cnt,1)};
    }
}


// 고수의 

// import java.util.HashMap;
// import java.util.Map;

// class Solution {
//     public int[] solution(int[] lottos, int[] win_nums) {
//         Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
//         int zeroCount = 0;

//         for(int lotto : lottos) {
//             if(lotto == 0) {
//                 zeroCount++;
//                 continue;
//             }
//             map.put(lotto, true);
//         }


//         int sameCount = 0;
//         for(int winNum : win_nums) {
//             if(map.containsKey(winNum)) sameCount++;
//         }

//         int maxRank = 7 - (sameCount + zeroCount);
//         int minRank = 7 - sameCount;
//         if(maxRank > 6) maxRank = 6;
//         if(minRank > 6) minRank = 6;

//         return new int[] {maxRank, minRank};
//     }
// }
