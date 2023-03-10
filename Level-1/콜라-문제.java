class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(true){
            //가지고 있는 빈병수가 n개 미만이면
            if(n<a){
                break;
            }
            answer += (n / a) * b;
            int remain = n % a;
            
            n = (n/a) * b + remain;
        
        }
        return answer;
    }
}
