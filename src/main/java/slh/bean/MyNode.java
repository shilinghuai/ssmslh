package slh.bean;

public class MyNode<K,V> {
    int hash;
    K key;
    V value;
    MyNode<K,V> next;

  public MyNode(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public int getHash() {
    return hash;
  }

  public void setHash(int hash) {
    this.hash = hash;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public MyNode<K, V> getNext() {
    return next;
  }

  public void setNext(MyNode<K, V> next) {
    this.next = next;
  }
}
