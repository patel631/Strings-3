class integerToEnglishWords {
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"};
    
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        String result = "";
        int i = 0;
        
        while(num > 0){
            if(num % 1000 != 0){
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            i++;
            num = num / 1000;
        }
        return result.trim();
    }
    
    private String helper(int num){
        if(num == 0) return "";
        else if(num < 20) return below_20[num] + " ";
        else if(num < 100) return tens[num / 10] + " " + helper(num % 10);
        else{
            return below_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}

//time complexity O(1) because given is number that is constant
//space complexity O(1)