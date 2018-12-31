package calabash;
import javafx.scene.image.Image;

public final class Scorpion extends Monsters {
	Scorpion(){
		name = "老蝎";
		type = 1;
		this.setattack(10);
		this.image = new Image("file:images/009.jpg", 50, 50, false, false);
	}
	
	Scorpion(int ix, int iy){
		name = "老蝎";
		x = ix;
		y = iy;
		this.setattack(10);
		this.image = new Image("file:images/009.jpg", 50, 50, false, false);
	}
}
