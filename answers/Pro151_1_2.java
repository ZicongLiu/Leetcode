public String reverseWords(String s) {
   String[] temp = s.split(" +");
   StringBuilder sb = new StringBuilder();
   for(int i = temp.length - 1; i >= 0;i --){
       sb.append(temp[i].trim()+" ");           
   }
   return sb.toString().trim();
}