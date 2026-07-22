class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ar=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ar[0]=map.get(target-nums[i]);
                ar[1]=i;
                break;
            }
            map.put(nums[i],i);
            
                
        }
        return ar;
    }
}
