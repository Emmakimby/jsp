package survey;

public class ResultDto {
	private long TypeNo;
	private String Type;
	private long tatal;

	public ResultDto() {
	}

	public ResultDto(long TypeNo, String Type, long tatal) {
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

	public long getTatal() {
		return tatal;
	}

	public void setTatal(long tatal) {
		this.tatal = tatal;
	}

	@Override
	public String toString() {
		return TypeNo+". "+Type+" -------- "+tatal+"마리";
	}

}
