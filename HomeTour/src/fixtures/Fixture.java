package fixtures;

public abstract class Fixture {
	String name;
	String shortDesc;
	String longDesc;
	
	public Fixture(String name,String shortDesc,String longDesc) {
		this.name = name;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
	}
	public String getName() {
		return this.name;
	}
	public String[] getDescs() {
		String[] descs = new String[2];
		descs[0] = this.shortDesc;
		descs[1] = this.longDesc;
		return descs;
	}
}

