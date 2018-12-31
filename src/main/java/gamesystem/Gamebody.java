package gamesystem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import calabash.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;



public class Gamebody extends Canvas{
	
	private GraphicsContext gc;

	
	public Gamebody(double width, double height) {
        super(width, height); 
        gc = getGraphicsContext2D();

        threadstart();

                            
	}
	
	public void threadstart()
	{	Thread gamesystem=new Thread(new Runnable(){
		@Override
		public void run() {
		Field gamefield=new Field();
		ArrayList<Creature> bros=gamefield.getbrother();
		ArrayList<Creature> mons=gamefield.getmonsters();
		Image win = new Image("file:images/013.jpg", 750, 750, false, false);
		Image lose = new Image("file:images/014.jpg", 750, 750, false, false);
		gamefield.setformation();
		
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	gamefield.drawField(gc);
            }
        });
		try {
			Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();}
		while(!gamefield.isfinished()) {
			//move
			for(Iterator<Creature> it1=bros.iterator(); it1.hasNext();) {
				Creature b=it1.next();
				Random rnt=new Random();
				int index=rnt.nextInt(mons.size());
				Creature m=mons.get(index);
				Move moveb=new Move(gamefield,b,m);
				moveb.start();
				try {
                    moveb.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();}
				
				Move movem=new Move(gamefield,m,b);
				movem.start();
				try {
                    movem.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();}
				
			}
			
			//attack
			Attack roundattack=new Attack(gamefield);
			roundattack.start();
			try {
				roundattack.join();
            } catch (InterruptedException e) {
                e.printStackTrace();}
			try {
				Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();}
			Platform.runLater(new Runnable() {
                @Override
                public void run() {
                	gamefield.drawField(gc);
                }
                              
            });
		
			
		}
		try {
			Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();}
		if(mons.isEmpty()) {
			gc.drawImage(win, 0, 0);
		}
		else {
			gc.drawImage(lose, 0, 0);
		}

	    }});
	gamesystem.start();
	}
	
		

	

}
