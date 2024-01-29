# 멤버 클래스는 되도록 static으로 만들라

### 중첩 클래스
- 정적 멤버 클래스
- 멤버 클래스 (내부 클래스)
- 익명 클래스 (내부 클래스)
- 지역 클래스 (내부 클래스)

### 정적 멤버 클래스의 특징
- 다른 클래스 안에 선언된다.
- 바깥 클래스의 private 멤버에도 접근할 수 있다. 

중첩 클래스의 인스턴스가 바깥 인스턴스와 독립적으로 존재할 수 있을때, 
혹은 멤버 클래스에서 바깥 인스턴스에 접근할 일이 없다면 무조건 static을 붙여서 정적 멤버 클래스로 만들자.
---

```java
private static class Entry<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Entry<K,V> next;
    
    protected Entry(int hash, K key, V value, Entry<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
```

private 정적 멤버 클래스는 바깥 클래스가 표현하는 객체의 한 부분을 나타낼 때 쓴다.

엔트리의 메서드들은 맵을 직접 사용하지는 않는다.

따라서 엔트리를 비정적 멤버 클래스로