//Cris Chou
//CYC180001

public class HashTableLinearProbe<K, V> {
	
	// global variables
	K[] keys = (K[]) new Object[3];
	V[] values = (V[]) new Object[3];
	int numElements = 0;
	int tableSize = 3;

	// insert method
	public boolean insert(K key, V value) {

		// check if key null or if table full
		if (key == null) {

			throw new IllegalArgumentException("Key value invalid or null");

		} else if (numElements == tableSize) {
			
			//if full rehash
			rehash();
			System.out.println("Rehashing");
			//throw new IllegalArgumentException("Table is full");	
		}
		
		//check for duplicate values
		for(int i = 0; i < tableSize; i++) {
			
			if(keys[i] == key) {
				
				return false;
			}
			
		}
		

		// get hash value of key
		int k = getHashValue(key);
		
		while (keys[k] != null) {
			
			k = (k+1) % tableSize;
			
			
		}
		keys[k] = key;
		values[k] = value;
		numElements++;

		return true;

	}

	public V find(K key) {
		// check if key null or if table full
		if (key == null) {

			throw new IllegalArgumentException("Key value invalid or null");

		}
		int k = getHashValue(key);

		while (keys[k] != null) {

			if (keys[k] == key) {

				return values[k];

			}
			k = (k+1) % tableSize;
		}

		return null;
	}

	public boolean delete(K key) {
		// check if key null or if table full
		if (key == null) {

			throw new IllegalArgumentException("Key value invalid or null");

		}
		int k = getHashValue(key);
		
		//find(key);
		

		while (keys[k] != null) {
			
			if (keys[k] == key) {
				
				keys[k] = null;
				values[k] = null;
					/*if(keys[k].deleted = true) {
						//already deleted
						return false;
					}*/
					
			//keys[k].deleted = true;
			return true;
			}
			k = (k+1) % tableSize;
		}
		return false;
	}

	public int getHashValue(K key) {

		return key.hashCode() % tableSize;

	}

	private void rehash() {
		//new hash table with double the size
		K[]newKeys = (K[]) new Object[tableSize*2];
		V[]newVals = (V[]) new Object[tableSize*2];
		
		K[]oldKeys = keys;
		V[]oldVals = values;
		
		keys = newKeys;
		values = newVals;
		numElements = 0;
		tableSize = newKeys.length;
		
		for(int i = 0; i < oldKeys.length; i++) {
			
			//check take make sure not deleted and not null
			if(oldKeys[i] !=null) {
				
				int k = getHashValue(oldKeys[i]);
				keys[k] = oldKeys[i];
				values[k] = oldVals[i];
				
			}
			
		}
		
		
	}

	//public class K {

		//E key;
		//boolean deleted = false;
	//}

}
