package homework3;

public class LockDList extends DList{
	
	public void lockNode(DListNode node) {
		LockDListNode lockNode = (LockDListNode) node;
		lockNode.isLocked = true;
	}
	
	@Override
	protected DListNode newNode(Object item, DListNode prev, DListNode next) {
	    return new LockDListNode(item, prev, next);
	}
	
	@Override
	public void remove(DListNode node) {
		if (node != null) {
			LockDListNode lockNode = (LockDListNode) node;
			if (lockNode.isLocked == null || !lockNode.isLocked) {
				super.remove(node);
			}
		}
	}
	
}
