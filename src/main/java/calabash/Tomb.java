package calabash;
import javafx.scene.image.Image;

public class Tomb {
	int x;
	int y;
	Image image;
	
	Tomb(){
		this.image = new Image("file:images/012.jpg", 50, 50, false, false);
	}
	
	Tomb(int ix, int iy){
		this.x = ix;
		this.y = iy;
		this.image = new Image("file:images/012.jpg", 50, 50, false, false);
	}
	
	public final Image getImage() {
		return this.image;
	}
	
	public final int getX() {
		return x;
	}
	
	public final int getY() {
		return y;
	}
}
