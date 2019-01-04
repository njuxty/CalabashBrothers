package calabash;
import javafx.scene.image.Image;

public final class Snake extends Monsters implements Cheer {
	Snake(){
		name = "蛇精";
		type = 1;
		this.setattack(15);
	}
	
	Snake(int ix, int iy){
		name = "蛇精";
		x = ix;
		y = iy;
		this.setattack(15);
		this.image = new Image("010.jpg", 50, 50, false, false);
	}
	
	@Override
    public void cheer(){
        
    }
}
