package homework3;

public class LockDListNode extends DListNode{
	public Boolean isLocked;
	public LockDListNode(Object i, DListNode p, DListNode n) {
		super(i,p,n);
	    this.isLocked = null;
	}
}
