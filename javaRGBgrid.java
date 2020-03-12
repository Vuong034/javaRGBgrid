/** 
 * 
 * Java 2D RGB Program
 * 
 *  todo: 
 * [x]print a 2d grid
 * [x]randomize 2d grid
 * [x]row sort 2d grid
 * [x]accept string array of colors as input
 * [-]print grid as html?
 * []rgb hex color list
 * []color list from file
 * []define sorted type list(human warm to cool sort) 
 * 
 * misc ideas:
 * favorite color generator
 *      pick a couple of favorite colors generate a randomized grid
 *      handle rogue colors?
 *  
 *      randomize image bit/rgb map
 *      vector image or raster image?
 *      resort/reconstruct image     
 *  
 * game?
 *      2d rubix cube?
 *      hexic color rotation/matching clone
 *      vr support?
 * v2 3d block sort
 * */ 
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;
import java.lang.String;
import java.io.*;

public class javaRGBgrid {


//whole ansi color guide
public static final String ANSI_RESET = "\u001B[0m";//resets ansi text to default console text
public static final String ANSI_BLACK = "\u001B[30m";//changes text color 8
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m";

public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";//changes background color 8
public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

/**
 * main gets user input, creates a randomized grid, passes grid to sorting algorithm
 * returns sorted grid
 * @param args
 */

    public static void main(String[] args) {
        //color demo
        /*
        System.out.println(ANSI_GREEN_BACKGROUND + "This text has a green background but default text!" + ANSI_RESET);
        System.out.println(ANSI_RED + "This text has red text but a default background!" + ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "This text has a green background and red text!" + ANSI_RESET);
        */
        System.out.println("Java RGB Project");//title
        
        //input ansi background color
        String[] color_list = {
            "\u001B[40m",
            "\u001B[41m",
            "\u001B[42m",
            "\u001B[43m",
            "\u001B[44m",
            "\u001B[45m",
            "\u001B[46m",
            "\u001B[47m"
            };
        String reset = "\u001B[0m";//reset background value
        String grid[][]= create2dgrid(10,10,color_list, reset);
        System.out.println("2d grid created:\n");
        print2Dmatrix(grid);
        
        grid = bubbleSortGrid(grid);
        print2Dgrid(grid);
        
    }// main
     
    public static String[][] create2dgrid(int row_size, int col_size, String[] color_list, String reset) {
        Random rand = new Random();
        String [][] grid = new String [row_size][col_size];

        /**random generation with repeating colors and index*/
        for (int i = 0; i < row_size; i++){
            //int index = rand.nextInt(color_list.length);//again?
            for (int j = 0; j < col_size; j++){
                int index = rand.nextInt(color_list.length);
                grid[i][j] = color_list[index]+" "+index+" "+reset;//stores colored index with number in matrix element
            }    
        }
        return grid;
    }//create 2d grid

    public static void print2Dmatrix(String mat[][]) 
    { 
        // Loop through all rows 
        for (String[] row : mat) 
  
            // converting each row as string 
            // and then printing in a separate line 
            System.out.println(Arrays.toString(row)); 
    }//print 2d matrix

    public static void print2Dgrid(String mat[][]) 
    { 
        // Loop through all rows 
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){            
                System.out.print(mat[i][j]);             
            }
            System.out.println("\n");
        } 
  
    }//print 2d grid

    //sorting methods
    public static String[][] bubbleSortGrid(String mat[][]){
        String temp = "";
        int row = mat.length;
        int col = mat[0].length;
        int i,j,k;

        System.out.println("Bubble Sorting matrix by rows...");
        //loop through mat 
        for(i = 0; i < row; i++){//iterate rows
            for(j = 0; j < col; j++){//iterate cols
                for(k = 0; k < row - j - 1; k++){//iterate checker
                        if(mat[i][k].compareTo(mat[i][k + 1]) > 0){
                            // swapping of elements 
                            temp = mat[i][k]; 
                            mat[i][k] = mat[i][k + 1]; 
                            mat[i][k + 1] = temp;     
                        }
                } 
            }
        }
        return mat;
    }

}

