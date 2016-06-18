
public class Grid {
	
	private int mRows;
	private int mColumns;
	private Location[] mOccupations;
	private Location[] mDestinations;
	private Location[] mLocations;

	public Grid(int rows, int columns, Location[] occupations, Location[] destinations) {
		mRows = rows;
		mColumns = columns;
		mOccupations = occupations;
		mDestinations = destinations;
		mLocations = null;
	}
	
	public void setRowsAndColumns(int rows, int columns) {
		mRows = rows;
		mColumns = columns;
	}
	
	public int getRows() {
		return mRows;
	}
	
	public int getColumns() {
		return mColumns;
	}
	
	public void setOccupations(Location[] occupations) {
		mOccupations = occupations;
	}
	
	public Location[] getOccupations() {
		return mOccupations;
	}
	
	public void setDestinations(Location[] destinations) {
		mDestinations = destinations;
	}
	
	public Location[] getDestinations() {
		return mDestinations;
	}
	
	public void setLocations(Location[] locations) {
		mLocations = locations;
	}
	
	public Location[] getLocations() {
		return mLocations;
	}
	
	public boolean isAtDestinations() {
		for (Location location: mLocations) {
			for (Location destination: mDestinations) {
				if (location.getLocationX() == destination.getLocationX()
						&& location.getLocationY() == destination.getLocationY()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isAtOccupations() {
		for (Location location: mLocations) {
			for (Location occupation: mOccupations) {
				if (location.getLocationX() == occupation.getLocationX()
						&& location.getLocationY() == occupation.getLocationY()) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean isBeyondBoundary(Location location) {
		int x = location.getLocationX();
		int y = location.getLocationY();
		if (x >= 0 && x < mRows && y >= 0 && y < mColumns) {
			return true;
		}
		return false;
	}
}
