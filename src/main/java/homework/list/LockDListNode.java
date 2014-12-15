package homework.list;

public class LockDListNode extends DListNode{
	public boolean isLocked;
	public LockDListNode(Object i, DListNode p, DListNode n, boolean isLocked) {
		super(i,p,n);
	    item = i;
	    prev = p;
	    next = n;
	    this.isLocked = isLocked;
	}
}
