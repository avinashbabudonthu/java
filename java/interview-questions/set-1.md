# Given a number, find the number of iterations for which sum becomes palindrome
* Problem statement
```
input - 451
1. 451 + 154 == 605
2. 605 + 506 == 1111 - palindrome
output - 2

input - 349
1. 349 + 943 == 1292
2. 1292 + 2921 == 3124
3. 3124 + 4213 == 7337 - palindrome
output - 3
```
* Solution
```
public void palindrome() {
        int i = 1;
        long sum = 0;
        long sumReverse = 0;
        long num1 = 349; // 451, 349, 123, 456, 789, 147, 258, 369, -451
        long num1Reverse;
        while(true){
            num1Reverse = reverseTheNumber(num1);
            sum = num1 + num1Reverse;
            sumReverse = reverseTheNumber(sum);
            System.out.println("num1: " + num1 + ", num1Reverse: " + num1Reverse + ", sum: " + sum + ", sumReverse: " + sumReverse);

            if(sum == sumReverse){
                break;
            }else{
                num1 = sum;
                i++;
            }
        }

        System.out.println("iterations: "+ i);
    }

    private long reverseTheNumber(long number){
        boolean isNagative = false;
        if(number < 0){
            number = number * -1;
            isNagative = true;
        }
        long reminder;
        long reverse = 0;
        while(number > 0){
            reminder = number % 10;
            reverse = (reverse*10) + reminder;
            number = number/10;
        }
        return isNagative ? reverse * -1 : reverse;
    }
```
## Result
* Input - 451
```
num1: 451, num1Reverse: 154, sum: 605, sumReverse: 506
num1: 605, num1Reverse: 506, sum: 1111, sumReverse: 1111
iterations: 2
```
* input - 349
```
num1: 349, num1Reverse: 943, sum: 1292, sumReverse: 2921
num1: 1292, num1Reverse: 2921, sum: 4213, sumReverse: 3124
num1: 4213, num1Reverse: 3124, sum: 7337, sumReverse: 7337
iterations: 3
```
* input - `-451`
```
num1: -451, num1Reverse: -154, sum: -605, sumReverse: -506
num1: -605, num1Reverse: -506, sum: -1111, sumReverse: -1111
iterations: 2
```
------
# Character count
* Problem statement
```
input: aaabbcccc
output: a3b2c4
```
* Code
```
public void characterCount(){
        String input = "aaabbcccc";
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<input.length();i++){
            String character = String.valueOf(input.charAt(i));
            Integer count = map.getOrDefault(character, 0);
            count++;
            map.put(character, count);
        }
        System.out.println("map: " + map);

        StringBuilder result = new StringBuilder();
        map.forEach((character, count) -> {
            result.append(character).append(count);
        });
        System.out.println("result: " + result);
    }
```
* Output
```
map: {a=3, b=2, c=4}
result: a3b2c4
```
