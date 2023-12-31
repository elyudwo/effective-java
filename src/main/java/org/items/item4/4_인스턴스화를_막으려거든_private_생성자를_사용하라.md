# 4_인스턴스화를_막으려거든_private_생성자를_사용하라

프로그램을 설계할 때 공통으로 쓰이는 메서드들을 정적 메서드들을 모아 한 객체로 만들어본 경험이 있을것이다.

정적 메서드는 상속이 안되기 때문에 객체지향에서 멀어져 지양해야하는 패턴이지만 장점을 가지고 있기 때문에 java.lang.Math 와 같은 객체에서 사용된다.

정적 메서드의 장점으로 첫 번째는 메모리 효율성이다. 정적 메서드는 static 메모리 영역에 저장되어 메서드 사용 시 인스턴스를 생성하지 않아도 되기 때문에
효율적으로 메모리를 사용할 수 있다.

두 번째는 속도이다. 정적 메서드는 클래스가 메모리에 올라가는 시점에 생성되어 바로 사용 가능하기 때문에 속도가 빠르다는 장점이 있다.

이러한 정적 메서드만 존재하는 객체는 굳이 인스턴스화 하지 않고 사용하는 것이 위의 두가지 장점을 누리기 좋은 방법이다.

그렇다면 인스턴스화를 막기 위해서는 어떻게 해야할까??

싱글턴을 사용할 때와 유사하다.

싱글턴은 아래 코드와 같이 생성자를 private으로 선언해 외부에서 생성자를 호출할 수 없게 만들었다.
<br></br>
```java
public class Singleton1 {
    public static final Singleton1 Singleton = new Singleton1();
    
    private Singleton1() {}
}
```
<br></br>

정적 메서드만 가진 클래스와 같이 인스턴스화를 방지하려는 클래스를 사용할 때도 생성자를 private으로 선언해 인스턴스화를 방지하면 된다. 

이는 상속을 방지하는 효과를 가진다. 왜냐하면 모든 생성자는 명시적이든 묵시적이든 상위 클래스의 생성자를 호출하게 되는데 이를 private으로 선언하면 하위 클래스가 상위 클래스의 생성자를
호출할 길이 막혀버렸기 때문에 상속을 사전에 방지할 수 있다.

리플렉션을 이용해 인스턴스를 만들 경우까지 걱정한다면 아래 코드와 같이 private 생성자를 선언해 exception을 발생시키면 된다.

```java
public class Util {
    private Util() {
        throw new RuntimeException();
    }
}
```