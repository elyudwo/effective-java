# Comparable을 구현할지 고려하라

compareTo 메서드의 일반 규약
- Comparable을 구현한 클래스는 모든 x, y에 대해 sgn(x.compareTo(y)) == -sgn(y.compareTo(x))여야 한다.
- Comparable을 구현한 클래스는 추이성을 보장해야 한다.
- Comparable을 구현한 클래스는 모든 z에 대해 x.compareTo(y) == 0 이면 sgn(x.compare(z)) == sgn(y.compareTo(z))다.
- (x.compareTo(y) == 0) == (x.equals(y))여야 한다.

기존 클래스를 확장한 구체 클래스에서 새로운 값 컴포넌트를 추가 했다면 compareTo 규약을 지킬 방법이 없다.

