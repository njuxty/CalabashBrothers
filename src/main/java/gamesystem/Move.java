package gamesystem;

import calabash.*;

public class Move extends Thread  {
	Field field;
	Creature c1; //move c1
	Creature c2;
	
	Move(Field f, Creature cc1, Creature cc2){
		field=f;
		c1=cc1;
		c2=cc2;
		
	}
	
	@Override
	public void run() {
		synchronized(field) {
			int x1=c1.getX();
			int y1=c1.getY();
			int x2=c2.getX();
			int y2=c2.getY();
			int xx;
			int yy;
			grid gd;
			if(x1==x2) {
				if(Math.abs(y1-y2)==1) {return;}
				else if (y1>y2)
				{
					gd=field.checkempty(x1, y1-1);
					if(gd.isempty()) {
						field.changeto(c1, x1, y1-1);
					}
				}
				else {
					gd=field.checkempty(x1, y1+1);
					if(gd.isempty()) {
						field.changeto(c1, x1, y1+1);}				
				}
							
			}
			else if(Math.abs(x1-x2)==1 && y1==y2) {
				return;				
			}
			else {
				if(x1>x2) xx=x1-1;
				else xx=x1+1;
				yy=y1;
				gd=field.checkempty(xx, yy);
				if(gd.isempty())
				{
					field.changeto(c1, xx, yy);
					return;
				}
				xx=x1;
				if(y1>y2) yy=y1-1;
				else yy=y1+1;
				gd=field.checkempty(xx, yy);
				if(gd.isempty())
				{
					field.changeto(c1, xx, yy);
					return;
				}			
			}
		}
	}

}
