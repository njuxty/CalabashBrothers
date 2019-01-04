package calabash;
import javafx.scene.image.Image;

public final class CalabashBrothers extends Creature {	
	int rank;  //给葫芦娃排序
	
	public CalabashBrothers(CalabashColor cala){
		name = cala.getName();
		rank = cala.getOrder();
		type = 0;
		this.setattack(11);
		image = cala.getImage();
	}
	
	public int getRank() {
		return rank;
	}
}