interface Queue<E>{
    void add(E element);
    E element();
    boolean isEmpty();
    E remove();
    int size();
}