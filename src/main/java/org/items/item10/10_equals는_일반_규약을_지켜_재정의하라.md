# equals는 일반 규약을 지켜 재정의하라

## 재정의 하지 않는 상황

- 각 인스턴스가 본질적으로 고유하다.
  - 값이 아닌 동작하는 개체를 표현하는 클래스
- 인스턴스의 논리적 동치성을 검사할 일이 없다.
  - ex) 힙 메모리 상 객체의 주소, 동일한 클래스 여부가 아닌 **객체 상태 데이터**의 값을 검사할 일이 없을 때
- 상위 클래스에서 재정의한 equals가 하위 클래스에도 딱 들어맞는다.
- 클래스가 private이거나 package-private이고 equals 메서드를 호출할 일이 없다.
```java
@Override
public boolean equals(Object o) {
    throw new AssertionError(); // 호출 금지
}
```

## 재정의 규약

- 반사성(reflexivity): null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true다.
- 대칭성(symmetry): null이 아닌 모든 참조 값 x, y에 대해, x.equals(y)가 true면 y.equals(x)도 true다.
- 추이성(transitivity): null이 아닌 모든 참조 값 x, y, z에 대해, x.equals(y)가 true이고 y.equals(z)도 true면 x.equals(z)도 true다.

```java
public class Cafe {
  private String name;

  @Override
  public boolean equals(Object obj) {
    Cafe cafe = (Cafe) obj;
    return this.name == cafe.name;
  }
}

@Getter
public class CatCafe {
    private String name;
    private Integer catCount;

    @Override
    public boolean equals(Object obj) {
        if (!(o instanceof Cafe)) {
            return false;
        }

        if (!(o instanceof Cafe)) {
            return obj.equals(this);
        }

        return super.equals(o) && ((CatCafe) o).catCount == catCount;
    }
}
```
Cafe cafe = new Cafe("CatWorld"); // 객체 A
CatCafe catCafe1 = new CatCafe("CatWorld", 3); // 객체 B
CatCafe catCafe2 = new CatCafe("CatWorld", 5); // 객체 C

A와 B가 true, A와 C가 true인데 B와 C가 false이다.

CatCafe 객체의 equals를 재정의 할 수 있지만 리스코프 치환원칙에 위배

- 일관성(consistency): null이 아닌 모든 참조 값 x, y에 대해, x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환한다.
  - URL 일반 규칙 어기는 케이스
- null-아님: null이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false다.

## equals 메서드 구현 방법 단계별 정의
- == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.
- instanceof  연산자로 입력이 올바른 타입인지 확인한다.
- 입력을 올바른 타입으로 형변환한다.
- 입력 객체와 자기 자신의 대응되는 '핵심' 필드들이 모두 일치하는지 하나씩 검사한다.

## 주의사항
- equals를 재정의할 땐 hashcode도 반드시 재정의하자.
- 너무 복잡하게 해결하려 들지 말자.
- 입력 매개변수는 반드시 Object로 받자