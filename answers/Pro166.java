public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0){
            return "0";
        }
        if (denominator == 0){
            return "";
        }
        String result = "";
        if ((numerator < 0 && denominator > 0)
             || (numerator > 0 && denominator < 0)){
            result += "-";
        }
        long numL = Math.abs(numerator);
        if (numerator == Integer.MIN_VALUE){
            numL = (long)(Integer.MAX_VALUE) + 1;
        }
        long denL = Math.abs(denominator);
        if (denominator == Integer.MIN_VALUE){
            denL = (long)(Integer.MAX_VALUE) + 1;
        }
        long intL = numL / denL;
        long remL = numL % denL;
        
        result += intL;
        if (remL == 0){
            return result;
        }
        else{
            result += ".";
        }
        
        Map<Long, Integer> remPos = new HashMap<Long, Integer>();
        // remPos.put(remL, 0);
        String decimal = "";
        int count = 0;
        while (remL != 0){
            if (remPos.containsKey(remL)){
                int latterIdx = remPos.get(remL);
                String part1 = decimal.substring(0, latterIdx);
                String part2 = decimal.substring(latterIdx);
                result += part1 + "(" + part2 + ")";
                return result;
            }
            remPos.put(remL, count ++);
            remL *= 10;
            intL = remL / denL;
            decimal += intL;
            remL = remL % denL;
        }
        result += decimal;
        return result;
    }
}