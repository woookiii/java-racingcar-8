# java-racingcar-precourse

## 기능목록

### 경주할 자동차의 이름을 입력받는 기능
    - param: void (console input)
    - return: Map<String, Long>

### 시도할 횟수를 입력받는 기능
    - param: void (console input)
    - return: long

### 모든 자동차에 대해 1회 전진을 시도하는 기능
    - param: Map<String, Long>
    - return: Map<String, Long>

### 시도 이후 실행결과를 한 단계 출력하는 기능
    - param: Map<String, Long>
    - return: void (console output)

### 최종 우승자를 선발하는 기능
    - using long max variable
    - param: Map<String, Long>
    - return: List<String>

### 최종 우승자를 출력하는 기능
    - using StringBuilder
    - param: List<String>
    - return: void (console output)