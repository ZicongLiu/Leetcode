class Solution(object):
    def __init__(self, nums):

        count = {}
        for num in nums:
            count[num] = count.get(num, 0) + 1

        start, startstop = 0, count
        for num in count:
            startstop[num], start = (start << 32) | start, start + count[num]

        indexes = [None] * len(nums)
        for i, num in enumerate(nums):
            indexes[startstop[num] & 0xFFFFFFFF] = i
            startstop[num] += 1

        self.indexes = indexes
        self.startstop = startstop
        
    def pick(self, target):
        ss = self.startstop[target]
        return self.indexes[random.randrange(ss >> 32, ss & 0xFFFFFFFF)]




OR




class Solution(object):
    
    def __init__(self, nums):
        indexes = self.indexes = {}
        for i, num in enumerate(nums):
            I = indexes.get(num)
            if I is None:
                indexes[num] = i
            elif isinstance(I, int):
                indexes[num] = [I, i]
            else:
                indexes[num].append(i)

    def pick(self, target):
        I = self.indexes[target]
        return I if isinstance(I, int) else random.choice(I)