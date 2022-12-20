package practice2;
/* 모든 Animal 이하의 클래스는 따로 객체가 없으므로 abstract로 선언한다.
 * public abstract class Animal {
 *      public String toString() { return this.getClass().getSimpleName();
 * }
 */
public class Animal {
}
/* 1. 동물 클래스를 정의
 *  > 표유류 : 박쥐(수영잘함), 호랑이, 고래
 *  > 조류 : 매, 타조, 펭귄
 * 날수 있는 동물을 분류
 * 수영할 수 있는 동물을 분류
 * -동물들에게 직접적으로 날 수 있는지, 헤엄칠 수 있는지 물어볼 수 없습니다.
 * -동물들을 특성(날기, 헤엄치기)별로 분류하고, 종류를 출력합니다. 단, 동물은 클래스 이름으로 대체합니다. -> getClass().getName();
 * -날기와 헤엄치기를 다른 방법으로 분류해봅니다. : abstract(객체가 안될때) class, interface(기능), Annotation, ...중에 하나
 */

/* 2. 알아야할것
 * - 가상클래스와 인터페이스의 차이점
 * - 타입 검사를 통해 알 수 있어야함
 * - 추상클래스, 인터페이스, 어노테이션을 각각 어떻게 사용할 것인지 : 활용법
 */
