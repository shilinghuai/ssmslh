package slh.bean;

public class MyHashMap<K,V> {
  MyNode<K,V>[] array = new MyNode[60];
  public int myHash(K k){
    return ((String)k).length();
  }
  public void put(K k,V v){
        array[myHash(k)] = new MyNode<K, V>(k,v);
  }
  public V get(K k){
    return array[myHash(k)].getValue();
  }
  public static void main(String[] args){
    MyHashMap myHashMap = new MyHashMap<String,String>();
    myHashMap.put("shilinghuai","dashuaigejiayou");
    System.out.println(myHashMap.get("shilinghuai"));
  }

}
