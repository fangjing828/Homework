package homework.list;

public class LockDList extends DList{
	public void lockNode(DListNode node) {
		LockDListNode lockNode = new LockDListNode(node.item, node.prev, node.next, true);
		lockNode.prev = node.prev;
		lockNode.next = node.next;
		
		node.prev.next = lockNode;
		node.next.prev = lockNode;
	}
	
	@Override
	public void remove(DListNode node) {
		if (node != null) {
			boolean isLockDListNode = node instanceof LockDListNode;
			if (!isLockDListNode || (isLockDListNode && !((LockDListNode) node).isLocked)) {
				node.prev.next = node.next;
				node.next.prev = node.prev;
				this.size --;
			}
		}
	}
	
}
