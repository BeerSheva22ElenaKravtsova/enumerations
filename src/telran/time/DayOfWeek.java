package telran.time;

public enum DayOfWeek {
	SUN, MON, TUE, WED, THU, FRI, SHABBAT;
	
	
	public DayOfWeek plusDays(int days) {
		DayOfWeek res = null;
		if(days<0) {
			res = minusDays(-days);
		} else {
			int seqNumCurrent = this.ordinal();//порядковый номер
			int seqNumRes = (seqNumCurrent + days)%7;//7 = values().length
			res = values()[seqNumRes];
		}
		return res;
	}

	public DayOfWeek minusDays(int days) {
		DayOfWeek res = null;
		if(days<0) {
			res = plusDays(-days);
		} else {
			int seqNumCurrent = this.ordinal();//порядковый номер
			int seqNumRes = (seqNumCurrent - days)%7;//7 = values().length
			if(seqNumRes<0) {
				seqNumRes += 7;
			}
			res = values()[seqNumRes];}
		return res;
	}
	
	public static int between(DayOfWeek dayOfWeek1, DayOfWeek dayOfWeek2) {
		int res = dayOfWeek2.ordinal() - dayOfWeek1.ordinal();
		if (res <=0) {
			res+=7;
		}
		
		return res;
	}
	

}
