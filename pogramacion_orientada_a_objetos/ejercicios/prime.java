class Prime{

    public boolean isPrime(int value){
		for(int i = 2; i <= value / 2; i++){
			if(value % i == 0){
				return false;
			}
		}
		return true;
	}
	public int sumPrimesUpTo50(){
		int total = 2;
		for(int i = 3; i < 50; i += 2){
			if(this.isPrime(i)){
				total += i;
			}
		}
        return total;
	}
    public int sum50Primes(){
		int total = 2;
        int j = 0;
		for(int i = 3; j < 50; i += 2){
			if(this.isPrime(i)){
				total += i;
                j += 1;
			}
		}
        return total;
	}

    public static void main(String[] args) {
		Prime prime = new Prime();
        System.out.println("Sum primes to 50: " + prime.sumPrimesUpTo50());
        System.out.println("Sum 50 primes: " + prime.sum50Primes());
  	}
}