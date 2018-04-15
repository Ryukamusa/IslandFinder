package Model;

public class ArroundIsland {
	private Integer code;
	private boolean island;

	public ArroundIsland() {
		this.code = null;
		this.island = false;
	}

	public int getCode() {
		return code;
	}

	public boolean isIsland() {
		return island;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}

	public void setIsland(boolean island) {
		this.island = island;
	}
	
}
