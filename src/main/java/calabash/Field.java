package calabash;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Field {
	public Creature empty = new Creature(-1,-1);
	Image background = new Image("000.jpg", 750, 750, false, false);
	public grid[][] field = new grid[15][15];  //战场的每一个都有一个Creature对象，虚无是一种特殊的Creature；
	ArrayList<CalabashBrothers> bros = new ArrayList<CalabashBrothers>();
	ArrayList<Monsters> mons = new ArrayList<Monsters>();
	ArrayList<Creature> justice = new ArrayList<Creature>();
	ArrayList<Creature> evil = new ArrayList<Creature>();
	ArrayList<Tomb> tomb = new ArrayList<Tomb>();
	public void initialField() {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				field[i][j]= new grid(i,j,empty);
			}
		}
	}
	
	public void setformation() {
		this.initialField();
		Grandpa gra = new Grandpa(7, 1);
		justice.add(gra);
		Snake sna = new Snake(7, 13);
		evil.add(sna);
		Scorpion sco=new Scorpion();
		mons.add(sco);
		evil.add(sco);
		CalabashColor[] brosColor = CalabashColor.values();

		for(int i = 0; i < 7; i++) {
			CalabashBrothers bb =new CalabashBrothers(brosColor[i]);
			bros.add(bb);
			justice.add(bb);
		}

		
		//form calabashbrothers
		//Collections.shuffle(bros);
		SnakeFormation snF = new SnakeFormation(this);
		snF.setFormation(bros);
		this.updateField(gra.getX(), gra.getY(), gra);
	
		int seed=(int)(Math.random()*3);
		
		switch(seed) {
		case 0:
			CraneFormation crF=new CraneFormation(this);
			for( int i = 1; i < crF.getSize(); i++) {
				Monsters mm=new Monsters();
				mons.add(mm);
				evil.add(mm);
			}
			crF.setFormation(mons);
			this.updateField(sna.getX(), sna.getY(), sna);
			break;
		case 1:
			SquareFormation sqF = new SquareFormation(this);
			for( int i = 1; i < sqF.getSize(); i++) {
				Monsters mm=new Monsters();
				mons.add(mm);
				evil.add(mm);
			}
			sqF.setFormation(mons);
			this.updateField(sna.getX(), sna.getY(), sna);
			break;
		case 2:
			ArrowFormation arF = new ArrowFormation(this);
			for( int i = 1; i < arF.getSize(); i++) {
				Monsters mm=new Monsters();
				mons.add(mm);
				evil.add(mm);
			}
			arF.setFormation(mons);
			this.updateField(sna.getX(), sna.getY(), sna);
			break;
			
		}

	
	}
	
	public boolean isfinished() {
		return justice.isEmpty()||evil.isEmpty();
	}
	
	public void updateField(int ix, int iy, Creature crea) {
		field[ix][iy].changecreature(crea);
		if(crea.getX()==-1) {
			field[ix][iy].setempty(true);
		}
		else {
			field[ix][iy].setempty(false);
		}
	}
	
	public void printField() {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				System.out.print(field[i][j].getCreature().getName());
			}
			System.out.println();
		}
	}
	
	public void clearMonster() {
		for(int i = 0; i < 15; i++) {
			for(int j = 8; j < 15; j++) {
				field[i][j].changecreature(empty);
				field[i][j].setempty(true);
			}
		}
	}
	
	public grid checkempty(int ix, int iy) {
		return field[ix][iy];
	}
	
	public void changeto(Creature cc,int ix, int iy)
	{
		field[ix][iy].changecreature(cc);
		field[ix][iy].setempty(false);
		int x2=cc.getX();
		int y2=cc.getY();
		field[x2][y2].changecreature(empty);
		field[x2][y2].setempty(true);
		cc.updatePosition(ix, iy);
	}
	
	public ArrayList<Creature> getbrother() {
		return justice;	
	}
	
	public ArrayList<Creature> getmonsters(){
		return evil;
	}
	
	public void dead(int ix, int iy)
	{
		field[ix][iy].changecreature(empty);
		field[ix][iy].setempty(true);
		tomb.add(new Tomb(ix,iy));
	}
	
	 public void drawField(GraphicsContext gc){
		 gc.drawImage(background, 0, 0);
		 for(Iterator<Tomb> it1=tomb.iterator(); it1.hasNext();) {
			 Tomb t=it1.next();
			 gc.drawImage(t.getImage(), t.getY()*50,t.getX()*50);
		 }
         for(int i = 0;i < 15;i++) {
             for(int j = 0;j < 15;j++) {
                 if(!field[i][j].isempty()){
                	 gc.drawImage(field[i][j].getCreature().getImage(), j*50, i*50);
                 }
             }
         }


 }
	
	/*public static void main(String[] args) {
		//initialize
		Field field = new Field();
		field.setformation();
		field.printField();
		/*field.initialField();
		Grandpa gra = new Grandpa(7, 1);
		Snake sna = new Snake(7, 13);
		CalabashColor[] brosColor = CalabashColor.values();
		ArrayList<CalabashBrothers> bros = new ArrayList<CalabashBrothers>();
		for(int i = 0; i < 7; i++) {
			bros.add(new CalabashBrothers(brosColor[i]));
		}
		Sort sort = new Sort();
		
		//form calabashbrothers
		System.out.println("**********randomCalabash**********");
		Collections.shuffle(bros);
		SnakeFormation snF = new SnakeFormation(field);
		snF.setFormation(bros);
		field.printField();
		System.out.println("**********sortCalabash**********");
		sort.bubbleSort(bros);
		snF.setFormation(bros);
		field.updateField(gra.getX(), gra.getY(), gra);
		field.printField();
		
		//form monsters
		System.out.println("**********craneFormation**********");
		CraneFormation crF = new CraneFormation(field);
		ArrayList<Monsters> mons = new ArrayList<Monsters>();
		mons.add(new Scorpion());
		for( int i = 1; i < crF.getSize(); i++) {
			mons.add(new Monsters());
		}
		crF.setFormation(mons);
		field.updateField(sna.getX(), sna.getY(), sna);
		field.printField();
		field.clearMonster();
		mons.clear();
		
		System.out.println("**********squareFormation**********");
		SquareFormation sqF = new SquareFormation(field);
		mons.add(new Scorpion());
		for( int i = 1; i < crF.getSize(); i++) {
			mons.add(new Monsters());
		}
		sqF.setFormation(mons);
		field.updateField(sna.getX(), sna.getY(), sna);
		field.printField();
		field.clearMonster();
		mons.clear();
		
		System.out.println("**********arrowFormation**********");
		ArrowFormation arF = new ArrowFormation(field);
		mons.add(new Scorpion());
		for( int i = 1; i < crF.getSize(); i++) {
			mons.add(new Monsters());
		}
		arF.setFormation(mons);
		field.updateField(sna.getX(), sna.getY(), sna);
		field.printField();
		field.clearMonster();
		mons.clear();
		
	
		
	}*/
}
