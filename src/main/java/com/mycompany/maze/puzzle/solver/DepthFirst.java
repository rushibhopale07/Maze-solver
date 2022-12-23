/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze.puzzle.solver;

import java.util.List;

/**
 *
 * @author rushi
 */
public class DepthFirst {
    //to search a correct path we create a function searchpath 
    public static boolean searchPath(int maze[][], int x, int y, List<Integer>path){
        // we get a maze and there current x and y position
        //path is used to store the position where we can go from
        
        if(maze[x][y]==2) //if we reached at correct position we get our solution
        {
            path.add(x);   // add it to path and return back;
            path.add(y);
            return true;
        }
        if(maze[x][y]==0 || maze[x][y]==4)   //if we reached at unblocked area we have 4 options 
        {
            maze[x][y]=3;  // mark the unblocked area as reached area 
           
            
            // we check 4 conditions
            
            int dx=-1;  // for getting upward
            int dy=0; 
            if(searchPath(maze,x+dx, y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx=1;   // for getting downward
            dy=0; 
            if(searchPath(maze,x+dx, y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            dx=0;
            dy=-1; // for getting backward
            if(searchPath(maze,x+dx, y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx=0;
            dy=1; // for getting forward
            if(searchPath(maze,x+dx, y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;   //if we reached at unblocked area
    }
}
