import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WriteBinaryFile {
	private int primeAmount;
	
	public WriteBinaryFile(int primeAmount) {
		this.primeAmount = primeAmount;
		createStream(generatePrimes());
	}
	
	private ArrayList<Integer> generatePrimes() {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int num = 2;
		while (primes.size() < primeAmount) {
			try {
				if (isPrime(num)) {
					primes.add(num);
				}
			} catch (PrimeException e) {
				e.printStackTrace();
			}
			num++;
		}
		
		return primes;
	}
	
	private boolean isPrime(int num) throws PrimeException {
		for (int div = 2; div < num; div++){
			if (num % div == 0) {
				//throw new PrimeException(num);
				return false;
			}
		}
		
		return true;
	}
	private void createStream( ArrayList<Integer> primes) {
		
		try {
			DataOutputStream stream = new DataOutputStream(new FileOutputStream("outputPrimes.dat"));
		
			for (int prime : primes) {
				stream.writeInt(prime);
			}
			
			stream.flush();
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void appendStream(int lessThan) {
		
		try {
			DataInputStream stream = new DataInputStream(new FileInputStream("outputPrimes.dat"));
			DataOutputStream newStream = new DataOutputStream(new FileOutputStream("appendPrimeNumbers.dat", true));

			while((stream).available()>0) {
				int num = stream.readInt();
				try {
					if (isPrime(num)) {
						if (num <= lessThan) {
							newStream.writeInt(num);
						}
					}
				} catch (PrimeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
							
			newStream.flush();
			newStream.close();
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
