package gamesystem;

import java.util.ArrayList;
import java.util.Iterator;

import calabash.*;

public class Attack extends Thread  {
	
	Field field;
	ArrayList<Creature> bros;
	ArrayList<Creature> mons;
	
	Attack(Field f){
		this.field=f;
		bros=f.getbrother();
		mons=f.getmonsters();
	}
	
	@Override
	public void run() {
		synchronized(field) {
			for(Iterator<Creature> it1=bros.iterator(); it1.hasNext();) {
				Creature b=it1.next();
				int[] ix= {1,0,-1,0};
				int[] iy= {0,1,0,-1};
				
				for(int i=0;i<4;i++)
				{
					grid g=field.checkempty(b.getX()+ix[i], b.getY()+iy[i]);
					if(!g.isempty()&&g.gettype()==1) {
						//attack
						
						int a1=b.getattack();
						int a2=g.getCreature().getattack();
						int win=(int)(Math.random()*(a1+a2));
						if(win<a1) { //brother win
							mons.remove(g.getCreature());
							field.dead(b.getX()+ix[i], b.getY()+iy[i]);
							}
						else {//monster win
							it1.remove();
							field.dead(b.getX(), b.getY());	
							break;
						}
						
						}
						
						
					}
				}
			
			}			
		}
	
}
