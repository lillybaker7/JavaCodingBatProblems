public class Runner {

    //your main containing tests and output
    public static void main(String[] args) {

        System.out.println(countYZ("fez day"));
        System.out.println(countYZ("day fez"));
        System.out.println(countYZ("day fyyyz"));

        System.out.println(xyBalance("aaxbby"));
        System.out.println(xyBalance("aaxbb"));
        System.out.println(xyBalance("yaaxbb"));

        System.out.println(xyzThere("abcxyz"));
        System.out.println(xyzThere("abc.xyz"));
        System.out.println(xyzThere("xyz.abc"));

        System.out.println(lucky13([0, 2, 4]));
        System.out.println(lucky13([1, 2, 3]));
        System.out.println(lucky13([1, 2, 4]));

        System.out.println(has22([1, 2, 2]));
        System.out.println(has22([1, 2, 1, 2]));
        System.out.println(has22([2, 1, 2]));

        System.out.println(makeChocolate(4, 1, 9));
        System.out.println(makeChocolate(4, 1, 10));
        System.out.println(makeChocolate(4, 1, 7));

        System.out.println(evenlySpaced(2, 4, 6));
        System.out.println(evenlySpaced(4, 6, 2));
        System.out.println(evenlySpaced(4, 6, 3));

        System.out.println(blackjack(19, 21));
        System.out.println(blackjack(21, 19));
        System.out.println(blackjack(19, 22));

        System.out.println(closeFar(1, 2, 10));
        System.out.println(closeFar(1, 2, 3));
        System.out.println(closeFar(4, 1, 3));

        System.out.println(last2("hixxhi"));
        System.out.println(last2("xaxxaxaxx"));
        System.out.println(last2("axxxaaxx"));
    }

    public int countYZ(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (("yz".contains(str.substring(i, i+1).toLowerCase()))
                    && (i == str.length() - 1 || !Character.isLetter(str.charAt(i+1))))
            {
                sum++;
            }
        }
        return sum;
    }

    public boolean xyBalance(String str) {
        boolean balanced = true;
        int xIndex = -1;
        int yIndex = -1;
        if (str.contains("x"))
        {
            if (!str.contains("y"))
            {
                balanced = false;
            }
            else if (str.contains("y"))
            {
                for (int i = 0; i < str.length(); i++)
                {
                    if (str.substring(i, i+1).equals("x"))
                    {
                        xIndex = i;
                    }
                    if (str.substring(i, i+1).equals("y"))
                    {
                        yIndex = i;
                    }
                    if (yIndex <= xIndex)
                    {
                        balanced =  false;
                    }
                    else
                    {
                        balanced = true;
                    }
                }
            }
        }
        return balanced;
    }

    public boolean xyzThere(String str) {
        if (str.length() < 3) {
            return false;
        } else if (str.substring(0, 3).equals("xyz")) {
            return true;
        }
        for (int i = 1; i < str.length() - 2; i++){
            if (str.substring(i, i + 3).equals("xyz") && !str.substring(i - 1, i).equals(".")){
                return true;
            }
        }
        return false;
    }

    public boolean lucky13(int[] nums) {
        for (int num : nums)
        {
            if (num == 1 || num == 3)
            {
                return false;
            }
        }
        return true;
    }

    public boolean has22(int[] nums) {
        boolean two2s = false;
        for (int i = 0; i < nums.length-1; i++)
        {
            if (nums[i] == 2 && nums[i+1] == 2)
            {
                two2s = true;
            }
            if (two2s)
            {
                break;
            }
        }
        return two2s;
    }

    public int makeChocolate(int small, int big, int goal) {
        int sum = 0;
        if (big*5 + small >= goal)
        {
            for (int i = 0; i <= small; i++)
            {
                if (big*5 > goal)
                {
                    big--;
                }
                sum = big*5 + i;
                if (sum == goal)
                {
                    small = i;
                    break;
                }
                else if (sum < goal && i == small)
                {
                    small = -1;
                }
            }
            return small;
        }
        return -1;
    }

    public boolean evenlySpaced(int a, int b, int c) {
        int[] nums;
        nums = new int[3];
        nums[0] = a;
        nums[1] = b;
        nums[2] = c;
        Arrays.sort(nums);
        return (Math.abs(nums[0]-nums[1]) == Math.abs(nums[1]-nums[2]));
    }

    public int blackjack(int a, int b) {
        int a21diff = Math.abs(21-a);
        int b21diff = Math.abs(21-b);
        boolean aUnder21 = a <= 21;
        boolean bUnder21 = b <= 21;
        boolean bothUnder21 = aUnder21 && bUnder21;
        if (bothUnder21)
        {
            if (a21diff < b21diff)
            {
                return a;
            }
            else
            {
                return b;
            }
        }
        else if (aUnder21)
        {
            return a;
        }
        else if (bUnder21)
        {
            return b;
        }
        else
        {
            return 0;
        }
    }

    public boolean closeFar(int a, int b, int c) {
        int abdiff = Math.abs(b-a);
        int acdiff = Math.abs(c-a);
        int bcdiff = Math.abs(c-b);
        return ((abdiff <= 2 && acdiff >= 2 && bcdiff >= 2) || (acdiff <= 2 && abdiff >= 2 && bcdiff >= 2));
    }

    public int last2(String str) {
        int numberofSubstrings = 0;
        for (int i = 0; i < str.length() - 2; i+=1){
            if (str.substring(i, i+2).equals(str.substring(str.length() - 2, str.length())))
            {
                numberofSubstrings = numberofSubstrings + 1;
            }
        }
        return numberofSubstrings;

    }
}
