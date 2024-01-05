public class MaxSubSeq_DC {
    static int maxSum = 0;

    public static void main(String[] args) {
        int[] input = {4, -3, 5, -2, -1, 2, 6,-2};
        maxSubSum(input, input.length, 0, input.length - 1);
        System.out.println(maxSum);
    }

    public static int max(int a,int b,int c)
    {
        if(a>b && a>c)
        {
            return a;
        }
        else if(b>c)
        {
            return b;
        }
        else
        {
            return c;
        }
    }
    public static void maxSubSum(int[] inputArr, int length, int start, int end) {
        //Generate left array and right array
        int l_ = length / 2;
        int j_ = l_;
        int maxLeftSum = 0, maxRightSum = 0, finalSum = 0,maxSumAtMoment=0,combinedSum=0;
        int[] leftArr = new int[l_];
        int[] rightArr = new int[l_];
         int maxLeftSum_=0;
         int maxRightSum_=0;
        for (int i = start; i < l_; i++) {
            leftArr[i] = inputArr[i];
            rightArr[i] = inputArr[j_++];
        }
        if (leftArr.length > 1 && rightArr.length > 1) {
            maxSubSum(leftArr, leftArr.length, 0, l_ - 1);
            maxSubSum(rightArr, rightArr.length, 0, l_ - 1);
        }
        //Sum
        for (int g = leftArr.length-1; g >= 0; g--) {
            maxLeftSum = maxLeftSum + leftArr[g];
            maxLeftSum_=maxLeftSum>maxLeftSum_?maxLeftSum:maxLeftSum_;


        }
        for (int g = 0; g < rightArr.length; g++) {

            maxRightSum = maxRightSum + rightArr[g];
            maxRightSum_=maxRightSum>maxRightSum_?maxRightSum:maxRightSum_;

        }



            finalSum = maxLeftSum_  + maxRightSum_ ;
        maxSum = max(maxLeftSum_,maxRightSum_,finalSum);

    }

}
