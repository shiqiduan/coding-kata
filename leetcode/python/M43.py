class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0":
            return "0"
        if len(num2) > len(num1):
            num1, num2 = num2, num1
        ret = "0"
        for i in range(len(num2)):
            temp = self._multiply(num1, num2[len(num2) - i - 1]) + "0" * i
            ret = self._add(ret, temp)
        return ret

    def _multiply(self, a: str, b: str) -> str:
        ret = []
        y = int(b)
        carry = 0
        for i in range(len(a)):
            x = int(a[len(a) - i - 1])
            r = x * y + carry
            ret.append(r % 10)
            carry = r // 10
        if carry > 0:
            ret.append(carry)
        ret.reverse()
        return "".join([str(x) for x in ret])

    def _add(self, a: str, b: str) -> str:
        ret = []
        x, y, carry = 0, 0, 0
        while x < len(a) or y < len(b) or carry != 0:
            ax = a[len(a) - x - 1] if x < len(a) else 0
            by = b[len(b) - y - 1] if y < len(b) else 0
            r = int(ax) + int(by) + carry
            ret.append(r % 10)
            carry = r // 10
            x = x + 1
            y = y + 1
        ret.reverse()
        return "".join([str(x) for x in ret])


if __name__ == "__main__":
    s = Solution()
    print(s._add("456", "789"))
    print(s._multiply("123", "456"))
    print(s.multiply("123", "456"))
