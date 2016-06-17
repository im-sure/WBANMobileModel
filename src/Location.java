
public class Location {
	private long mX;
	private long mY;
	
	public Location(long x, long y) {
		mX = x;
		mY = y;
	}
	
	public void setLocation(long x, long y) {
		setLocationX(x);
		setLocationY(y);
	}
	
	public void setLocationX(long x) {
		mX = x;
	}
	
	public void setLocationY(long y) {
		mY = y;
	}
	
	public long getLocationX() {
		return mX;
	}
	
	public long getLocationY() {
		return mY;
	}
	
	public String toString() {
		return "X: " + mX + ", Y: " + mY;
	}
}
