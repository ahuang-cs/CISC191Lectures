package edu.sdccd.cisc191;

import java.util.*;

public class DoublyLinkedList<T> implements List<T> {
    Node head;

    class Node {
        T data;
        Node prev;
        Node next;
        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoublyLinkedList(){}

    private int size(Node head) {
        if(head == null) return 0;
        return size(head.next) + 1;
    }
    @Override
    public int size() {
        return size(head);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private Node get(Node head, T data) {
        if(head == null) return null;
        if(head.data.equals(data)) return head;
        return get(head.next, data);
    }
    @Override
    public boolean contains(Object o) {
        return get(head, (T) o) != null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node currentNode = head;
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

    private Node toArray(Node head, List<T> list) {
        if(head == null) return null;
        list.add(head.data);
        return toArray(head.next, list);
    }

    @Override
    public Object[] toArray() {
        List<T> list = new ArrayList<>();
        toArray(head, list);
        return list.toArray();
    }


    private Node toArray(Node head, T[] arr, int index) {
        if(head == null) return null;
        arr[index] = head.data;
        return toArray(head.next, arr, ++index);
    }
    @Override
    public <T1> T1[] toArray(T1[] a) {
        int index = 0;
        toArray(head, (T[]) a, index);

        return a;
    }


    private Node getTail(Node head) {
        if(head.next == null) return head;
        return getTail(head.next);
    }

    @Override
    public boolean add(T t) {
        try {
            if(head == null) head = new Node(t, null, null);
            else {
                Node tail = getTail(head);
                tail.next = new Node(t, tail, null);
            }
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    private void remove(Node node) {
        if(node.prev != null) node.prev.next = node.next;
        else head = node.next;
        if(node.next != null) node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        node.data = null;
    }
    private Node remove(Node head, T data) {
        if(head == null) return null;
        if(head.data.equals(data)) {
            Node prev = head.prev;
            remove(head);
            return prev;
        }
        return remove(head.next, data);
    }
    @Override
    public boolean remove(Object o) {
        try {
            remove(head, (T) o);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    private Node containsAll(Node head, Set<T> set) {
        if(head == null) return null;
        set.remove(head.data);
        return containsAll(head.next, set);
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        Set<T> set = new HashSet<>((Collection<T>) c);
        containsAll(head, set);
        if(set.isEmpty()) return true;
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        try {
            addAll(size()==0 ? 0 : (size()-1), c);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        try {
            List<T> list = new ArrayList<>(c);
            Node curNode = null;
            int i = 0;
            for (T element : list) {
                if(i == 0) {
                    curNode = add(head, index, element);
                    i++;
                } else curNode = add(curNode, 0, element);
            }
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    private Node removeAll(Node head, Set<T> set) {
        if(head == null) return null;
        Node next = head.next;
        if(set.contains(head.data)) {
            remove(head);
        }
        return removeAll(next, set);
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            removeAll(head, new HashSet<>((Collection<T>) c));
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    private Node retainAll(Node head, Set<T> set) {
        if(head == null) return null;
        Node next = head.next;
        if(!set.contains(head.data)) {
            remove(head);
        }
        return retainAll(next, set);
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            retainAll(head, new HashSet<>((Collection<T>) c));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private Node clear(Node head) {
        if(head == null) return null;
        Node next = head.next;
        remove(head);
        return clear(next);
    }
    @Override
    public void clear() {
        clear(head);
    }

    private Node get(Node head, int index) {
        if(head == null) return null;
        if(index == 0) return head;
        return get(head.next, --index);
    }
    @Override
    public T get(int index) {
        Node node = get(head, index);
        if(node != null) return node.data;
        return null;
    }

    private Node set(Node head, int index, T data) {
        if(head == null) return null;
        if(index == 0) {
            head.data = data;
            return head;
        }
        return set(head.next, --index, data);
    }
    @Override
    public T set(int index, T element) {
        Node node = set(head, index, element);
        if(node != null) return node.data;
        return null;
    }

    private Node add(Node head, int index, T data) {
        if(index == 0) {
            if(this.head == null) {
                this.head = new Node(data, null, null);
                return this.head;
            }
            else {
                Node next = head.next;
                head.next = new Node(data, head, next);
                if(next != null) next.prev = head.next;
                return head.next;
            }
        }
        return add(head.next, --index, data);
    }

    @Override
    public void add(int index, T element) {
        add(head, index, element);
    }

    private T remove(Node head, int index) {
        if(index == 0) {
            T data = head.data;
            remove(head);
            return data;
        }
        return remove(head.next, --index);
    }
    @Override
    public T remove(int index) {
        return remove(head, index);
    }

    private int indexOf(Node head, T data) {
        if(head == null) return Integer.MIN_VALUE;
        if(head.data.equals(data)) return 0;
        return indexOf(head.next, data) + 1;
    }
    @Override
    public int indexOf(Object o) {
        int index = indexOf(head, (T) o);
        return index < 0 ? -1: index;
    }


    private int lastIndexOf(Node tail, T data) {
        if(tail == null) return Integer.MIN_VALUE;
        if(tail.data.equals(data)) return 0;
        return lastIndexOf(tail.prev, data) + 1;
    }
    @Override
    public int lastIndexOf(Object o) {
        int offset = lastIndexOf(getTail(head), (T) o);
        if(offset < 0) return -1;
        return (size() - 1) - offset;
    }

    @Override
    public ListIterator<T> listIterator() {
       return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListIterator<T>() {
            Node currentNode = get(head, index);
            Node lastNode = null;
            int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if(lastNode == currentNode) return null;
                lastNode = currentNode;

                if(lastNode.next != null) {
                    currentNode = currentNode.next;
                    currentIndex++;
                }
                return lastNode.data;
            }

            @Override
            public boolean hasPrevious() {
                return currentNode.prev != null;
            }

            @Override
            public T previous() {
                Node node = currentNode;
                currentNode = currentNode.prev;
                lastNode = node;
                currentIndex--;

                return currentNode == null ? null  : currentNode.data;
            }

            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                DoublyLinkedList.this.remove(lastNode);
            }

            @Override
            public void set(T t) {
                if(lastNode != null) lastNode.data = t;
            }

            @Override
            public void add(T t) {
                lastNode = null;
                Node next = currentNode.next;
                currentNode.next = new Node(t, currentNode, next);
                if(next != null) next.prev = currentNode.next;
            }
        };
    }

    private Node subList(Node head, List<T> list, int index) {
        if(head == null) return null;
        list.add(head.data);
        if(index == 0) return head;

        return subList(head.next, list, --index);
    }
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> list = new ArrayList<>();
        Node start = get(head, fromIndex);
        subList(start, list, toIndex - fromIndex);
        return list;
    }


    private String toString(Node head) {
        if(head.next == null) return head.data.toString();
        else return head.data + " " + toString(head.next);
    }

    @Override
    public String toString() {
        if(head == null) return "";
        return toString(head);
    }
}
