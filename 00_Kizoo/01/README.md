## Call-by-value VS Call-by-reference

### 🔎문제 [출처](https://kizoo.gitlab.io/docs/archive/java/001/)
1. ['원본'은 바뀌지 않지만, 'source'는 바뀌었다. Call-by-value인데도 'source'가 변한 까닭은?](#1번-해설)
2. 위의 실험 결과로 볼 때 Java는 call-by-reference를 지원한다고 볼 수 있는가?

##### <소스코드> 

    class 물체 {
    private int n = 0;
    public 물체( int m ) { n = m; }
    public void modify( int m ) { n = m; }
    public String toString() { return "" + n; }
    }
    
    class ParameterPassing {
    public static void callByValue( int 복사본 ) { 복사본 = 0; }
    public static void callByValue( 물체 copy ) { copy.modify(  0  ); }
    public static void test() {
    int 원본 = 1;
    System.out.println( 원본 );
    callByValue( 원본 );
    System.out.println( 원본 );
    
            물체 source = new 물체( 1 );
            System.out.println( source );
            callByValue( source );
            System.out.println( source );
        }
    }
    ParameterPassing.test(); // Jupyter notebook에서만 
<p>

##### <출력결과>

    > 1
    > 1
    > 1
    > 0
    
### 🗝설명

##### 1번 해설
