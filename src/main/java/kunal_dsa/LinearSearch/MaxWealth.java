package kunal_dsa.LinearSearch;

public class MaxWealth {
    public static void main(String[] args) {
        int accounts[][] = {
                {1,2,3},
                {3,2,1}
        };

        int result[] = maximumWealth(accounts);
        System.out.println("Person " + result[0] + " has the maximum wealth of " + result[1]);
    }
    
    static int[] maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        int person = -1;


        for (int row = 0; row < accounts.length; row++) {
            int currentWealth = 0;
            for (int col = 0; col < accounts[0].length; col++) {
                currentWealth+= accounts[row][col];
            }
            if(currentWealth>maxWealth){
                maxWealth = currentWealth;
                person = row+1;
            }

        }
        return new int[]{person , maxWealth};
    }
}
