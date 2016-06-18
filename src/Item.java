
public class Item {
	
	private Location mLocation;
	private Location mLastLocation;
	private int mStepLength; 
	private MobileModel mMobileModel;
	
	public Item(Location location, int stepLength, MobileModel mobileModel) {
		mLocation = location;
		mLastLocation = new Location(mLocation);
		mStepLength = stepLength;
		mMobileModel = mobileModel;
	}
	
	public void setLocation(Location location) {
		mLocation = location;
	}

	public Location getLocation() {
		return mLocation;
	}
	
	public Location getLastLocation() {
		return mLastLocation;
	}
	
	public void setStepLength(int stepLength) {
		mStepLength = stepLength;
	}
	
	public int getStepLength() {
		return mStepLength;
	}
	
	public void step() {
		mLastLocation.setLocation(mLocation);;
		for (int i = 0; i < mStepLength; i++) {
			mLocation = mMobileModel.model(mLocation);
		}
	}
	
	public void back() {
		mLocation.setLocation(mLastLocation);
	}
}
