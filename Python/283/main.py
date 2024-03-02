class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        index=0
        for number in nums:
            if number !=0:
                nums[index]=number
                index +=1

        for i in range(index,len(nums)):
            nums[i]=0
print(nums)