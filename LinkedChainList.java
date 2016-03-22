public class LinkedChainList<T> extends LinkedChainBase<T> implements ListInterface<T> {
    public LinkedChainList() {
        super();
    }

    public T remove(int givenPosition) {
        if (givenPosition < 1 || givenPosition > getLength()) {
            throw new IndexOutOfBoundsException("index: " + givenPosition);
        }

        if (givenPosition == 1) {
            return removeFirstNode();
        } else {
            Node nodeBefore = getNodeAt(givenPosition - 1);
            return removeAfterNode(nodeBefore);
        }
    }

    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        
        if (isEmpty()) {
            addFirstNode(newNode);
        } else {
            Node beforeNode = getNodeAt(getLength());
            addAfterNode(beforeNode, newNode);
        }
    }

    public void add(int newPosition, T newEntry) {
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);
            
            if (newPosition == 1) {
                addFirstNode(newNode);
            } else {
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            }
            
            numberOfEntries++;
        } else {
            //throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
 
    }

    public T replace(int givenPosition, T newEntry) {
        T originalEntry = null;
        
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            Node desiredNode = getNodeAt(givenPosition);
            originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
        } //else throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        
        return originalEntry;
    }

    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            return getNodeAt(givenPosition).getData();
        } // else throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        
        return null;
    }

    public boolean contains(T anEntry) {
        return false;
    }
    
    public Iterator<T> iterator() {
        return new IteratorForLinkedList();
    }
    
    public Iterator<T> getIterator() {
        return iterator();
    }
    
    private class IteratorForLinkedList implements Iterator<T> {
        private Node nextNode;
        
        private IteratorForLinkedList() {
            nextNode = firstNode;
        }
        
        public T next() {
            if (hasNext()) {
                Node returnNode = nextNode;
                nextNode = nextNode.getNextNode();
                
                return returnNode.getData();
            } else throw new IllegalArgumentException("Illegal call to next(); " + "iterator is after end of list.");
        }
        
        public boolean hasNext() {
            return nextNode != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove() is not "+ "supported by this iterator");
        }
    }
}