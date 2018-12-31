package calabash;
import javafx.scene.image.Image;

public final class Grandpa extends Creature implements Cheer {
	Grandpa(){
		name = "爷爷";
		type = 0;
		this.setattack(5);
	}
	
	Grandpa(int ix, int iy){
		name = "爷爷";
		x = ix;
		y = iy;
		this.setattack(5);
		this.image = new Image("file:images/008.jpg", 50, 50, false, false);
	}
	
	@Override
    public void cheer() {
        
    }
}
