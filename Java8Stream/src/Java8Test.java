import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: licg
 * @Date: 2019/1/21
 */
public class Java8Test {
    public static void main(String[] args) {
        // 计算空字符串
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("列表：" + strings);
        long count = getCountEmptyStringUsingJava7(strings);
        System.out.println("空字符数量：" + count);

        count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符数量：" + count);

        // 删除空字符串
        List<String> filtered = deleteEmptyStringUsingJava7(strings);
        System.out.println("刷选后的列表：" + filtered);

        filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("刷选后的列表：" + filtered);


        // 删除空字符串，并使用逗号合并起来
        String mergedString = getMergedStringUsingJava7(strings, ",");
        System.out.println("合并字符串：" + mergedString);

        mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串：" + mergedString);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        // 获取列表元素平方值
        List<Integer> squaresList = getSquares(numbers);
        System.out.println("平方数列表：" + squaresList);

        squaresList = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println("平方数列表：" + squaresList);

        // 获取列表最大最小值
        System.out.println("列表最大值：" + getMax(numbers));
        System.out.println("列表最小值：" + getMin(numbers));

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表最大值：" + stats.getMax());
        System.out.println("列表最小值：" + stats.getMin());
        // 获取列表平均值
        System.out.println("列表平均值：" + stats.getAverage());
    }

    // 统计空字符串的个数
    private static long getCountEmptyStringUsingJava7(List<String> strings){
        long count = 0;
        for (String string : strings){
            if (string.isEmpty()){
                count++;
            }
        }
        return count;
    }

    // 删除空字符串
    private static List<String> deleteEmptyStringUsingJava7(List<String> strings){
        List<String> filteredList = new ArrayList<>();
        for (String string : strings) {
            if (!string.isEmpty()){
                filteredList.add(string);
            }
        }
        return filteredList;
    }

    // 以逗号为分隔符合并字符串
    private static String getMergedStringUsingJava7(List<String> strings, String separator){
        StringBuilder sb = new StringBuilder();
        for (String string : strings){
            if (!string.isEmpty()){
                sb.append(string);
                sb.append(separator);
            }
        }
        return sb.toString();
    }


    // 获取平方值
    private static List<Integer> getSquares(List<Integer> numbers){
        List<Integer> squaresList = new ArrayList<>();
        for (Integer number : numbers){
            squaresList.add(number * number);
        }
        return squaresList;
    }

    // 获取最大值
    private static int getMax(List<Integer> numbers){
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max)
                max = numbers.get(i);
        }
        return max;
    }

    // 获取最小值
    private static int getMin(List<Integer> numbers){
        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min)
                min = numbers.get(i);
        }
        return min;
    }
}