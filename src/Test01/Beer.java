package Test01;

/*
 * 数据模型，啤酒
 */
class Beer {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCapabality() {
		return capabality;
	}

	public void setCapabality(double capabality) {
		this.capabality = capabality;
	}

	public String getShap() {
		return shap;
	}

	public void setShap(String shap) {
		this.shap = shap;
	}

	private String name;
	private double capabality;
	private String shap;

	public String toString() {
		return "Berr [name=" + name + ",capablity=" + capabality + ",shap=" + shap + "]";
	}
}