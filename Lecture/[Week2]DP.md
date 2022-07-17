# Week2 분할정복, DP

[https://janghw.tistory.com/entry/알고리즘-Divide-and-Conquer-%EB%B6%84%ED%95%A0%EC%A0%95%EB%B3%B5](https://janghw.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-)

[https://ruddls00114.github.io/2019/03/25/정렬-알� %B3%A0%EB%A6%AC%EC%A6%98_2/](https://ruddls00114.github.io/2019/03/25/정렬-알�)

[https://dudri63.github.io/2019/01/17/algo6/](https://dudri63.github.io/2019/01/17/algo6/)

종만북

# 정의

문제를 나눌 수 없을 때까지 나누어서 각각을 풀면서 다시 합병하여 문제의 답을 얻는 

알고리즘이다. 총 3가지 단계를 통해 설계된다.

1. Divide : 문제가 분할이 가능할 경우, 2개 이상의 문제로 나눈다.

2. Conquer : 더 쪼개질 수 있다면 Divide를 더 이상 쪼개지지 않는다면 문제를 풀고
3. Combine 단계로 넘어간다.

# 사용 시점

문제를 둘 이상의 부분 문제로 나누는 자연스러운 방법이 있어야 한다. 또한 부분 문제의 답 을 조합하여 원래 문제의 답을 계산하는 효율적인 방법이 있어야 한다.

# 사용되는 기법

1. 거듭제곱 및 재귀 호출에서 사용
ex) 1~n까지의 합을 재귀 호출을 이용해 계산하는 recursiveSum()과 fastSum()의 비교 설명

```cpp
int recursiveSum(int n){
if(n==1) return 1; //더 이상 쪼개지지 않을 때 return n + recursiveSum(n-1);
}

int fastSum(int n){ if(n==1) return 1;
if(n%2 == 1) return fastSum(n-1) + n; return 2*fastSum(n/2) + (n/2)*(n/2);
}
```

$$
fastSum() = 1+2+..+n
= (1+2+..+n/2) +   ((n/2+1)+...+n)
= (1+2+...+n/2)+((n/2+1) +(n/2+2)+...+(n/2+n/2)) 
= n/2*n/2 + (1+2+3+...+n/2)
=n/2*n/2 +fastsum(n/2)
$$

$$
fastSum(n)=2*fastSum(n/2)+n*n/4(n이 짝수일 때)
$$

시간 복잡도 측면에서 recusiveSum()의 경우 n번의 함수 호출이 필요하지만 fastSum()의 경 우 최소한 두 번의 한 번꼴로 n이 절반으로 줄어들기 때문에 호출 횟수가 더 적으리라 예측 할 수 있다.

ex) 행렬의 거듭제곱 등등

2. 병합 정렬과 퀵 정렬

병합 정렬 : 주어진 수열을 가운데에서 쪼개 비슷한 크기의 수열 두 개로 만든 뒤 재귀 호출 을 이용해 각각 정렬하고 이후에 하나로 합침으로써 정렬된 전체 수열을 얻는다.

퀵 정렬 : 파티션이라는 단계에서 기준 수(pivot)를 지정한 후 기준보다 작거나 같은 숫자를 왼쪽, 더 큰 숫자를 오른쪽으로 보내고 이후에 합침으로써 정렬된 전체 수열을 얻는다.

### 병합 정렬

![merge-sort-concepts](https://user-images.githubusercontent.com/108566378/179390057-1454d8f2-614f-4e76-9bcc-f24cbd6c2f62.png)(Week2%20%E1%84%87%E1%85%AE%E1%86%AB%E1%84%92%E1%85%A1%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%87%E1%85%A9%E1%86%A8,%20DP%2042506d20fc374dc49e0ef7e35d35851f/merge-sort-concepts.png)

### 퀵 정렬

![quick-sort](https://user-images.githubusercontent.com/108566378/179390063-4f165503-6133-4a98-afed-f44a75956705.png)(Week2%20%E1%84%87%E1%85%AE%E1%86%AB%E1%84%92%E1%85%A1%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%87%E1%85%A9%E1%86%A8,%20DP%2042506d20fc374dc49e0ef7e35d35851f/quick-sort.png)

## 병합 정렬과 퀵 정렬의 시간 복잡도 비교

병합 정렬은 쪼개는 과정에서는 상수 시간 O(1)만에 수행이 가능하다. 하지만 나누어진 배열 을 하나로 합치는 과정에서 별도의 병합 과정을 실행해야 해서 이때 O(n)의 시간이 걸린다. 즉 한 단계 내에서 모든 병합에 필요한 시간은 총 O(n)으로 일정하게 된다. 이후에 필요한 단 계의 수는 거의 항상 절반으로 나누어 지기 때문에 lgn이 되고 따라서 병합 정렬의 시간 복잡 도가 O(nlgn)이다.

퀵 정렬의 경우 피봇을 기준으로 쪼개는 과정에서 시간이 걸린다. 하지만 어떤 수를 피봇으로 삼느냐에 따라서 시간 복잡도가 달라진다. 절반에 가깝게 나누어질 때는 병합 정렬과 같은 O(nlgn)이 걸리고 최악의 상황에는 O(n*n)이 걸린다.

# 장점

문제를 나눔으로써 어려운 문제를 해결할 수 있다. 시간 복잡도 측면에서 이득을 볼 수 있다. 병렬적으로 문제를 해결하는 데 큰 강점이 있다.

# 단점

함수를 재귀적으로 호출한다는 점에서 스택에 다양한 데이터를 보관해야 하고 이는 스택 오버 플로우를 발생시키거나 과도한 메모리 사용을 하게 된다. 이 알고리즘의 핵심인 F(x)가 간단 한지 아닌지에 따라서 알고리즘의 성능이 차이가 크게 나게 된다.

## 예제

병합 정렬 및 퀵 정렬 구현

### 병합 정렬

```python
def mergesplit(data): 
	if len(data) <= 1:
		return data
	middle = int(len(data)/2)
	left = mergesplit(data[:middle]) 
	right = mergesplit(data[middle:]) 
	return merge(left,right)

def merge(left, right): 
	lp, rp = 0, 0
	merged = []
	while len(left) > lp and len(right) > rp:
		if left[lp] > right[rp]: 
			merged.append(right[rp]) rp = rp + 1
		else: 
			merged.append(left[lp]) 
			lp = lp + 1
	while len(left) > lp: 
			merged.append(left[lp]) 
			lp = lp + 1
	while len(right) > rp: 
			merged.append(right[rp]) 
			rp = rp + 1
	return merged
```

### 퀵 정렬

```python
def qsort(arr):
	if len(arr) <= 1: return arr
	pivot = arr[len(arr) // 2]
	lesser_arr, equal_arr, greater_arr = [], [], [] for num in arr:
	if num < pivot: 
		lesser_arr.append(num)
	elif num > pivot: 
		greater_arr.append(num)
	else: 
		equal_arr.append(num)
	return qsort(lesser_arr) + equal_arr + qsort(greater_arr)
```

# 추천 문제(난이도 순)

[https://www.acmicpc.net/problem/2740](https://www.acmicpc.net/problem/2740)[https://www.acmicpc.net/problem/2630](https://www.acmicpc.net/problem/2630) [https://www.acmicpc.net/problem/1780](https://www.acmicpc.net/problem/1780) [https://www.acmicpc.net/problem/1780](https://www.acmicpc.net/problem/1780) [https://www.acmicpc.net/problem/1629](https://www.acmicpc.net/problem/1629) [https://www.acmicpc.net/problem/10830](https://www.acmicpc.net/problem/10830) [https://www.acmicpc.net/problem/11444](https://www.acmicpc.net/problem/11444) [https://www.acmicpc.net/problem/11401](https://www.acmicpc.net/problem/11401) [https://www.acmicpc.net/problem/6549](https://www.acmicpc.net/problem/6549)

---

# DP( 동적 계획법 )

[https://janghw.tistory.com/entry/알고리즘-
Dynamic-Programming-%EB%8F%99%EC%A0%81-%EA%B3%84%ED%9A%8D%EB%B2% 95?category=646973](https://janghw.tistory.com/entry/알고리즘-)

[https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=cestlavie_01&l ogNo=221064226379](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=cestlavie_01&l)

[https://parkhongbeen.github.io/2020/07/07/DynamicPrograming/](https://parkhongbeen.github.io/2020/07/07/DynamicPrograming/)

종만북

## 정의

분할 정복과 마찬가지로 처음 주어진 문제가 최적 하위 구조로 이루어져 있을 때 각 조각의
답을 계산하고, 이를 토대로 전체 문제의 답을 구하는 알고리즘이다.
여기서 최적 하위 구조란 전체 문제의 답이 부분 문제의 답으로부터 만들어지는 구조를 뜻한
다. 즉 전체 문제가 3개의 하위 문제로 나눌 수 있고, 3개의 하위 문제를 전부 풀어야만 전체
문제의 답을 구할 수 있다면 이를 최적 하위 구조를 갖추었다고 표현한다.

동적 계획법과 분할 정복의 차이점 : 하위 문제가 서로 중복되는지, 그리고 메모이제이션의
사용 유무에 따라 동적 계획법과 분할 정복이 나뉜다. 동적 계획법은 어떤 부분 문제를 풀 때
같은 계산을 여러 번 할 수도 있다는 것을 염두에 두어 이미 계산한 값을 저장해두고 중복되
는 계산을 하지 않는다. 이 기법을 메모이제이션(memoization)이라고 부른다.

3가지 단계로 정리하면
1. 문제를 부분 문제로 나눈다.
2. 가장 작은 문제의 해를 구한 뒤, 테이블에 저장한다.
3. 테이블에 저장된 데이터를 사용하여 전체 문제의 답을 구한다.

## 사용 시점

분할 정복과 같이 문제를 둘 이상의 하위 문제로 쪼갤 수 있어야 한다. 이러한 하위 문제에서 중복되는 계산이 많을수록 더더욱 사용했을 때 성능이 좋아진다.

## 사용되는 기법

주로 재귀 함수가 사용되는 모든 기법에서 메모이제이션을 사용할 수 있으면 사용된다.

메모이제이션을 사용할 수 있는 경우
어떤 함수가 참조적 투명성을 가지고 있을 때 메모이제이션을 사용할 수 있다. 여기서 참조적
투명성은 입력값이 같으면 출력도 항상 같은 함수를 뜻한다.

```cpp
int counter = 0;
     
int count() {
	return counter++;
}
```

예시로 아래와 같은 함수는 참조적 투명성을 가지고 있다고 할 수 없다.

### 1. 이항 계수

ex) 중복 제거 전 후

![binoo](https://user-images.githubusercontent.com/108566378/179390038-18ff30ae-1680-4073-bceb-dc235b9fd088.png)(Week2%20%E1%84%87%E1%85%AE%E1%86%AB%E1%84%92%E1%85%A1%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%87%E1%85%A9%E1%86%A8,%20DP%2042506d20fc374dc49e0ef7e35d35851f/binoo.png)

기존의 이항계수 계산

```cpp
int bino(int n, int r) {
	//기저 사례: n==r (모든 원소를 다 고르는 경우) 혹은 r=0 (고를 원소가 없는 경우) 
	if (r == 0 || n == r) 
		return 1;
	return bino(n - 1, r - 1) + bino(n - 1, r);
}
```

동적 계획법을 적용한 이항 계수의 계산

```cpp
int cache[30][30]; //-1로 초기화해 둔다. 
	int bino2(int n, int r) {
	  //기저 사례
		if (r == 0 || n == r) 
			return 1;
			//-1이 아니라면 한 번 계산했던 값이므로 바로 반환 if (cache[n][r] != -1)
		return cache[n][r]; //직접 계산한 뒤 배열에 저장
		return cache[n][r] = bino2(n - 1, r - 1) + bino2(n - 1, r);
}
```

## 2. 피보나치 수열

![다운로드](https://user-images.githubusercontent.com/108566378/179390026-97976de2-0c5c-44e3-afe7-efe5a2e654fb.png)(Week2%20%E1%84%87%E1%85%AE%E1%86%AB%E1%84%92%E1%85%A1%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%87%E1%85%A9%E1%86%A8,%20DP%2042506d20fc374dc49e0ef7e35d35851f/%E1%84%83%E1%85%A1%E1%84%8B%E1%85%AE%E1%86%AB%E1%84%85%E1%85%A9%E1%84%83%E1%85%B3.png)

피보나치의 경우도 동일하다. 기존의 피보나치 함수의 경우 계산했던 것을 다른 하위 함수에 서 다시 계산함으로써 손해를 보게 된다.

기존의 피보나치 수열

```cpp
int fibonacci(int n) { 
		if (n == 0) {
		return 0; 
		}
		if (n == 1 || n == 2) { 
		return 1;
		}
 
		return fibonacci(n - 1) + fibonacci(n - 2);
}
```

이 방식으로 계산하게 되면 시간 복잡도는 O(2의 n제곱)이 걸리게 된다. 하지만 동적 계획법을
사용하게 되면

동적 계획법을 적용한  피보나치 수열

```cpp
long fibonacci_with_dynamic(int n) { 
		int i = 0;
		long result = 0;
		long* fibonacci_tbl = 0;
		if (n == 0 || n == 1) { 
			return n;
		}
		fibonacci_tbl = (long*)malloc((n + 1) * sizeof(long)); 
		fibonacci_tbl[0] = 0;
		fibonacci_tbl[1] = 1;
		for (i = 2; i <= n; i++) {
			fibonacci_tbl[i] = fibonacci_tbl[i - 1] + fibonacci_tbl[i - 2];
		}
		result = fibonacci_tbl[n]; 
		free(fibonacci_tbl); 
		return result;
}
```

시간 복잡도가 O(n) 까지 단축할 수 있다.

## 장점

시간 복잡도 측면에서 큰 이득을 볼 수 있다. 지수 복잡도 알고리즘을 다항 시간으로 줄여주 기도 하고 같은 다항 시간 알고리즘도 차수를 낮출 수 있다. 데이터의 개수가 늘어날수록 크 게 도움이 된다.

## 단점

성능이 좋은 대신 난해하고 복잡하며 직관적으로 떠올리기 힘들어 초심자가 사용하기에는 무 리가 있다. 병합 정렬과 마찬가지로 저장해야 할 양이 많기 때문에 메모리 오버플로우가 발생
할 수 있다.

# 예제

BOJ 11726 : 2xn 타일링

## 문제

2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오. 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

![2x5](https://user-images.githubusercontent.com/108566378/179390014-4b01d35f-1df7-4b0c-8a75-f486bc0061a0.png)
(Week2%20%E1%84%87%E1%85%AE%E1%86%AB%E1%84%92%E1%85%A1%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%87%E1%85%A9%E1%86%A8,%20DP%2042506d20fc374dc49e0ef7e35d35851f/2x5.png)

## 입력

첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
출력 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를
출력한다. 0으로 초기화된 1000크기의 배열 data

## 풀이

```python
data = [0] * 1000 def tile(long) :
		if long == 1 : return 1
		if long == 2 : return 2
		if data[long] != 0 : return data[long]
		data[long] = tile(long - 1) + tile(long - 2) 
		return tile(long - 1) + tile(long - 2)
```

## 추천 문제(난이도 순)

[https://www.acmicpc.net/problem/24416](https://www.acmicpc.net/problem/24416)[https://www.acmicpc.net/problem/1904](https://www.acmicpc.net/problem/1904) [https://www.acmicpc.net/problem/1912](https://www.acmicpc.net/problem/1912) [https://www.acmicpc.net/problem/10844](https://www.acmicpc.net/problem/10844) [https://www.acmicpc.net/problem/2156](https://www.acmicpc.net/problem/2156) [https://www.acmicpc.net/problem/12865](https://www.acmicpc.net/problem/12865) [https://www.acmicpc.net/problem/11054](https://www.acmicpc.net/problem/11054) [https://www.acmicpc.net/problem/11049](https://www.acmicpc.net/problem/11049) [https://www.acmicpc.net/problem/7579](https://www.acmicpc.net/problem/7579)
