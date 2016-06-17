
public class Grid {
	private long mRows;
	private long mColumns;
	private Location[] mOccupations;
	private Location[] mDestinations;
	private Location[] mLocations;

	public Grid(long rows, long columns, Location[] occupations, Location[] destinations) {
		mRows = rows;
		mColumns = columns;
		mOccupations = occupations;
		mDestinations = destinations;
		mLocations = null;
	}
	
	public void setRowsAndColumns(long rows, long columns) {
		mRows = rows;
		mColumns = columns;
	}
	
	public long getRows() {
		return mRows;
	}
	
	public long getColumns() {
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
				if (location == destination) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isBeyondBoundary(Location location) {
		long x = location.getLocationX();
		long y = location.getLocationY();
		if (x >= 0 && x < mRows && y >= 0 && y < mColumns) {
			return true;
		}
		return false;
	}
}
