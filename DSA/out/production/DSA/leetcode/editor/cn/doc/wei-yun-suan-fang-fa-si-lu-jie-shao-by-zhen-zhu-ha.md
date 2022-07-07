### 解题思路
由于题目提示可以不用额外的数据结构解题，那么我们应该抛弃直观上的用set解题的方法。双重循环的暴力求解由于O(n^2)的时间复杂度，也不应该考虑。
位运算方法的思路本质上，跟使用一个bool数组来记录```astr```的每一位是否已经出现过的思路是一样的。

**基于bool数组的方法：**
由于题目没有明确说明，根据示例我判断字符串中出现的字符应该在```['a','z']```之间，实践证明确实如此。基于这个前提，使用bool数组的做法是定义一个长度为26的初始值全为0 bool数组，逐个字符遍历```astr```，如果bool数组中对应的下标（'a'->0, ..., 'z'->25）的值为1则重复出现，返回false，否则设置对应下标值为1。

**基于位运算的方法：**
我们可以使用一个int类型的变量（下文用```mark```表示）来代替长度为26的bool数组。假设这个变量占26个bit（在多数语言中，这个值一般不止26），那么我们可以把它看成000...00(26个0)，这26个bit对应着26个字符，对于一个字符c，检查对应下标的bit值即可判断是否重复。那么难点在于如何检查？这里我们可以通过位运算来完成。首先计算出字符```char```离```'a'```这个字符的距离，即我们要位移的距离，用```move_bit```表示，那么使用左移运算符```1 << move_bit```则可以得到对应下标为1，其余下标为0的数，如字符```char = 'c'```，则得到的数为000...00100，将这个数跟```mark```做与运算，由于这个数只有一个位为1，其他位为0，那么与运算的结果中，其他位肯定是0，而对应的下标位是否0则取决于之前这个字符有没有出现过，若出现过则被标记为1，那么与运算的结果就不为0；若之前没有出现过，则对应位的与运算的结果也是0，那么整个结果也为0。对于没有出现过的字符，我们用或运算```mark | (1 << move_bit)```将对应下标位的值置为1。

由于没有看到比较清楚的位运算题解，所以自己写了一下，不知道解释清楚了没有(´･_･`)

### 代码

```python
class Solution:
  def isUnique(self, astr: str) -> bool:
    mark = 0
    for char in astr:
      move_bit = ord(char) - ord('a')
      if (mark & (1 << move_bit)) != 0:
        return False
      else:
        mark |= (1 << move_bit)
    return True
```