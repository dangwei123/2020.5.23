牛牛刚刚学习了素数的定义，现在给定一个正整数N，牛牛希望知道N最少表示成多少个素数的和。
素数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数。

提示
哥德巴赫猜想：任意大于2的偶数都可以拆分成两个质数之和。该猜想尚未严格证明，但暂时没有找到反例。

public class Solution {
    /**
     * 判断给定的正整数最少能表示成多少个素数的和
     * @param N int整型 给定的正整数
     * @return int整型
     */
    public int MinPrimeSum (int N) {
        // write code here
        if(isPrim(N)) return 1;
        if((N&1)==0) return 2;
        if(isPrim(N-2)) return 2;
        return 3;
    }
    private boolean isPrim(int n){
        if(n<2) return false;
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}



牛牛最近搬到了一座新的城镇，这个城镇可以看成是一个一维的坐标系。城镇上有n个居民，第i个居民的位置为a_ia 
i
​	
 。现在牛牛有m个搬家方案，在第i个方案中他会搬到位置x_ix 
i
​	
 。

俗话说的好，远亲不如近邻。现在牛牛想知道，对于每个搬家方案，搬家后与最近的居民的距离为多少。

public class Solution {
    /**
     * 远亲不如近邻
     * @param n int整型 居民个数
     * @param m int整型 方案个数
     * @param a int整型一维数组 居民的位置
     * @param x int整型一维数组 方案对应的位置
     * @return int整型一维数组
     */
    public int[] solve (int n, int m, int[] a, int[] x) {
        // write code here
        int[] res=new int[m];
        Arrays.sort(a);
        for(int i=0;i<m;i++){
            int left=0;
            int right=n-1;
            while(left<right-1){
                int mid=left+(right-left)/2;
                if(a[mid]<x[i]){
                    left=mid;
                }else{
                    right=mid;
                }
            }
            res[i]=Math.min(Math.abs(x[i]-a[left]),Math.abs(x[i]-a[right]));
        }
        return res;
    }
}


给定一个包含大写英文字母和数字的句子，找出这个句子所包含的最大的十六进制整数，返回这个整数的值。数据保证该整数在int表示范围内

public class Solution {
    /**
     * 
     * @param s string字符串 
     * @return int整型
     */
    public int solve (String s) {
        // write code here
        int i=0;
        int max=0;
        while(i<s.length()){
            while(i<s.length()&&(s.charAt(i)=='0'||s.charAt(i)>='G')){
                i++;
            }
            int left=i;
            while(i<s.length()&&isValid(s.charAt(i))){
                i++;
            }
            int num=0;
            for(int j=left;j<i;j++){
                char c=s.charAt(j);
                if(c>='0'&&c<='9'){
                    num+=(int)Math.pow(16,i-j-1)*(c-'0');
                }else{
                    num+=(int)Math.pow(16,i-j-1)*(c-'A'+10);
                }
            }
            max=Math.max(max,num);
        }
        return max;
    }
    private boolean isValid(char c){
        return (c>='0'&&c<='9')||(c>='A'&&c<='F');
    }
}


在这个特殊的假期里，由于牛牛在家特别无聊，于是他发明了一个小游戏，游戏规则为：将字符串数字中为偶数位的数字进行翻转，
将翻转后的结果进行输出。
public class Solution {
    /**
     * 
     * @param number string字符串 
     * @return string字符串
     */
    public String change (String number) {
        // write code here
        char[] chars=number.toCharArray();
        int left=0;
        int right=chars.length-1;
        while(left<right){
            while(left<right&&(((chars[left]-'0')&1)==1)){
                left++;
            }
            while(left<right&&(((chars[right]-'0')&1)==1)){
                right--;
            }
            char c=chars[left];
            chars[left++]=chars[right];
            chars[right--]=c;
        }
        return new String(chars);
    }
}


牛牛有一个数组array，牛牛可以每次选择一个连续的区间，让区间的数都加1，他想知道把这个数组变为严格单调递增，最少需要操作多少次？



public class Solution {
    /**
     * 
     * @param array int整型一维数组 array
     * @return long长整型
     */
    public long IncreasingArray (int[] array) {
        // write code here
        long res=0;
        for(int i=0;i<array.length-1;i++){
            res+=Math.max(0,array[i]+1-array[i+1]);
        }
        return res;
    }
}




