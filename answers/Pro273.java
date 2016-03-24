public class Solution {
    String[] underTwenty = { "", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    String[] productTen = { "","","Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety" };
    String[] thousands = {"",  "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        String result = "";
        int cur = num;
        int thousandCnt = 0;
        if (num == 0){
            return "Zero";
        }
        List<String> numbers = new ArrayList<String>();
        while (cur > 0){
            int qou = cur / 1000;
            int rem = cur % 1000;
            
            numbers.add(transform(rem));
            if (qou != 0){
                thousandCnt ++;
            }
            cur = qou;
        }
        for (int i = thousandCnt ; i >= 0 ; i --){
            String part = numbers.get(i);
            if (part.trim().length() != 0){
                result = result + part + thousands[i] + " ";
            }
        }
    
        int endIdx = result.length() - 1;
        while (result.charAt(endIdx) == ' '){
            endIdx --;
        }
        result = result.substring(0, endIdx + 1);
        return result;
    }
    private String transform(int num) {
        String result = "";
        int hun = num / 100;
        int tens = num % 100;
        int ten = tens / 10;
        int one = num % 10;
        if (hun > 0) {
            result += underTwenty[hun] + " Hundred ";
        }
        if (tens < 20 && tens != 0) {
            result += underTwenty[tens] + " ";
        } else if (tens != 0){
            result += productTen[ten] + " " + ((one > 0) ? underTwenty[one] + " " : "");
        }

        return result;
    }
}