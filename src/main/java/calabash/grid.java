package calabash;

public class grid {
	int x;
	int y;
	boolean empty;
	Creature creature;
	
	grid(){
		x=0;
		y=0;
		empty=true;
		
	}
	
	grid(int ix, int iy, Creature c){
		x=ix;
		y=iy;
		empty=true;
		creature = c;
		
	}
	
	public final int getX() {
		return x;
	}
	public final int getY() {
		return y;
	}
	public final Creature getCreature() {
		return creature;
	}
	public final boolean isempty() {
		return empty;
	}
	public final void changecreature(Creature c2) {
		creature=c2;
	}
	public final void setcoordinate(int ix, int iy) {
		x=ix;
		y=iy;
	}
	public final void setempty(boolean e2) {
		empty=e2;
	}
	public int gettype() {
		return creature.getType();
	}
	
}
