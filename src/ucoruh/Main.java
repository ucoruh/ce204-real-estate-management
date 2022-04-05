package ucoruh;

import realeastatewrapper.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AddressWrapper address = new AddressWrapper(4, 1, "Sample Street", "Rize", "53100");
		GPSCoordWrapper gpsCoord = new GPSCoordWrapper(56, 45);
		NeighbourhoodWrapper neighbourhood = new NeighbourhoodWrapper("sample");
		
		PropertyWrapper property = new PropertyWrapper(address, 2, 2, 100, 1, gpsCoord, neighbourhood);
		
		AgentWrapper agent = new AgentWrapper("Sample", "112312312", "adasd@gmadil.com", "123123123", "asdasdas", address);
		
		
		
		
	}

}
