import java.util.Random;

public class WBANMobileModel {
	
	public static final int GRID_ROWS = 100;
	public static final int GRID_COLUMNS = 100;
	public static final int ITEM_NUMBERS = 100;
	public static final int STEP_LENGTH = 1;
	public static final int STEP_NUMBERS = 10000;
	public static final int SIMULATION_NUMBERS = 1000;
	
	private Grid mGrid;
	private Location[] mOccupations;
	private Location[] mDestinations;
	private Item[] mItems;
	private Location[] mLocations;
	private int mScore;
	private int mCenterX;
	private int mCenterY;

	public static void main(String[] args) {
		WBANMobileModel wbanMobileModel = new WBANMobileModel();
		wbanMobileModel.init();
		int temp = 0;
		for (int j = 0; j < SIMULATION_NUMBERS; j++) {
			wbanMobileModel.init();
			for (int i = 0; i < STEP_NUMBERS; i++) {
				wbanMobileModel.step();
			}
			temp += wbanMobileModel.mScore;
			System.out.println("Number " + j + ": socre is " + wbanMobileModel.mScore);
		}
		temp /= SIMULATION_NUMBERS;
		wbanMobileModel.mScore = temp;
		System.out.println("Score is " + wbanMobileModel.mScore
				+ ", probability is " + wbanMobileModel.calculateProbability());
	}
	
	private void init() {
		mCenterX = GRID_ROWS / 2;
		mCenterY = GRID_COLUMNS / 2;
		initOccupations();
		initDestinations();
		initItems();
		mGrid = new Grid(GRID_ROWS, GRID_COLUMNS, mOccupations, mDestinations);
		mGrid.setLocations(mLocations);
		mScore = 0;
	}

	private void initOccupations() {
		mOccupations = new Location[2];
		mOccupations[0] = new Location(mCenterX - 2, mCenterY);
		mOccupations[1] = new Location(mCenterX + 2, mCenterY);
	}
	
	private void initDestinations() {
		mDestinations = new Location[3];
		mDestinations[0] = new Location(mCenterX - 1, mCenterY);
		mDestinations[1] = new Location(mCenterX, mCenterY);
		mDestinations[2] = new Location(mCenterX + 1, mCenterY);
	}
	
	private void initItems() {
		mLocations = new Location[ITEM_NUMBERS];
		mItems = new Item[ITEM_NUMBERS];
		for (int i = 0; i < ITEM_NUMBERS; i++) {
			mLocations[i] = new Location(0, 0);
			mItems[i] = new Item(new Location(0, 0), STEP_LENGTH, new RandomMobileModel());
		}
		for (int i = 0; i < ITEM_NUMBERS; i++) {
			do {
				int x = new Random().nextInt(GRID_ROWS);
				int y = new Random().nextInt(GRID_COLUMNS);
				mLocations[i].setLocation(x, y);
				mItems[i].setLocation(mLocations[i]);
			} while (isOverlay(i) || isAtOccupations(i));
		}
	}
	
	private void step() {
		for (int i = 0; i < ITEM_NUMBERS; i++) {
			mItems[i].step();
			if (isOverlay(i) || mGrid.isBeyondBoundary(mItems[i].getLocation()) || mGrid.isAtOccupations()) {
				mItems[i].back();
			}
			mLocations[i].setLocation(mItems[i].getLocation());
		}
		mGrid.setLocations(mLocations);
		if (mGrid.isAtDestinations()) {
			mScore++;
		}
	}
	
	private boolean isOverlay(int n) {
		for (int i = ITEM_NUMBERS - 1; i > n; i--) {
			if ((mLocations[i].getLocationX() == mLocations[n].getLocationX())
					&& (mLocations[i].getLocationY() == mLocations[n].getLocationY())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isAtOccupations(int n) {
		for (Location occupation: mOccupations) {
			if (mLocations[n].getLocationX() == occupation.getLocationX()
					&& mLocations[n].getLocationY() == occupation.getLocationY()) {
				return true;
			}
		}
		return false;
	}
	
	private float calculateProbability() {
		float probability = (float) mScore / STEP_NUMBERS;
		return probability;
	}

}
