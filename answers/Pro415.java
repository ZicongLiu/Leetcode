public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length())
            return addStrings(num2, num1);
        if ((num1.equals("0")) && (num2.equals("0")))
            return "0";
        char[] chArr1 = num1.toCharArray(), chArr2 = num2.toCharArray();
        int pos1 = chArr1.length - 1, pos2=  chArr2.length - 1;
        char[] chResult = new char[chArr1.length];
        int carry = 0;
        while (pos2 >= 0){
            int digit = (chArr1[pos1] - '0' +
                    chArr2[pos2] - '0' + carry) % 10;
            carry = (chArr1[pos1] - '0' + 
                    chArr2[pos2] - '0' + carry) / 10;
            chResult[pos1] = (char)(digit + '0');
            pos2 --;
            pos1 --;
        }
        while (pos1 >= 0){
            int digit = (chArr1[pos1] - '0' + carry) % 10;
            carry = (chArr1[pos1] - '0' + carry) / 10;
            chResult[pos1] = (char)(digit + '0');
            pos1 --;
        }
        String result = new String(chResult);
        if (carry == 1)
            result = "1" + result;
        return result;
    }
}