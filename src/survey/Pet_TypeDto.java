package survey;

public class Pet_TypeDto {

	private long TypeNo;
	private String Type;

	public Pet_TypeDto() {

	}

	public Pet_TypeDto(long TypeNo, String Type) {
		this.TypeNo = TypeNo;
		this.Type = Type;
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

	@Override
	public String toString() {
		return TypeNo + ". " + Type;
	}
}
