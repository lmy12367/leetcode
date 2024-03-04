class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        i = 0  # 第一个指针
        for j in range(0, len(nums)):  # 第二个指针
            if nums[j] != val:
                nums[i] = nums[j]
                i += 1
        return i
