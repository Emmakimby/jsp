package survey;

public class ResultavgDto {
	private long TypeNo;
	private String Type;
	private float tatal;

	public ResultavgDto() {
	}

	public ResultavgDto(long TypeNo, String Type, float tatal) {
		this.TypeNo = TypeNo;
		this.Type = Type;
		this.tatal = tatal;
	}

	public long getTypeNo() {
		return TypeNo;
	}

	public void setTypeNo(long typeNo) {
		TypeNo = typeNo;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public float getTatal() {
		return tatal;
	}

	public void setTatal(long tatal) {
		this.tatal = tatal;
	}

	@Override
	public String toString() {
		return TypeNo+". "+Type+" -------- "+tatal+"살";
	}

}
