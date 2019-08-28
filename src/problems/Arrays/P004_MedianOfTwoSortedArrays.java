package problems.Arrays;

/**
 * Created by omkar on 10/9/18.
 */
public class P004_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        boolean flag = false;

        if(len1==1 && len2 ==1) {
            return (nums1[0]+nums2[0])/2;
        }


        if(len1==2 && len2==2) {
            return (Math.max(nums1[0],nums2[0]) + Math.min(nums1[1],nums2[1]))/2;
        }

        if(len1==1 || len2==1) {
            if(len1==1) {
                return subMedian(nums1,nums2);
            } else if(len2==1) {
                return subMedian(nums2,nums1);
            }
        }


        int l1 = 0, h1 = len1-1, l2 = 0, h2 = len2-1;
        double m1=0,m2=0;
        while((h1-l1) >= 2 && (h2-l2) >= 2) {
            m1 = median(nums1,l1,h1);
            m2 = median(nums2,l2,h2);
            int mid1 = (l1+h1) / 2;
            int mid2 = (l2+h2) / 2;
            if(m1 == m2 ) {
                ans = m1;
                flag = true;
                break;
            }
            else if(m1 > m2) {
                h1 = mid1;
                l2 = mid2;
            } else {
                l1 = mid1;
                h2 = mid2;
            }
        }

        if(!flag) {
            ans = (Math.max(nums1[l1],nums2[l2]) + Math.min(nums1[h1],nums2[h2])) / 2 ;
        }

        return ans;
    }

    private double subMedian(int[] arr1, int[] arr2) {
        int mid = arr2.length / 2;
        double res = 0;
        if(arr2.length/2==0) {

        }


        return res;
    }


    public double median(int[] arr, int l, int h) {
        double ans = 0;
        int mid = (h+l) / 2;
        if( (h-l) % 2 == 0) {
            ans = arr[mid];
        } else {
            ans = arr[mid]+arr[mid+1] / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        P004_MedianOfTwoSortedArrays obj = new P004_MedianOfTwoSortedArrays();
        int[] nums1 = {1};
        int[] nums2 = {2, 13};
        double res = obj.findMedianSortedArrays(nums1,nums2);
        System.out.print(res);
    }

}
