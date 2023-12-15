# private 생성자나 열거 타입으로 싱글턴임을 보증하라

## 서론
싱글턴이란 인스턴스를 오직 하나만 생성할 수 있는 클래스를 말한다.
싱글턴을 이용할 경우 객체 생성 비용이 없다는 장점이 있지만 테스트 하기 어려워지는
단점 또한 존재한다.

코드를 통해 싱글턴의 장점과 단점을 자세히 알아보자

- - -

## public static final 필드 방식의 싱글턴

```java
public class Singleton1 {
    
    public static final Singleton1 SINGLETON = new Singleton1();

    private Singleton1() {}
}
```

## 정적 팩터리 방식의 싱글턴

```java
public class Singleton2 {
    
    private static final Singleton2 singleton = new Singleton2();

    public static Singleton2 getInstance() {
        return singleton;
    }
}
```
<br></br>

### public static final 필드 방식의 장점
- 해당 클래스가 싱틀언임이 API에 명백히 드러난다.
- 코드가 간결하다

### 정적 팩터리 방식의 장점
- API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다.
  - getInstance 메서드에서 return singleton이 아닌 return new Singleton2를 해주는 경우
- 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다.
  - ```java
    public class GenericSingletonFactory<T> {

      private static final GenericSingletonFactory<Object> instance = new GenericSingletonFactory();
  
      private GenericSingletonFactory() {}
  
      public static <E> GenericSingletonFactory<E> getInstance() {
          return (GenericSingletonFactory<E>) instance;
      }
    }
    ```
- 정적 팩터리의 메서드 참조를 공급자로 사용할 수 있다.
  - ``` java
    Supplier<Singleton1> supplier = Singleton1::getInstance;
    Singleton1 instance = supplier.get();
     ```

### 단점 1
- 역직렬화 시 싱글턴이 깨진다.
  - 자바에서는 직렬화된 인스턴스를 역직렬화 할 때 직렬화된 인스턴스를 기반으로 새로운 인스턴스를 생성해 준다. (아래 통과하는 테스트 코드로 증명)
  ``` java
    @Test
    void Serializable() {
        Singleton2 serialization = Singleton2.getInstance();
        Singleton2 deserialization;

        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(serialization);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            deserialization = (Singleton2) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        assertFalse(serialization == deserialization);
    }
    ```
아래와 같이 싱글턴 클래스에 readResolve 메서드를 추가해주면 역직렬화 시 readResolve 메서드에서 인스턴스를 반환해준다.
``` java
private Object readResolve() {
    return singleton;
}
```

<br></br>

### 단점 2
- 리플렉션 API를 사용하면 싱글턴이 보장되지 않는다.

이를 해결하기 위해서 열거 타입을 선언할 수 있다.

```java
public enum Singleton3 {

    SINGLETON_3;
    
    public Singleton3 getSingleton3() {
        return SINGLETON_3;
    }
}
```

열거 타입을 사용할 경우 직렬화, 리플렉션의 문제를 해결할 수 있다.

하지만 자바 열거형은 다른 클래스를 상속하거나 파생시킬 수 없기 때문에 상속이 필요한 경우 지양해야한다.