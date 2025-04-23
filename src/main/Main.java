package main;

import java.io.IOException;

import board.BoardCreator;
import game_ui.BoardUI;
import sf.FENGenerator;

public class Main {

    public static void main(String[] args) throws IOException {
    	BoardCreator.cBoard.deneme();  
    	
    	FENGenerator f = new FENGenerator();

    	System.out.println(f.generateFEN());

        new BoardUI();
    }
}
