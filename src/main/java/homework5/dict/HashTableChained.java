/* HashTableChained.java */
package homework5.dict;

import homework5.list.DList;
import homework5.list.DListNode;

/**
 * HashTableChained implements a Dictionary as a hash table with chaining. All
 * objects used as keys must have a valid hashCode() method, which is used to
 * determine which bucket of the hash table an entry is stored in. Each object's
 * hashCode() is presumed to return an int between Integer.MIN_VALUE and
 * Integer.MAX_VALUE. The HashTableChained class implements only the compression
 * function, which maps the hash code to a bucket in the table's range.
 * 
 * DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

	/**
	 * count of hash table data.
	 */
	private int count;
	/**
	 * hash table data.
	 */
	private DList[] hashTable;

	/**
	 * Construct a new empty hash table with a default size. Say, a prime in the
	 * neighborhood of 100.
	 **/

	public HashTableChained() {
		this.createNewHashTableChained(100);
	}

	/**
	 * Construct a new empty hash table intended to hold roughly sizeEstimate
	 * entries. (The precise number of buckets is up to you, but we recommend
	 * you use a prime number, and shoot for a load factor between 0.5 and 1.)
	 **/

	public HashTableChained(int sizeEstimate) {
		this.createNewHashTableChained(sizeEstimate);
	}

	/**
	 * Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
	 * to a value in the range 0...(size of hash table) - 1.
	 * 
	 * This function should have package protection (so we can test it), and
	 * should be used by insert, find, and remove.
	 **/

	private int compFunction(int code) {
		return code % (this.hashTable.length);
	}

	private void createNewHashTableChained(int size) {
		this.hashTable = new DList[size];
	}

	/**
	 * Search for an entry with the specified key. If such an entry is found,
	 * return it; otherwise return null. If several entries have the specified
	 * key, choose one arbitrarily and return it.
	 * 
	 * This method should run in O(1) time if the number of collisions is small.
	 * 
	 * @param key
	 *            the search key.
	 * @return an entry containing the key and an associated value, or null if
	 *         no entry contains the specified key.
	 **/

	@Override
	public Entry find(Object key) {
		Entry entry = null;
		int index = this.compFunction(key.hashCode());
		DListNode node = this.findNode(index, key);
		if (node != null) {
			entry = (Entry) node.item;
		}
		return entry;
	}

	private DListNode findNode(int index, Object key) {
		DListNode node = null;
		DList list = this.hashTable[index];
		if ((list != null) && !list.isEmpty()) {
			DListNode move = list.front();

			while ((move != null) && !((Entry) move.item).key.equals(key)) {
				move = list.next(move);
			}

			if (((Entry) move.item).key.equals(key)) {
				node = move;
			}

		}
		return node;
	}

	/**
	 * Create a new Entry object referencing the input key and associated value,
	 * and insert the entry into the dictionary. Return a reference to the new
	 * entry. Multiple entries with the same key (or even the same key and
	 * value) can coexist in the dictionary.
	 * 
	 * This method should run in O(1) time if the number of collisions is small.
	 * 
	 * @param key
	 *            the key by which the entry can be retrieved.
	 * @param value
	 *            an arbitrary object.
	 * @return an entry containing the key and value.
	 **/

	@Override
	public Entry insert(Object key, Object value) {
		Entry entry = new Entry();
		entry.key = key;
		entry.value = value;
		int index = this.compFunction(key.hashCode());
		DList list = this.hashTable[index];

		if (list == null) {
			list = new DList();
		}

		list.insertBack(entry);
		this.count++;
		return entry;
	}

	/**
	 * Tests if the dictionary is empty.
	 * 
	 * @return true if the dictionary has no entries; false otherwise.
	 **/

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	/**
	 * Remove all entries from the dictionary.
	 */
	@Override
	public void makeEmpty() {
		for (int i = 0, length = this.hashTable.length; i < length; i++) {
			this.hashTable[i] = null;
		}
	}

	/**
	 * Remove an entry with the specified key. If such an entry is found, remove
	 * it from the table and return it; otherwise return null. If several
	 * entries have the specified key, choose one arbitrarily, then remove and
	 * return it.
	 * 
	 * This method should run in O(1) time if the number of collisions is small.
	 * 
	 * @param key
	 *            the search key.
	 * @return an entry containing the key and an associated value, or null if
	 *         no entry contains the specified key.
	 */

	@Override
	public Entry remove(Object key) {
		Entry entry = null;
		int index = this.compFunction(key.hashCode());
		if (!this.isEmpty()) {
			DListNode node = this.findNode(index, key);
			if (node != null) {
				this.hashTable[index].remove(node);
				this.count--;
				entry = (Entry) node.item;
			}
		}

		return entry;
	}

	/**
	 * Returns the number of entries stored in the dictionary. Entries with the
	 * same key (or even the same key and value) each still count as a separate
	 * entry.
	 * 
	 * @return number of entries in the dictionary.
	 **/

	@Override
	public int size() {
		return this.count;
	}
}
