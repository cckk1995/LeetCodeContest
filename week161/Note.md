最大公约数

```java
public int gcd(int a,int b) {
    return b==0?a:gcd(b,a%b);
}
```

