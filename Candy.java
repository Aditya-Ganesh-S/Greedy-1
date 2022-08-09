//Time: O(n)
//Space: O(1)
public class Candy {
    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);
        int n = ratings.length;
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = 1+result[i-1];
            }
        }
        int sum = result[n-1];
        for(int i =n-2; i>=0 ;i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i], 1+result[i+1]);
            }
            sum += result[i];
        }
        return sum;
    }
}
