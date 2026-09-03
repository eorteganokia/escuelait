class Date {
	private final int[] DAYS_PER_MONTHS = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year){
		this.set(day, month, year);
	}
	public Date(String date){
		String[] splitted = date.split("[/]");
		this.set(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
	}
	public Date(Date date){
		this.set(date.day, date.month, date.year);
	}
	public Date(){
		this.set(1, 1, 1970);
	}

    public void set(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
    private int daysPerMonth(int month){
		assert month > 0 && month <= 12: "Month must be between 1 and 12.";
		int days = DAYS_PER_MONTHS[month - 1];
		if(month == 2 && this.isLeapYear()){
			days = 29;
		}
		return days;
	}
	public boolean equals(Date date){
		return this.day == date.day && this.month == date.month && this.year == date.year;
	}
	public boolean isGreaterThan(Date date){ 
		return this.year > date.year || this.month > date.month || (this.day > date.day && this.month == date.month); 
	}
	public boolean isLowerThan(Date date){ 
		return !this.isGreaterThan(date) && !this.equals(date);
	}
	public void add(int days){
		for(int i = 0; i < days; i++){
			this.day++;
			if(this.day > this.daysPerMonth(this.month)){
				this.day = 1;
				this.month++;
			}
			if(this.month > 12){
				this.month = 1;
				this.year++;
			}
		}
	}
	public int difference(Date date){
		if(this.year == date.year){
			return date.dayOfYear() - this.dayOfYear();
		}
		return 0;
	}
	public boolean isValid(int day, int month, int year){ 
		return year > 0 && month > 0 && month <= 12 && day > 0 && day <= this.daysPerMonth(month);
	}
	public boolean isLeapYear(){ 
		return this.year % 4 == 0 && this.year % 100 != 0 && this.year % 400 == 0; 
	}
	public int dayOfYear(){
		int totalDays = 0;
		for(int i = 1; i < this.month; i++){
			totalDays += this.daysPerMonth(i);
		}
        totalDays += this.day;
		return totalDays;
	}
	public String dayOfWeek(){return "";}
	public int weekOfYear(){
		return this.dayOfYear() / 7 + 1;
	}
	public void print(){
		System.out.println(String.format("%d/%d/%d", this.day, this.month, this.year));
	}

	public static void main(String[] args) {
		Date date = new Date(17, 1, 2024);
		Date date2 = new Date("1/1/2024");
		int days = 360;

		System.out.println("Equals: " + date.equals(date2));
		date.print();
		System.out.println("Week of year: " + date.weekOfYear());
		System.out.println("gt: " + date.isGreaterThan(new Date(18, 1, 2024)));
		System.out.println("Add: " + days);
		date.add(days);
		date.print();
	}	
}
