import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int str_length = s.length(); // 문자열이 길이
        char[] str = new char[str_length];
        str = s.toCharArray();
        // 숫자 연결
        StringBuilder sb1 = new StringBuilder();
        // 문자 연결
        StringBuilder sb2 = new StringBuilder();
        
        for(int i = 0; i < str_length; i++){
            if(str[i] == '0' || str[i] == '1' || str[i] == '2' || str[i] == '3' || str[i] == '4' || str[i] == '5' || str[i] == '6' || str[i] == '7' || str[i] == '8' || str[i] == '9'){
         sb1.append(str[i]);       
            } else{
                sb2.append(str[i]);
                switch(sb2.toString()){
                    case "one" :
                        sb1.append(1);
                        sb2.setLength(0);
                        break;
                    case "two" :
                        sb1.append(2);
                        sb2.setLength(0);
                        break;
                    case "three" :
                        sb1.append(3);
                        sb2.setLength(0);
                        break;
                    case "four" :
                        sb1.append(4);
                        sb2.setLength(0);
                        break;
                    case "five" :
                        sb1.append(5);
                        sb2.setLength(0);
                        break;
                    case "six" :
                        sb1.append(6);
                        sb2.setLength(0);
                        break;
                    case "seven" :
                        sb1.append(7);
                        sb2.setLength(0);
                        break;
                    case "eight" :
                        sb1.append(8);
                        sb2.setLength(0);
                        break;
                    case "nine" :
                        sb1.append(9);
                        sb2.setLength(0);
                        break;
                    case "zero" :
                        sb1.append(0);
                        sb2.setLength(0);
                        break;
                }
            }
        }
        
        answer = Integer.parseInt(sb1.toString());

        return answer;
    }
}