class Element{
    public int value;
    public int row;
    public int column;
    public Element(int value, int row, int column){
        this.value = value;
        this.row = row;
        this.column = column;
    }
}
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        PriorityQueue<Element> elements = new PriorityQueue<Element>(k + 1,
         new Comparator<Element>(){
            public int compare(Element e1, Element e2){
                return e1.value - e2.value;                
            }
        });
        for (int idxRow = 0 ; idxRow < matrix.length ; idxRow ++){
            elements.offer(new Element(matrix[idxRow][0], idxRow, 0));
        }
        Element little = null;
        int count = 0;
        while (count < k){
            little = elements.poll();
            count++;
            if (little.column < matrix[0].length - 1){
                elements.offer(
                    new Element(
                        matrix[little.row][little.column + 1],
                        little.row,
                        little.column + 1));
            }
        }
        return little.value;
        
    }
}