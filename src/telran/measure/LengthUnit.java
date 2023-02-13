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
		if(!l1.getUnit().equals(l2.getUnit())) {
			l2 = l2.convert(l1.getUnit());
		}
		return new Length((l2.getAmount() - l1.getAmount()), l1.getUnit());
	}

	public float getValue() {
		return value;
	}
}