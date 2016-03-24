public class Solution {
    public int myAtoi(String str) {
    	if (str == null || str.length() == 0){
    		return 0;
    	}
        int sign = 1;
        char[] ch = str.toCharArray();
        int idx = 0;
        while (ch[idx] == ' '){
        	idx ++;
        }
        if (ch[idx] == '-'){
        	sign = -1;
        	idx++;
        }
        else if (ch[idx] == '+'){
        	idx++;
        }
        int sum = 0;
        while (idx < str.length()){
        	int temp = ch[idx] - '0';
        	if (temp > 9 || temp < 0){
        		return sum * sign;
        	}
        	if (sum > Integer.MAX_VALUE / 10 ||
        		(sum == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)){
        		return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        	}
        	sum = sum * 10 + temp;
        	idx ++;
        }
        return sum * sign;
    }
}