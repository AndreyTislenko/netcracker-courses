package myLinkedList;

import linkedListInterface.ILinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> head;
    private int size;

    //Just some private handy methods
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    private Node<E> getNode(int index) {
        if (head == null) {
            throw new emptyMyLinkedListException("There is no node, because the list is empty!");
        }
        checkPositionIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return  current;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void add(E element) {
        if (head == null) {
            head = new Node<E>(element, head);
        } else {
            Node<E> temporary = head;
            while (temporary.next != null) {
                temporary = temporary.next;
            }
            temporary.next = new Node<E>(element, null);
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            add(element);
        } else {
            if (index == 0) {
                head = new Node<E>(element, head);
            } else {
                Node<E> previous = getNode(index - 1);
                previous.next = new Node<E>(element, previous.next);
            }
            size++;
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return  getNode(index).data;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> current = head; current != null; current = current.next) {
                if (current.data == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> current = head; current != null; current = current.next) {
                if (element.equals(current.data)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        E removedData = head.data;
        if (index == 0) {
            head = head.next;
        } else {
            Node<E> previous = getNode(index - 1);
            removedData = previous.next.data;
            previous.next = previous.next.next;
        }
        size--;
        return removedData;
    }

    @Override
    public E set(int index, E element) {
        Node<E> oldNode = getNode(index);
        E oldData = oldNode.data;
        oldNode.data = element;
        return oldData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
   /*
    * The main purpose of passed array (E[] yourArray) is to tell the type of array.
    * The returned array is of same type as passed array.
    */
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] yourArray) {
        if (yourArray.length != size) {
            yourArray = (E[]) java.lang.reflect.Array.newInstance(yourArray.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = yourArray;
        for (Node<E> x = head; x != null; x = x.next) {
            result[i++] = x.data;
        }
        return yourArray;
    }

    @Override
    public Iterator<E> iterator() {
        return new ILinkedListIterator();
    }

    /*
     *  Returns a string representation
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Object x : this) {
            result.append(x).append(" ");
        }
        return result.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return size == that.size &&
                Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }

    /*******************************************************
     *  The Node class
     ********************************************************/
    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }

    /*******************************************************
     *  The Iterator class
     ********************************************************/
    public class ILinkedListIterator implements Iterator<E> {
        private Node<E> nextNode;

        private ILinkedListIterator() {
            nextNode = head;
        }

        public boolean hasNext() {
            return  nextNode != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = nextNode.data;
            nextNode = nextNode.next;
            return result;
        }
    }

    private static class emptyMyLinkedListException extends RuntimeException {
        private emptyMyLinkedListException(String message) {
            super(message);
        }
    }

}
