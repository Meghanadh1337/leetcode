class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder s=new StringBuilder(x+"");
        return s.toString().equals(s.reverse().toString() );
    }
}