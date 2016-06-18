
public class Location {
	
	private int mX;
	private int mY;
	
	public Location(Location location) {
		mX = location.getLocationX();
		mY = location.getLocationY();
	}
	
	public Location(int x, int y) {
		mX = x;
		mY = y;
	}
	
	public void setLocation(Location location) {
		mX = location.getLocationX();
		mY = location.getLocationY();
	}
	
	public void setLocation(int x, int y) {
		mX = x;
		mY = y;
	}
	
	public void setLocationX(int x) {
		mX = x;
	}
	
	public void setLocationY(int y) {
		mY = y;
	}
	
	public int getLocationX() {
		return mX;
	}
	
	public int getLocationY() {
		return mY;
	}
	
	public String toString() {
		return "X: " + mX + ", Y: " + mY;
	}
}
