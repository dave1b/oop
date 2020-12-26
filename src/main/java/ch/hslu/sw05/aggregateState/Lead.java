package ch.hslu.sw05.aggregateState;

public class Lead extends Element{

	
	
	private enum CriticalTemps {
		MELTINGPOINT(327.43f), BOILINGPOINT(1750f);
	
		final private float critialTemp;
		CriticalTemps(final float critialTemp) {
			this.critialTemp = critialTemp;
		}
		private float getValue() {
			return this.critialTemp;
		}
	}

	

	public Lead (float temp) {
		super(CriticalTemps.MELTINGPOINT.getValue(), CriticalTemps.BOILINGPOINT.getValue(), temp);
	}
	
	
	
}
