package calabash;
import javafx.scene.image.Image;
import java.io.File;

public enum CalabashColor {  //将葫芦娃的颜色定义为枚举类，避免重复生成同一个葫芦娃；
	RED("大娃", 1), 
	ORANGE("二娃", 2), 
	YELLOW("三娃", 3), 
	GREEN("四娃", 4), 
	CYAN("五娃", 5), 
	BLUE("六娃", 6), 
	PURPLE("七娃", 7);
	private String name;
	private int order;  //表示葫芦娃的大小顺序；
	Image image;
	
	CalabashColor(String name, int order){
		this.name = name;
		this.order = order;
		setImage();
	}
	
	public int getOrder() {
		return this.order;
	}
	
	public String getName() {
		return this.name;
	}
	
	private void setImage() {
        switch (order) {
            case 1: image = new Image("file:images/001.jpg", 50, 50, false, false); break;
            case 2: image = new Image("file:images/002.jpg", 50, 50, false, false); break;
            case 3: image = new Image("file:images/003.jpg", 50, 50, false, false); break;
            case 4: image = new Image("file:images/004.jpg", 50, 50, false, false); break;
            case 5: image = new Image("file:images/005.jpg", 50, 50, false, false); break;
            case 6: image = new Image("file:images/006.jpg", 50, 50, false, false); break;
            case 7: image = new Image("file:images/007.jpg", 50, 50, false, false); break;
            default: break;
        }
    }
	
	public Image getImage() {
		return this.image;
	}
}
