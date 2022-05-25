package survey;

public class Man_InfoDto {
	

	private long number;
	private long age;
	private long house;
	private String pet;
	
	public Man_InfoDto() {
		
	}
	
	public Man_InfoDto(long number,long age, long house, String pet) {
		this.number = number;
		this.age = age;
		this.house = house;
		this.pet = pet;
	}

	public long getNumber() {
		return number;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public long getHouse() {
		return house;
	}

	public void setHouse(long house) {
		this.house = house;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}
	
	@Override
	public String toString() {
		return "Man_InfoVo [number=" + number + ", 나이="+ age+ "세, 가구원수=" + house + "명" + ", 반려동물 유무=" + pet + "]";
	}
	
}
