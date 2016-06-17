import java.util.Random;

public class RandomMobileModel extends MobileModel {

	@Override
	public Location model(Location location) {
		long x = location.getLocationX();
		long y = location.getLocationY();
		int n = new Random().nextInt(9);
		switch (n) {
			case 0: break;
			case 1: location.setLocationX(y + 1);break;
			case 2: location.setLocation(x + 1, y + 1);break;
			case 3: location.setLocationX(x + 1);break;
			case 4: location.setLocation(x + 1, y - 1);break;
			case 5: location.setLocationY(y - 1);break;
			case 6: location.setLocation(x - 1, y - 1);break;
			case 7: location.setLocationX(x - 1);break;
			case 8: location.setLocation(x - 1, y + 1);break;
			default: break;
		}
		return location;
	}
}
