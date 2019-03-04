import java.util.ArrayList;

public class HarnessRecords {

	private ArrayList<Harness> harnesss;

	HarnessRecords() {
		harnesss = new ArrayList<Harness>();
	}

	HarnessRecords(Harness harness) {
		harnesss = new ArrayList<Harness>();
	}

	public boolean isEmpty() {
		if (harnesss.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void addHarness(Harness newHarness) {
		harnesss.add(newHarness);
	}

	public Harness findHarness(String make, int modelNumber) {
		Harness harness;
		if (!isEmpty()) {
			for (int i = 0; (i < harnesss.size()); i++) {
				harness = harnesss.get(i);
				if (make.equals(harness.getModelNumber()) && modelNumber == harness.getModelNumber()) {
					return harness;
				}
			}
		}
		return null;
	}

	public Harness checkHarness(String make, int modelNumber, String instructor) {

		Harness harness;
		harness = findHarness(make, modelNumber);
		if (harness != null) {
			if (!harness.isHarnessOnLoan()) {
				harness.checkHarness(instructor);
				return harness;
			}
		} 
		return null;
	}

	public Harness loanHarness(String nameOnLoan) {
		Harness harness;
		for (int i = 0; i < harnesss.size(); i++) {
			harness = harnesss.get(i);
			if (harness.canHarnessBeLoaned()) {
				harness.setNameOnLoan(nameOnLoan);
				return harness;
			}
		}
		return null;
	}
	
	public Harness returnHarness (String make, int modelNumber) {
		Harness harness;
		harness = findHarness(make, modelNumber);
		if (harness.isHarnessOnLoan()) {
			harness.setOnLoan(false);
			harness.setNameOnLoan(null);
			return harness;		
		}
		return null;
	}
	
	public Harness removeHarness(String make, int modelNumber) {
		Harness harness;
		harness = findHarness(make, modelNumber);
		if (harness != null) {
			harnesss.remove(harness);
			return harness;
		}
		return null;
	}

}
