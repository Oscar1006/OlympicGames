package model;

public class Country implements Comparable<Country> {
	
	private String name;
	
	private int masculineGoldMedals;
	private int masculineSilverMedals;
	private int masculineBronceMedals;
	
	private int feminineGoldMedals;
	private int feminineSilverMedals;
	private int feminineBronceMedals;
	
	private int gold;
	private int silver;
	private int bronce;
	
	public Country(String name, int masculineGoldMedals, int masculineSilverMedals, int masculineBronceMedals, int feminineGoldMedals, int feminineSilverMedals, int feminineBronceMedals) {
		this.name = name;
		this.masculineGoldMedals = masculineGoldMedals;
		this.masculineSilverMedals = masculineSilverMedals;
		this.masculineBronceMedals = masculineBronceMedals;
		this.feminineGoldMedals = feminineGoldMedals;
		this.feminineSilverMedals = feminineSilverMedals;
		this.feminineBronceMedals = feminineBronceMedals;
		gold = masculineGoldMedals + feminineGoldMedals;
		silver = masculineSilverMedals +feminineSilverMedals;
		bronce = masculineBronceMedals + feminineBronceMedals;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMasculineGoldMedals() {
		return masculineGoldMedals;
	}

	public int getMasculineSilverMedals() {
		return masculineSilverMedals;
	}

	public int getMasculineBronceMedals() {
		return masculineBronceMedals;
	}

	public int getFeminineGoldMedals() {
		return feminineGoldMedals;
	}

	public int getFeminineSilverMedals() {
		return feminineSilverMedals;
	}

	public int getFeminineBronceMedals() {
		return feminineBronceMedals;
	}
	
	public String getMasculineMedals() {
		return name + " " + masculineGoldMedals + " " + masculineSilverMedals + " " + masculineBronceMedals;
	}
	
	public String getFeminineMedals() {
		return name + " " + feminineGoldMedals + " " + feminineSilverMedals + " " + feminineBronceMedals;
	}
	
	
	public String getMedals() {
		return name + " " + getGold() + " " + getSilver()+ " " + getBronce();
	}

	//Feminine medals
	@Override
	public int compareTo(Country o) {
		int result = 0;
		
		if (this.getFeminineGoldMedals() < o.getFeminineGoldMedals()) {
			result = -1;
		}else if (this.getFeminineGoldMedals() > o.getFeminineGoldMedals()) {
			result = 1;
		}
		
		if (result == 0) {
			if (this.getFeminineSilverMedals() < o.getFeminineSilverMedals()) {
				result = -1;
			}else if (this.getFeminineSilverMedals() > o.getFeminineSilverMedals()) {
				result = 1;
			}
		}
		
		if (result == 0) {
			if (this.getFeminineBronceMedals() < o.getFeminineBronceMedals()) {
				result = -1;
			}else if (this.getFeminineBronceMedals() > o.getFeminineBronceMedals()) {
				result = 1;
			}
		}
		
		if (result == 0) {
			result = this.getName().compareTo(o.getName()) * -1;
		}
		
		return result;
	}

	public int getGold() {
		return gold;
	}

	public int getSilver() {
		return silver;
	}

	public int getBronce() {
		return bronce;
	}
}
