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

        System.out.println(i);
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
