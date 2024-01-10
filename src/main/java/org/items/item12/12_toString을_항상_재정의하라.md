# toString을 항상 재정의하라

```java
/**
     * Returns a string representation of the object.
     * @apiNote
     * In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * The string output is not necessarily stable over time or across
     * JVM invocations.
     * @implSpec
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return  a string representation of the object.
     */
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
```

## _It is recommended that all subclasses override this method._

- toString을 재정의할 때는 객체가 가진 주요 정보 모두를 반환하는게 좋다.
    - 객체가 가진 정보가 너무 많다면 요약해서 재정의 하는것이 좋다.
- toString이 반환한 값에 포함된 정보를 얻어올 수 있는 API를 제공하자.