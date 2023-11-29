# kotlin-blackjack

## 기능 요구 사항

블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

- 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
- 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.

## 기능 목록

### 플레이어

- [O] 플레이어의 초기 상태는 PLAYING이다.
- [O] 플레이어가 카드 받는 것을 끝내면 상태는 STAND가 된다.
- [O] 플레이어는 받은 카드를 저장한다.
- [O] 플레이어는 상태를 업데이트 한다.
  - [O] 카드의 합이 20 이하 라면 PLAYING
  - [O] 카드의 합이 21을 이상 이라면 STAND
  - [O] 카드를 받지 않는다 하면 STAND

### 플레이어 그룹
- [O] 플레이어는 최소 2명 이상 26명 이하여야 한다.
- [O] 현재 플레이 중인 플레이어를 반환한다.
- [O] 플레이어 턴을 넘긴다.

### 블랙젝 게임

- [O] 플레이어는 게임 시작시 2장의 카드를 받는다.
- [O] 배포한 카드를 플레이어에게 전달한다.
- [O] 유저를 반환한다. (TestCode X)
- [O] 유저 턴을 넘긴다. (TestCode X)
- [O] 유저 턴을 종료한다. (TestCode X)

### 블랙젝 계산기
- [O] 결과를 계산한다.

### 트럼프 카드(플레잉 카드)

- [O] 카드의 포인트를 반환한다.
- [O] 카드의 무늬 명을 반환한다.
- [O] 카드의 번호를 반환한다.

### inputView

- [] 플레이어를 입력받는다.
  - [] 플레이어가 입력되지 않으면 예외를 던진다.
- [] 카드 수집 여부를 받는다.

### output

- [] 플레이어가 가지고 있는 카드를 보여준다.
- [] 플레이어 카드 계산값을 보여준다.
