import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*

# 요시푸스 문제

- 출처 : [https://www.acmicpc.net/problem/1158](https://www.acmicpc.net/problem/1158)

## 문제

- 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 
- 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
- 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 
- 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
- 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
- N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

## 입력
- 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)

## 출력
- 예제와 같이 요세푸스 순열을 출력한다.

## 예제
```cmd
입력         출력
7 3         <3, 6, 2, 7, 5, 1, 4>
```
*/ 
public class Main {
 
    public static void main(String[] args) throws Exception {

        // initialization start
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());   // initialization N
        int K = Integer.parseInt(st.nextToken());   // initialization K
 
        Queue<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= N; i++) circle.offer(i);  // initialization circle of N
        // initialization end

        // set OUPUT start ex <1, 2, 3, 4>
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(circle.size() != 1) {
            for (int i = 0; i < K-1; i++)circle.offer(circle.poll());  // 0~K-1 : 뒤로
            sb.append(circle.poll()+ ", ");   // K번째 : 그대로
        }
        sb.append(circle.poll());
        sb.append(">");
        // set OUPUT end

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}