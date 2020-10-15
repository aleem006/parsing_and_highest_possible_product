package maximumvalueinmatrix;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumValueInMatrix {

    public static void main(String[] args) {
        
        //Define the java string of numbers
        String number_string = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 "+
                  "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 "+
                  "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 "+
                  "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 "+
                  "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 "+
                  "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 "+
                  "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 "+
                  "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 "+
                  "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 "+
                  "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 "+
                  "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 "+
                  "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 "+
                  "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 "+
                  "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 "+
                  "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 "+
                  "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 "+
                  "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 "+
                  "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 "+
                  "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 "+
                  "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
        
        //Make a string array by splitting space character
        String []number_string_array = number_string.split(" ");

        //Parse the string array into 20*20 2 dimesional array
        int k = 0;
        int [][]n_2d = new int [20][20];
        for(int i = 0; i <20 ; i++){
            for (int j=0; j < 20 ; j++){
                n_2d[i][j] = Integer.parseInt(number_string_array[k]);
                k++;
            }
        }
        
        //Prints the array
        for(int i = 0; i < 20 ; i++){
            for (int j=0; j < 20 ; j++){
                System.out.print(" " + n_2d[i][j]);
            }
            System.out.print("\n");
        }
        
        System.out.println("");
        ArrayList<Integer> products = new ArrayList<>();
        
        //Iterate a 4*4 window throughout the 20*20 array and find all possible products of 4 digits 
        //the methodology is 4*4 window through out the main array.
        //So that it's only need to go till 17 because 18,19,20 will be covered by the last 4*4 window
        for ( int i = 0 ; i < 17 ; i++){
            for(int j = 0; j < 17 ; j++){
                //Find the product of rows
                products.add(n_2d[i][j]*n_2d[i][j+1]*n_2d[i][j+2]*n_2d[i][j+3]);            
                products.add(n_2d[i+1][j]*n_2d[i+1][j+1]*n_2d[i+1][j+2]*n_2d[i+1][j+3]);                
                products.add(n_2d[i+2][j]*n_2d[i+2][j+1]*n_2d[i+2][j+2]*n_2d[i+2][j+3]);                
                products.add(n_2d[i+3][j]*n_2d[i+3][j+1]*n_2d[i+3][j+2]*n_2d[i+3][j+3]);
                
                //Find the product of colomns
                products.add(n_2d[i][j]*n_2d[i+1][j]*n_2d[i+2][j]*n_2d[i+3][j]);                
                products.add(n_2d[i][j+1]*n_2d[i+1][j+1]*n_2d[i+2][j+1]*n_2d[i+3][j+1]);                
                products.add(n_2d[i][j+2]*n_2d[i+1][j+2]*n_2d[i+2][j+2]*n_2d[i+3][j+2]);                
                products.add(n_2d[i][j+3]*n_2d[i+1][j+3]*n_2d[i+2][j+3]*n_2d[i+3][j+3]);
                
                //Find the product of diagonals
                products.add(n_2d[i][j]*n_2d[i+1][j+1]*n_2d[i+2][j+2]*n_2d[i+3][j+3]);
                products.add(n_2d[i][j+3]*n_2d[i+1][j+2]*n_2d[i+2][j+1]*n_2d[i+3][j]);

            }
        }
        //get the maximum of the array
        int max = Collections.max(products);
        //Find the whether colomn, row or diagonal
        //the product_n help to determine which product given the value
        int product_n = (products.indexOf(max)%10);
        //System.out.println("index of max product is " +products.indexOf(max));
        //Find the row of the product pattern
        int r = (products.indexOf(max)/10)/17;
        //find the colomn of the product pattern
        int c = (products.indexOf(max)/10)%17;
        
        //Find the pattern type and print the maximum with indexes of 4 digits
        //in a 4*4 array there are 10 products (four colomns, four rows and 2 diaglonals)
        //the product_n help to determine which product given the value.
        if(product_n == 0){
            System.out.println(" maximu product is "+ n_2d[r][c]+"*"+n_2d[r][c+1]+"*"+n_2d[r][c+2]+"*"+n_2d[r][c+3] +" = " + max);
            System.out.println("Indexes of 4 digits"+ " ("+r+","+c+")"+ "("+r+","+c+1+")"+ "("+r+","+c+2+")"+ "("+r+","+c+3+")");
        }
        if(product_n == 1){
            System.out.println("maximum product is "+ n_2d[r+1][c]+"*"+n_2d[r+1][c+1]+"*"+n_2d[r+1][c+2]+"*"+n_2d[r+1][c+3] +" = " + max);
            System.out.println("Indexes of 4 digits"+ " ("+r+1+","+c+")"+ "("+r+1+","+c+1+")"+ "("+r+1+","+c+2+")"+ "("+r+1+","+c+3+")");
        }
        if(product_n == 2){
            System.out.println("maximum product is "+ n_2d[r+2][c]+"*"+n_2d[r+2][c+1]+"*"+n_2d[r+2][c+2]+"*"+n_2d[r+2][c+3] +" = " + max);
            System.out.println("Indexes of 4 digits"+ " ("+(r+2)+","+c+")"+ "("+(r+2)+","+(c+1)+")"+ "("+(r+2)+","+(c+2)+")"+ "("+(r+2)+","+(c+3)+")");
        }
        if(product_n == 3){
            System.out.println("Maximum product is "+ n_2d[r+3][c]+"*"+n_2d[r+3][c+1]+"*"+n_2d[r+3][c+2]+"*"+n_2d[r+3][c+3] +" = " + max);
            System.out.println("Indexes of 4 digits"+ " ("+(r+3)+","+c+")"+ "("+(r+3)+","+(c+1)+")"+ "("+(r+3)+","+(c+2)+")"+ "("+(r+3)+","+(c+3)+")");
        }
        if(product_n == 4){
            System.out.println("Maximum product is "+ n_2d[r][c]+"*"+n_2d[r+1][c]+"*"+n_2d[r+2][c]+"*"+n_2d[r+3][c] +" = " + max);
            System.out.println("Indexes of 4 digits"+ " ("+r+","+c+")"+ "("+(r+1)+","+c+")"+ "("+(r+2)+","+c+")"+ "("+(r+3)+","+c+")");
        }
        if(product_n == 5){
            System.out.println("Maximum product is "+ n_2d[r][c+1]+"*"+n_2d[r+1][c+1]+"*"+n_2d[r+2][c+1]+"*"+n_2d[r+3][c+1] +" = " + max);
            System.out.println("Indexes of 4 digits"+ " ("+r+","+(c+1)+")"+ "("+(r+1)+","+(c+1)+")"+ "("+(r+2)+","+(c+1)+")"+ "("+(r+3)+","+(c+1)+")");
        }
        if(product_n == 6){
            System.out.println("Maximum product is "+ n_2d[r][c+2]+"*"+n_2d[r+1][c+2]+"*"+n_2d[r+2][c+2]+"*"+n_2d[r+3][c+2] +" = " + max);
            System.out.println("Indexes of 4 digits"+ " ("+r+","+(c+2)+")"+ "("+(r+1)+","+(c+2)+")"+ "("+(r+2)+","+(c+2)+")"+ "("+(r+3)+","+(c+2)+")");
        }
        if(product_n == 7){
            System.out.println("Maximum product is "+ n_2d[r][c+3]+"*"+n_2d[r+1][c+3]+"*"+n_2d[r+2][c+3]+"*"+n_2d[r+3][c+3] +" = " + max);
            System.out.println("Indexes of 4 digits"+ " ("+r+","+(c+3)+")"+ "("+(r+1)+","+(c+3)+")"+ "("+(r+2)+","+(c+3)+")"+ "("+(r+3)+","+(c+3)+")");
        }
        if(product_n == 8){
            System.out.println("Maximum product is "+ n_2d[r][c]+"*"+n_2d[r+1][c+1]+"*"+n_2d[r+2][c+2]+"*"+n_2d[r+3][c+3] +" = " + max);
            System.out.println("Indexes of 4 digits"+ " ("+r+","+c+")"+ "("+(r+1)+","+(c+1)+")"+ "("+(r+2)+","+(c+2)+")"+ "("+(r+3)+","+(c+3)+")");
        }
        if(product_n == 9){
            System.out.println("Maximum product is "+ n_2d[r][c+3]+"*"+n_2d[r+1][c+2]+"*"+n_2d[r+2][c+1]+"*"+n_2d[r+3][c] +" = " + max);
            System.out.println("Indexes of 4 digits"+ " ("+r+","+(c+3)+")"+ "("+(r+1)+","+(c+2)+")"+ "("+(r+2)+","+(c+1)+")"+ "("+(r+3)+","+c+")");
        }
    }
    
}
