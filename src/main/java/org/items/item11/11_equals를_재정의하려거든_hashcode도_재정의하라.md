# equals를 재정의하려거든 hashcode도 재정의하라

```java
public class User {

    private String name;
    private int number;

    public User(String name, Integer number) {
        this.name = name;
        this.number = number;
    }
}
```

```java
@Test
void 해시맵_테스트() {
    Map<User, Integer> userMap = new HashMap<>();

    userMap.put(new User("이영재", 201801686), 25);
    Integer number = userMap.get(new User("이영재", 201801686));

    System.out.println(number);
    assertThat(number).isEqualTo(25);
}
```

테스트 실패
결과 값 null

equals를 재정의 하지 않았기 때문에 해시맵에서 키의 동등성을 false로 반환.

```java
public class User {

    private String name;
    private int number;

    public User(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User user)) {
            return false;
        }
        return user.name == name && user.number == number;
    }
}
```

테스트 실패
결과 값 null

equals를 재정의했지만 hashCode를 재정의 하지 않았기 때문에 다른 해시코드를 반환

```java
public class User {

    private String name;
    private int number;

    public User(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public int hashCode() {
        return Short.hashCode((short) number);
    }
}
```

테스트 실패
결과 값 null

hashCode를 재정의했지만 equals를 재정의 하지 않았기 때문에 해시맵에서 키의 동등성을 false로 반환

```java
public class User {

    private String name;
    private int number;

    public User(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User user)) {
            return false;
        }
        return user.name == name && user.number == number;
    }

    @Override
    public int hashCode() {
        return Short.hashCode((short) number);
    }
}
```

테스트 성공
결과 값 25

