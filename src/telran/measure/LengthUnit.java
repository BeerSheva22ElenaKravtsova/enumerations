package telran.measure;

public enum LengthUnit {
	MM(1), CM(10), IN(25.4f), M(1000), KM(1_000_000);
	float value;

	LengthUnit(float value) {
		this.value = value;
	}
	
	/**
	 * 
	 * @param l1
	 * @param l2
	 * @return Length object as length between l1 and l2 in "this" units
	 */
	public Length between(Length l1, Length l2) {
			Length length1 = l1.convert(this);
			Length length2 = l2.convert(this);
		return new Length((length2.getAmount() - length1.getAmount()), this);
	}

	public float getValue() {
		return value;
	}
}