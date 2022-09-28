# Reverse the number
```
 public long reverseTheNumber(long number){
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
