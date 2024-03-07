# kotlin-blackjack

## 기능 요구 사항

블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.
딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다.
게임을 완료한 후 각 플레이어별로 승패를 출력한다.

## 기능 목록

### 카드

- [X] 카드는 숫자와 모양을 알고 있다.

### 카드 모양
- 카드 모양 4가지를 저장하는 enum

### 카드 숫자
- 카드 숫자 13 가지를 저장하는 enum
- 카드는 숫자와 출력 속성을 가지고 있다. (ACE 는 A 로 출력되고, 나머지는 숫자와 동일하게 출력된다)

### 카드 덱

- [X] 각 카드는 1장만 존재해야 한다.
- [X] 랜덤으로 카드를 한장 뽑는다.

### 카드 핸드

- [X] 카드 리스트를 가지고 있다.
- [X] 카드들의 합을 구한다. 
  - 카드들의 합이 21 초과이고, 카드 핸드에 11로 취급되는 ACE 가 있다면 10 씩 빼는 것을 반복하여 합을 구한다.
- [X] 카드 핸드에 새 카드를 추가한다.

### 참여자들

- [X] 참가자의 수가 2명 이상 7명 이하여야 한다.
- [X] 참가자들은 게임 시작 시 카드를 2장 받는다.
- [X] 딜러 카드 패의 합을 가져온다.
- [X] 플레이어들의 카드 패의 합을 이름과 짝 지어서 가져온다. 

### 역할: Role

- [X] 이름과 카드 핸드를 가진다.
- [X] 플레이어와 딜러의 상위 인터페이스
- [X] 게임 시작 시 카드를 2장 받는다.
- [X] 플레이어나 딜러가 HIT 이면 계속 카드를 뽑기

### 플레이어

- [X] 이름을 직접 지정할 수 있다
- [X] 플레이어는 자신의 카드들을 가지고 있다.
- [X] 플레이어 카드의 상태를 알아낸다. (21: Black Jack, 21 초과: BURST, 21 미만: STAY 혹은 HIT (플레이어 결정에 따름))


### 딜러

- [X] 딜러의 이름은 항상 "딜러" 이다.
- [X] 딜러는 자신의 카드들을 가지고 있다.
- [X] 카드의 상태를 알아낸다. (21: Black Jack, 21 초과: BURST, 16 초과: STAY, 16 이하: HIT)

### 블랙잭 게임

- [ ] 카드 합 상태가 Black Jack이면 다음 플레이어로 넘어간다. 다음 플레이어가 없으면 딜러로 넘어간다.
- [ ] 딜러의 카드가 16 이하이면 카드 1장을 반드시 딜러에게 추가로 준다.
- [ ] 딜러의 카드가 17 이상이면 카드를 딜러에게 추가로 줄 수 없다.
- [ ] 딜러와 플레이어에게 카드를 나눠준다.
- [ ] 모든 참가자들이 가진 카드와 그 합을 계산한다.
- [ ] 최종 승패를 가린다.

### PlayerWinning
- [X] 참가자 이름과 게임 결과 상태를 가진다.

### WinningResultStatus
- [X] 승리, 패배, 무승부를 저장하는 enum
- [X] 플레이어의 승리는 딜러의 패배로 플레이어의 패배는 딜러의 승리로 기록된다.

### Referee

- [X] 딜러 카드 패의 합과 플레이어들의 카드 패의 합을 각각 비교해서 플레이어들의 승패 여부를 판단한다.

###  InputView
- [X] 게임에 참여할 사람의 이름을 입력한다.
- [X] 플레이어가 카드를 추가로 받을지 입력한다.

### OutputView

- [X] 참여자들의 초기 카드 핸드 상태를 출력한다.
- [X] 참여자의 현재 카드 핸드를 출력한다.
- [X] 딜러가 HIT 헀다는 안내 메세지를 출력한다.
- [X] 게임의 결과를 출력한다.