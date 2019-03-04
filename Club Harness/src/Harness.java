
public class Harness {

	private static final int MAX_USES = 25;
	private String make;
	private int modelNumber;
	private int usage;
	private String lastCheck;
	private boolean onLoan;
	private String nameOnLoan;

	public Harness(String make, int modelNumber, int usage, String lastCheck, boolean onLoan, String nameOnLoan) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.usage = usage;
		this.lastCheck = lastCheck;
		this.onLoan = onLoan;
		if (onLoan) {
			this.nameOnLoan = nameOnLoan;
		} else {
			this.nameOnLoan = null;
		}
	}
	
	public Harness(String make,int modelNumber,String lastCheck) 
	{
		this.make = make;
		this.modelNumber = modelNumber;
		this.usage = 0;
		this.lastCheck = lastCheck;
		this.onLoan = false;
		this.nameOnLoan = null;
	}
	
	public void checkHarness(String lastCheck) {
		if (!isHarnessOnLoan()) {
			this.usage = 0;
			this.lastCheck = lastCheck;
		}
	}
	
	public boolean canHarnessBeLoaned() {
		if (!isHarnessOnLoan() && usage < MAX_USES) {
			return true;
		}
		return false;
	} 
	
	public void loanHarness (String nameOnLoan) {
		if (canHarnessBeLoaned()) {
			setOnLoan(true);
			setNameOnLoan(nameOnLoan);
			int uses = getUsage();
			uses ++;
			setUsage(uses);
		}
	}
	
	public void returnHarness() {
		if (isHarnessOnLoan()) {
			setOnLoan(false);
			setNameOnLoan(null);
		}
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}
	public int getUsage() {
		return usage;
	}

	public void setUsage(int usage) {
		this.usage = usage;
	}

	public String getLastCheck() {
		return lastCheck;
	}

	public void setLastCheck(String lastCheck) {
		this.lastCheck = lastCheck;
	}

	public boolean isHarnessOnLoan() {
		return onLoan;
	}

	public void setOnLoan(boolean onLoan) {
		this.onLoan = onLoan;
	}

	public String getNameOnLoan() {
		return nameOnLoan;
	}

	public void setNameOnLoan(String nameOnLoan) {
		this.nameOnLoan = nameOnLoan;
	}

	@Override
	public String toString() {
		return "Harness [make=" + make + ", modelNumber=" + modelNumber + ", usage=" + usage + ", lastCheck="
				+ lastCheck + ", onLoan=" + onLoan + ", nameOnLoan=" + nameOnLoan + "]";
	}

}
