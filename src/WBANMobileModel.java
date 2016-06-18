import java.util.Arrays;
import java.util.Random;

public class WBANMobileModel {
	
	public static final int GRID_ROWS = 10000;
	public static final int GRID_COLUMNS = 10000;
	public static final int ITEM_NUMBERS = 100;
	public static final int STEP_LENGTH = 1;
	public static final int SIMULATION_NUMBERS = 10000;
	
	private Grid mGrid;
	private Location[] mOccupations;
	private Location[] mDestinations;
	private Item[] mItems;
	private Location[] mLocations;
	private int mScores;

	public static void main(String[] args) {
		WBANMobileModel wbanMobileModel = new WBANMobileModel();
		System.out.println("start");
		wbanMobileModel.init();
		for (int i = 0; i < SIMULATION_NUMBERS; i++) {
			wbanMobileModel.step();
			System.out.println("Number " + i
					+ ": score is " + wbanMobileModel.mScores
					+ ", probability is " + wbanMobileModel.calculateProbability());
		}
	}
	
	private void init() {
		initOccupations();
		initDestinations();
		initItems();
		mGrid = new Grid(GRID_ROWS, GRID_COLUMNS, mOccupations, mDestinations);
		mGrid.setLocations(mLocations);
		mScores = 0;
	}

	private void initOccupations() {
		mOccupations = new Location[2];
		mOccupations[0] = new Location(4998, 5000);
		mOccupations[1] = new Location(5002, 5000);
	}
	
	private void initDestinations() {
		mDestinations = new Location[3];
		mDestinations[0] = new Location(4999, 5000);
		mDestinations[1] = new Location(5000, 5000);
		mDestinations[2] = new Location(5001, 5000);
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
				System.out.println("1: " + mLocations[99].getLocationX());
				mLocations[i].setLocation(x, y);
				mItems[i].setLocation(mLocations[i]);
			} while (isOverlay(i));
		}
	}
	
	private void step() {
		for (int i = 0; i < ITEM_NUMBERS; i++) {
			mItems[i].step();
			if (isOverlay(i) || mGrid.isBeyondBoundary(mItems[i].getLocation())) {
				mItems[i].back();
			}
			mLocations[i].setLocation(mItems[i].getLocation());
		}
		mGrid.setLocations(mLocations);
		if (mGrid.isAtDestinations()) {
			mScores++;
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
	
	private float calculateProbability() {
		float probability = (float) mScores / SIMULATION_NUMBERS;
		return probability;
	}

}
