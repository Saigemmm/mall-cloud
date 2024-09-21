package org.sellers.basic.base.extraTest;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {
        String c="d";
        String a="abc"+c;
        String b="abcd";
        System.out.println(a==b);
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        StringTokenizer stringTokenizer=new StringTokenizer(s," ");//构建StringTokenizer对象，提供“ ”为指定分割符
        while (stringTokenizer.hasMoreElements()){  //判断是否还有分隔符
            System.out.println(stringTokenizer.nextToken());  //返回送当前位置到下一个分隔符的字符串
        }
    }

}
