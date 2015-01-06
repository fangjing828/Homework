/* Tree234Node.java */

package homework6.dict;

/**
 * A Tree234Node is a node in a 2-3-4 tree (Tree234 class).
 * 
 * DO NOT CHANGE ANYTHING IN THIS FILE. You may add helper methods and
 * additional constructors, though.
 **/
class Tree234Node {

	/**
	 * keys is the number of keys in this node. Always 1, 2, or 3. key1 through
	 * key3 are the keys of this node. If keys == 1, the value of key2 doesn't
	 * matter. If keys < 3, the value of key3 doesn't matter. parent is this
	 * node's parent; null if this is the root. child1 through child4 are the
	 * children of this node. If this is a leaf node, they must all be set to
	 * null. If this node has no third and/or fourth child, child3 and/or child4
	 * must be set to null.
	 **/
	int keys;
	int key1;
	int key2;
	int key3;
	Tree234Node parent;
	Tree234Node child1;
	Tree234Node child2;
	Tree234Node child3;
	Tree234Node child4;

	Tree234Node(Tree234Node p, int key) {
		this.keys = 1;
		this.key1 = key;
		this.parent = p;
		this.child1 = null;
		this.child2 = null;
		this.child3 = null;
		this.child4 = null;
	}

	/**
	 * printSubtree() recursively prints this Tree234Node and its descendants as
	 * a tree (albeit sideways).
	 * 
	 * You're welcome to change this method if you like. It won't be tested.
	 **/
	public void printSubtree(int spaces) {
		if (this.child4 != null) {
			this.child4.printSubtree(spaces + 5);
		}
		if (this.keys == 3) {
			for (int i = 0; i < spaces; i++) {
				System.out.print(" ");
			}
			System.out.println(this.key3);
		}

		if (this.child3 != null) {
			this.child3.printSubtree(spaces + 5);
		}
		if (this.keys > 1) {
			for (int i = 0; i < spaces; i++) {
				System.out.print(" ");
			}
			System.out.println(this.key2);
		}

		if (this.child2 != null) {
			this.child2.printSubtree(spaces + 5);
		}
		for (int i = 0; i < spaces; i++) {
			System.out.print(" ");
		}
		System.out.println(this.key1);

		if (this.child1 != null) {
			this.child1.printSubtree(spaces + 5);
		}
	}

	/**
	 * toString() recursively prints this Tree234Node and its descendants as a
	 * String. Each node is printed in the form such as (for a 3-key node)
	 * 
	 * (child1)key1(child2)key2(child3)key3(child4)
	 * 
	 * where each child is a recursive call to toString, and null children are
	 * printed as a space with no parentheses. Here's an example. ((1)7(11
	 * 16)22(23)28(37 49))50((60)84(86 95 100))
	 * 
	 * DO NOT CHANGE THIS METHOD.
	 **/
	@Override
	public String toString() {
		String s = "";

		if (this.child1 != null) {
			s = "(" + this.child1.toString() + ")";
		}
		s = s + this.key1;
		if (this.child2 != null) {
			s = s + "(" + this.child2.toString() + ")";
		} else if (this.keys > 1) {
			s = s + " ";
		}
		if (this.keys > 1) {
			s = s + this.key2;
			if (this.child3 != null) {
				s = s + "(" + this.child3.toString() + ")";
			} else if (this.keys > 2) {
				s = s + " ";
			}
		}
		if (this.keys > 2) {
			s = s + this.key3;
			if (this.child4 != null) {
				s = s + "(" + this.child4.toString() + ")";
			}
		}
		return s;
	}
}
