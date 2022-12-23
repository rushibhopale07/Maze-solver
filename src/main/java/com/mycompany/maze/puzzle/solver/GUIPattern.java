/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze.puzzle.solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author rushi
 */
public class GUIPattern extends JFrame{
    int [][]maze={
        // you can edit it as per your 
        {1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,0,0,0,0,0,1},
        {1,0,1,1,0,1,1,1,1,1},
        {1,0,1,0,0,0,0,1,0,1},
        {1,0,0,0,1,1,0,1,0,1},
        {1,0,1,0,1,0,0,0,0,1},
        {1,1,1,0,0,1,0,0,1,1},
        {1,0,1,1,1,0,1,0,0,1},
        {1,0,0,0,0,0,1,1,2,1},
        {1,1,1,1,1,1,1,1,1,1}
            
        //1- blocked area
        //0- unblocked area
        //2- location of Goal
    };
    public List<Integer> path= new ArrayList<>();
    
    public GUIPattern(){
        setTitle("Maze Solver");
        setSize(480,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze, 1, 1, path);
        
    }
    @Override
    public void paint(Graphics g){
        //to paint 
        super.paint(g);
        g.translate(50, 50);
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++)
            {
                 Color color;
                 switch(maze[i][j]){
                     case 1: color=Color.BLACK; 
                     break;
                     case 2: color=Color.GREEN;
                     break;
                     case 4: color=Color.GREEN;
                     break;
                     default: color=Color.GRAY;
                     break;
                 }
                 g.setColor(color);
                 g.fillRect(30*i, 30*j, 30,30); // fill a block with color
                 g.setColor(Color.RED); // outline border color
                 g.drawRect(30*i, 30*j, 30,30); // border area
            }
        }
        for(int i=2;i<path.size();i+=2){
            int pathx=path.get(i);
            int pathy=path.get(i+1);
            System.out.println(pathx + " "+ pathy);
            g.setColor(Color.ORANGE); // visited path
            g.fillRect(30*pathx, 30*pathy, 30,30);
        }
    }
//    public static void main(String args[]){
//        GUIPattern gm= new GUIPattern();
//        gm.setVisible(true);
//    }
}
