
// TODO: Auto-generated Javadoc
/**
 * The Class CreditCard.
 * @author Katya Bezugla
 */
public class CreditCard {
	
	/** The balance. */
	private Money balance;
	
	/** The credit limit. */
	private Money creditLimit;
	
	/** The owner. */
	private Person owner;
	
	/**
	 * Instantiates a new credit card.
	 *
	 * @param newCardHolder the owner
	 * @param limit the credit limit
	 */
	public CreditCard(Person newCardHolder, Money limit) {
		owner = newCardHolder;
		creditLimit = new Money(limit);
		balance = new Money(0);
	}
	
	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public Money getBalance() {
		return new Money(balance);
	}
	
	/**
	 * Gets the credit limit.
	 *
	 * @return the credit limit
	 */
	public Money getCreditLimit() {
		return new Money(creditLimit);
	}
	
	/**
	 * Gets the owner's details.
	 *
	 * @return the owner's details
	 */
	public String getPersonals() {
		return owner.toString();
	}
	
	/**
	 * Charges the credit card, and prints out an exception if it can't be charged.
	 *
	 * @param amount the amount needed to be charged
	 */
	public void charge(Money amount) {
		Money money = balance.add(amount);
		if (money.getMoney() <= creditLimit.getMoney()) {
			System.out.println("Charge: " + amount.toString()); 
			balance = money; 
		} else {
			System.out.println("Exceeds credit limit");
		}
	}
	
	/**
	 * Makes a payment using the credit card, and prints out an exception if it can't be made.
	 *
	 * @param amount the amount needed to be payed
	 */
	public void payment(Money amount) {
		Money money = balance.subtract(amount);
		if (money.getMoney() >= 0.0) {
			System.out.println("Payment: " + amount.toString()); 
			balance = money; 
		} else {
			System.out.println("Exceeds balance"); 
		}
	}
}
