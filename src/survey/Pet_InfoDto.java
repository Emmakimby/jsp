package survey;

public class Pet_InfoDto {

	private long number;
	private long TypeNo;
	private String name;
	private long PetAge;
	
	public Pet_InfoDto() {
		
	}
	
	public Pet_InfoDto(long number, long TypeNo, String name, long PetAge) {
		super();
		this.number = number;
		this.TypeNo = TypeNo;
		this.name = name;
		this.PetAge = PetAge;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public long getTypeNo() {
		return TypeNo;
	}

	public void setTypeNo(long typeNo) {
		TypeNo = typeNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPetAge() {
		return PetAge;
	}

	public void setPetAge(long petAge) {
		PetAge = petAge;
	}
	
	@Override
	public String toString() {
		return "Pet_InfoVo [number=" + number + ", 반려동물 종류="+TypeNo+", 반려동물 이름="+name+", 반려동물 나이="+ PetAge+ "살" + "]";
	}
	
}
