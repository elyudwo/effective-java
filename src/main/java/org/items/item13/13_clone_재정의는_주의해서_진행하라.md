# clone 재정의는 주의해서 진행하라


```java
public interface Cloneable {
}
```

추상 메서드가 하나도 없는 이 인터페이스는 clone의 동작 방식을 결정한다.

Cloneable을 구현한 객체에서 clone을 호출하면 객체의 필드들을 하나하나 복사한 객체를 반환.

그렇지 않은 클래스의 인스턴스에서 호출하면 CloneNotSupportedException을 던진다.


## clone 메서드의 일반 규약
- x.clone() != x
- x.clone().getClass() == x.getClass()
- x.clone().equals(x)
- x.clone().getClass() == x.getClass()

```java
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
```

```java
@Override
public Stack clone() {
    try {
        Stack result = (Stack) super.clone();
        result.elements = elements.clone();
        return result;
    } catch (CloneNotSupportedException e) {
        throw new AssertionError();
    }
}

@Override
public Stack clone() {
    try {
        Stack result = (Stack) super.clone();
        result.elements = new ~~;
        return result;
    } catch (CloneNotSupportedException e) {
        throw new AssertionError();
    }
}
```