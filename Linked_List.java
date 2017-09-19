package lab6;

public class Linked_List<T> implements List_Interface {
	private Node head, tail;
	private int listSize;
	
	private class Node {
		T value;
		Node next;
	}
	
	public Linked_List() {
		head = tail = null;
		listSize = 0;
	}
	
	private Object getNodeAt(int index){
		
		if(index+1 > listSize || index < 0 || isEmpty()){
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		
		Node nodePtr = new Node();
		nodePtr = head;
		
		for(int i = 0; i < index; i++){
			nodePtr = nodePtr.next;
		}
		
		return nodePtr;
	}
	
	@Override
	public T getAt(int index) {
		
		if(index+1 > listSize || index < 0 || isEmpty()){
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		Node nodePtr = new Node();
		nodePtr = head;
		
		for(int i = 0; i < index; i++ ){
			nodePtr = nodePtr.next;
		}
		return nodePtr.value;
	}

	@Override
	public T setAt(int index, Object item) {
		
		if(index+1 > listSize || index < 0 || isEmpty()){
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		
		Node nodePtr = new Node();
		nodePtr = head;
		nodePtr.next = head.next;
		
		for(int i = 0; i<index; i++){
			nodePtr = nodePtr.next;
		}
		
		nodePtr.value = (T)item;
		return nodePtr.value;
	}

	@Override
	public boolean isEmpty() {
		return this.listSize == 0;
	}

	@Override
	public int getSize() {
		return this.listSize;
	}

	@Override
	public void clear() {
		if(isEmpty())
			return;
		
		head = null;
		tail = null;
		zeroList();
	}

	@Override
	public boolean contains(Object item) {
		if(isEmpty()){
			return false;
		}
		
		Node nodePtr = new Node();
		nodePtr = head;
		nodePtr.next = head.next;
		
		while(nodePtr != null){
			if(nodePtr.value == item){
				return true;
			}
			nodePtr = nodePtr.next;
		}
		return false;
	}

	@Override
	public void addToEnd(Object item) {
		
		Node newNode = new Node();
		newNode.value = (T)item;
	
		if(isEmpty()){
			head = newNode;
			newNode.next = tail;
			tail = newNode;
			
			increaseSize();
		}else{
			
			Node nodePtr = new Node();
			Node currentNode = new Node();
			nodePtr = head;
			
			while(nodePtr != tail){
				nodePtr = nodePtr.next;
			}
			currentNode = nodePtr;
			tail = newNode;
			tail.next = null;
			nodePtr.next = newNode;
			newNode.next = null;
			
			currentNode.next = nodePtr;
			nodePtr.next = tail;
			increaseSize();
		}
		
	}

	@Override
	public void insert(int index, Object item) {
		
		if( index < 0 || index > listSize){
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		
		if( index == listSize ){
			//System.out.println("sending " + item + " to addToEnd");
			addToEnd((T)item);
			return;
		}
		
		Node node = new Node();
		Node currentNode = new Node();
		node.value = (T)item;
		Node nodePtr = new Node();
		
		if(isEmpty()){
			head = node;
			node.next = tail;
			tail = node;
			
			increaseSize();
		}else if(index == 0){
			currentNode = head;
			nodePtr = head;
			nodePtr = nodePtr.next;
			currentNode.next = nodePtr;
			
			head = node;
			node.next = currentNode;
			
			increaseSize();
		}else{
			nodePtr = head;
			
			for(int i = 0; i<index; i++){
				nodePtr = nodePtr.next;
			}
			
			currentNode = nodePtr;
			nodePtr = nodePtr.next;
			node.next = nodePtr;
			currentNode.next = node;
			
			increaseSize();
			
		}
	}

	@Override
	public void remove(int index) {
		
		if(index+1 > listSize || index < 0 || isEmpty()){
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		
		if(listSize == 1){
			clear();
			return;
		}
		
		Node toRemove = new Node();
		Node connectTo = new Node();
		Node nodePtr = new Node();
		nodePtr = head;
		
		if(index == 0){
			toRemove = nodePtr;
			nodePtr = nodePtr.next;
			head = nodePtr;
			
			toRemove = null;
			decreaseSize();
		}else{
			for(int i = 0; i < index; i++){
				nodePtr = nodePtr.next;
			}
			
			connectTo = nodePtr;
			nodePtr = nodePtr.next;
			toRemove = nodePtr;
			nodePtr = nodePtr.next;
			connectTo.next = nodePtr;
			
			toRemove = null;
			decreaseSize();
		}
	}
	
	@Override
	public Object[] toArray() {
		Object[] array = new Object[listSize];
		
		for(int i = 0; i < getSize(); i++){
			array[i] = getAt(i);
		}
		return array;
	}
	
	public void increaseSize(){
		++this.listSize;
	}
	
	public void decreaseSize(){
		--this.listSize;
	}
	
	public void zeroList(){
		this.listSize = 0;
	}
}
