package calabash;
import javafx.scene.image.Image;

public class Monsters extends Creature{
	Monsters(){
		name = "喽啰";
		type = 1;
		this.setattack(8);
		this.image = new Image("file:images/011.jpg", 50, 50, false, false);}

	
	Monsters(int ix, int iy){
		name = "喽啰";
		x = ix;
		y = iy;
		this.setattack(8);
		this.image = new Image("file:images/011.jpg", 50, 50, false, false);
	}
	
	
}
