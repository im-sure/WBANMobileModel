
public class Item {
	private Location mLocation;
	private Location mLastLocation;
	private long mStepLength; 
	private MobileModel mMobileModel;
	
	public Item(Location location, long stepLength, MobileModel mobileModel) {
		mLocation = location;
		mLastLocation = location;
		mStepLength = stepLength;
		mMobileModel = mobileModel;
	}

	public void step() {
		mLastLocation = mLocation;
		for (int i = 0; i < mStepLength; i++) {
			mLocation = mMobileModel.model(mLocation);
		}
	}
}
