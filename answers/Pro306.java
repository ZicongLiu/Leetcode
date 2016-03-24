public class Solution {
    public boolean isAdditiveNumber(String num) {
        for(int i = 1 ; i < num.length() ; i ++){
            for (int j = i + 1 ; j <= num.length() ; j ++){
                String str1 = num.substring(0, i);
                String str2 = num.substring(i, j);
                if (str1.length() > 1 && str1.charAt(0) == '0'){
                    continue;
                }
                if (str2.length() > 1 && str2.charAt(0) == '0'){
                    continue;
                }
                if (str2.equals("")){
                    continue;
                }
                long num1 = Long.parseLong(str1);
                long num2 = Long.parseLong(str2);
                long sum = num1 + num2;
                String prefix = str1 + str2;
                if (prefix.equals(num)){
                    continue;
                }
                
                while (prefix.length() < num.length()){
                    prefix += sum;
                    if (!num.startsWith(prefix)
                         || prefix.length() > num.length()){
                        break;
                    }
                    num1 = num2;
                    num2 = sum;
                    sum = num1 + num2;
                }
                if (num.equals(prefix)){
                    return true;
                }
            }
        }
        return false;
    }
}