
/**
 * Map entry class for use with Lab 9.  Specialized entry class
 * @author john1819
 *
 */
public class AddressEntry implements Comparable<AddressEntry> {
	String key;
	Address value;
	
	/**
	 * @param key
	 * @param value
	 */
	public AddressEntry(String key, Address value) {
		super();
		this.key = key;
		this.value = value;
	}

	
	@Override
	public String toString() {
		return " [key=" + key + ", value=" + value + "]";
	}


	@Override
	public int compareTo(AddressEntry o) {
		if (key.equals(o.key))
		{
			return 0;
		}
		else
		{
			return key.compareTo(o.key);
		}
	
	}

}
