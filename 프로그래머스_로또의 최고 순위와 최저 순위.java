import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        // 당첨된 숫자에 개수에 따른 순위(0, 1, 2, 3, 4, 5, 6)
        int[] winning = {6, 6, 5, 4, 3, 2, 1};
        
        // 포함된 0의 개수 구하기
        int num_zero = 0;
        for(int i = 0; i < 6; i++){
            if(lottos[i] == 0){
                num_zero++;
            }
        }
        
        // hashmap에 값을 삽입해서 일치하는 숫자가 있는지 탐색
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for(int i = 0; i < 6; i++){
            hashmap.put(win_nums[i], i);
        }
        int same_num = 0;
        for(int i = 0; i < 6; i++){
            if(hashmap.containsKey(lottos[i])){
                same_num++;
            }
        }
        int best = num_zero + same_num;
        int worst = same_num;
        
        int[] answer = {winning[best], winning[worst]};
        
        return answer;
    }
}

