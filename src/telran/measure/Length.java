package telran.measure;

import java.util.Arrays;
import java.util.stream.Stream;

public class Length implements Comparable<Length> {
	private float amount;
	private LengthUnit lengthUnit;

	public Length(float amount, LengthUnit lengthUnit) {
		this.amount = amount;
		this.lengthUnit = lengthUnit;
	}

	@SuppressWarnings("static-access")
	@Override
	/**
	 * equals two Length objects according to LengthUnit and amount 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		boolean res = true;
		String objString = obj.toString();
		if (!objString.equals(toString())) {
			String objAmount = objString.split("[a-zA-Z]")[0];
			String objUnit = objString.substring(objAmount.length(), objString.length());
			Length newObj = new Length(Float.parseFloat(objAmount), lengthUnit.valueOf(objUnit));
			res = this.toString().equals(newObj.convert(this.getUnit()).toString());
		}
		return res;
	}

	@Override
	/**
	 * @param o
	 * @return < 0 "this" object less than "o" object, > 0 "this" object greater
	 *         than "o" object, == 0 "this" object equals "o" object,
	 */
	public int compareTo(Length o) {
		if (!this.getUnit().equals(o.getUnit())) {
			o = o.convert(this.getUnit());
		}
		return (int) this.getAmount() - (int) o.getAmount();
	}

	/**
	 * @param unit
	 * @return new Length object with a given LengthUnit
	 */
	public Length convert(LengthUnit unit) {
		return new Length(convertAmount(unit), unit);
	}

	private float convertAmount(LengthUnit unit) {
		return getUnit().getValue() * amount / unit.getValue();
	}

	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 */
	public String toString() {
		return amount + getUnit().toString();
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return lengthUnit;
	}
}
