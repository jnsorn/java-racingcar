## 우아한테크코스 코드리뷰

* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## Commit Message Convention

* ``Feat`` feature
* ``Fix`` bug fix
* ``Docs`` documentation
* ``Style`` formatting, missing semi colons...
* ``Refactor``
* ``Test`` when adding missing test

## Rule for TDD  

1. create fail test code
2. create test as much as possible
   - skip hard test

# 1.string-calculator

문자열 덧셈 계산기를 통한 TDD/리팩토링 실습

## 요구사항  

* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 
  - (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 입력

- null값을 입력할 경우 0을 반환한다.
- 빈 문자열을 입력할 경우 0을 반환한다.
- 숫자 이외의 값을 입력할 경우 RuntimeException을 throw 한다.
- 음수를 입력할 경우 RuntimeException을 throw 한다.
- 문자열 format이 잘못된 경우 RuntimeException을 throw 한다.
  - default
   1. 구분자가 다를 경우 (ex. 1;2:3)
  - custom
   1. 구분자가 다를 경우 (ex. //:\n1;2:3)
   2. 구분자가 ``//``와 ``\n``사이에 존재하지 않을 경우 (ex. //;1;2;3)
   3. ``//.\n``의 포맷을 지키지 않는 경우 (ex. /;\n1;2;3)

## 기능목록  

1. null 또는 빈 문자열에 대해 0을 반환한다.  
   - null이 들어올 때 테스트
   - 빈 문자열이 들어올 때 테스트

2. 기본 구분자(``,``,``:``)로 구성된 문자열에 대해 덧셈 결과를 반환한다.
   - ``,``를 구분자로 사용하는 경우의 테스트
   - ``:``를 구분자로 사용하는 경우의 테스트
   - ``,``, ``:``를 구분자로 같이 사용하는 경우의 테스트
3. 커스텀 구분자로 분리된 문자열에 대해 덧셈 결과를 반환한다. (ex. //;\n1;2;3)
   - 커스텀 구분자로 문자열을 분리하는 테스트

# 2.java-racingcar

자동차 경주 게임 미션

## 요구사항  

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 기능구현목록  
1. 사용자로부터 자동차 이름을 입력받는다.
   - 자동차 수는 정해져있지 않다
   - 예외
      - 이름이 0~5자 사이가 아닌 경우
      - 자동차가 1대인 경우
      - 중복된 이름이 있을 경우
2. 각 이름을 가진 자동차 객체를 생성한다.
3. 사용자로부터 시도할 횟수를 입력받는다.
   - 예외
      - 숫자가 아닌 경우
      - 0이 들어왔을 경우
4. 입력받은 횟수만큼 자동차를 동작시킨다.
   - 각 자동차는 난수를 생성한다.
      - 난수 범위: 0~9
   - 난수에 따라 전진 및 정지를 결정한다.
      - 전진 범위 : 4~9
      - 정지 범위 : 0~3
   - 진행 결과를 출력한다.
5. 우승자를 선별한다.
   - 전진 횟수가 가장 많은 자동차가 우승이다.
   - 우승자는 한 명 이상일 수 있다.
6. 우승자를 출력하고, 게임을 종료한다.

