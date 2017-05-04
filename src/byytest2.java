import java.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2017/3/22/022.
 */
public class byytest2 {
    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    int r = 99; //随机数个数
    Scanner s = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("######0.00"); //取小数后两位
    double ture=0,all=0;   //题目正确率计数

/*    String [] getrandom() {
        String [] number = new String[2];
        switch ((int) (Math.random() * 2)) {
            case 0:
                int num;
                num = (int) (Math.random() * 99) + 1;
                number[0] = String.valueOf(num);
                number[1] = "ZS";
                break;
            default:
                int n1 = (int) (Math.random() * 99) + 1;
                int n2 = (int) (Math.random() * (99 - n1)) + n1 + 1;
                number[0] = String.valueOf(n1) + "/" + String.valueOf(n2);
                number[1] = "FS";
                break;
        }
        return number;
    } */

    void getrandomnum() {
        list1.clear();  //完成一题后清除数组
        int n1, n2, n3, n4;
        int temp = (int) (Math.random() * 4);   //运算种类判断

        if (temp == 0) {   //整数运算
            n1 = (int) (Math.random() * r) + 1;
            n2 = (int) (Math.random() * r) + 1;
            list1.add(String.valueOf(n1));
            list1.add("ZS");
            list1.add(String.valueOf(n2));
            list1.add("ZS");
        }
        else if (temp == 1) {  //整数分数运算
            n1 = (int) (Math.random() * r) + 1;
            n2 = (int) (Math.random() * r) + 1;
            n3 = (int) (Math.random() * (r - n2)) + n2 + 1;
            //n3 = (int) (Math.random() * 99) + 1;
            list1.add(String.valueOf(n1));
            list1.add("ZS");
            //if(n2>n3)
            //    list1.add(String.valueOf(n3 + "/" + n2));
            //else
            list1.add(String.valueOf(n2 + "/" + n3));
            list1.add("FS");
        }
        else if (temp == 2) {  //分数整数运算
            n1 = (int) (Math.random() * r) + 1;
            n2 = (int) (Math.random() * r) + 1;
            n3 = (int) (Math.random() * (r - n2)) + n2 + 1;
            //n3 = (int) (Math.random() * 99) + 1;
            list1.add(String.valueOf(n2 + "/" + n3));
            list1.add("FS");
            //if(n2>n3)
            //    list1.add(String.valueOf(n3 + "/" + n2));
            //else
            list1.add(String.valueOf(n1));
            list1.add("ZS");
        }
        else {   //分数运算
            n1 = (int) (Math.random() * r) + 1;
            n2 = (int) (Math.random() * (r - n1)) + n1 + 1;
            //n2 = (int) (Math.random() * 99) + 1;
            n3 = (int) (Math.random() * r) + 1;
            n4 = (int) (Math.random() * (r - n3)) + n3 + 1;
            //n4 = (int) (Math.random() * 99) + 1;
            //if (n1>n2)
            //    list1.add(String.valueOf(n2 + "/" + n1));
            //else
            list1.add(String.valueOf(n1 + "/" + n2));
            list1.add("FS");
            //if (n3>n4)
            //    list1.add(String.valueOf(n4 + "/" + n3));
            //else
            list1.add(String.valueOf(n3 + "/" + n4));
            list1.add("FS");
        }
    }

    void repeat(int lenlist2){
        for(int i = 0;i<lenlist2;i++){
            if(list2.get(lenlist2).equals(list2.get(i))){
                list2.remove(lenlist2);
                System.out.println("题目重复 正在重新出题\n");
                text();
            }
        }
    }

    void text() {   //题目输出函数
        getrandomnum(); //随机数产生
        int a=(int)all+1;   //题目计数，便于观看
        String []num1 = new String[2];
        String []num2 = new String[2];
        num1[0] = list1.get(0);    //取出数组中的整数或分数
        num2[0] = list1.get(2);
        int flag = (int) (Math.random() * 4);   //运算符判断
        if (flag == 0) {
            int lenlist2 = list2.size();
            list2.add(String.valueOf(num1[0] + " + " + num2[0]));
                repeat(lenlist2);
            list2.add(String.valueOf(num2[0] + " + " + num1[0]));
                repeat(lenlist2);
            System.out.println(a + ". " + num1[0] + " + " + num2[0] + " = ?");
        }
        else if (flag == 1) {
            int lenlist2 = list2.size();
            list2.add(String.valueOf(num1[0] + " - " + num2[0]));
            repeat(lenlist2);
            System.out.println(a + ". " + num1[0] + " - " + num2[0] + " = ?");
        }
        else if (flag == 2) {
            int lenlist2 = list2.size();
            list2.add(String.valueOf(num1[0] + " * " + num2[0]));
            repeat(lenlist2);
            list2.add(String.valueOf(num2[0] + " * " + num1[0]));
            repeat(lenlist2);
            System.out.println(a + ". " + num1[0] + " * " + num2[0] + " = ?");
        }
        else {
            int lenlist2 = list2.size();
            list2.add(String.valueOf(num1[0] + " / " + num2[0]));
            repeat(lenlist2);
            System.out.println(a + ". " + num1[0] + " / " + num2[0] + " = ?");
        }
        Calculate(num1,num2,flag);
    }

    void Calculate(String []num1,String []num2,int flag){   //计算函数
        String result = "";
        num1[1] = list1.get(1);    //取出数组中的整数或分数
        num2[1] = list1.get(3);

        if(num1[1]=="ZS" && num2[1]=="ZS"){
            //num1 = num1[0].split("/");
            //num2 = num2[0].split("/");
            int num11 = Integer.parseInt(num1[0]);  //整数1
            int num21 = Integer.parseInt(num2[0]);  //整数2
            if(flag == 0){
                result = String.valueOf(num11 + num21);
            }
            else if (flag == 1){
                result = String.valueOf(num11 - num21);
            }
            else if (flag == 2){
                result = String.valueOf(num11 * num21);
            }
            else {
                result = String.valueOf(num11 + "/" + num21);
            }
        }
        else if (num1[1]=="ZS" && num2[1]=="FS"){
            //num1 = num1[0].split("/");
            num2 = num2[0].split("/");
            int num11 = Integer.parseInt(num1[0]);  //整数
            int num21 = Integer.parseInt(num2[0]);  //分数分子
            int num22 = Integer.parseInt(num2[1]);  //分数分母
            if(flag == 0){
                result = String.valueOf((num11 * num22) + num21 + "/" + num22);
            }
            else if (flag == 1){
                result = String.valueOf((num11 * num22) - num21 + "/" + num22);
            }
            else if (flag == 2){
                result = String.valueOf((num11 * num21) + "/" + num22);
            }
            else {
                result = String.valueOf((num11 * num22) + "/" + num21);
            }
        }
        else if (num1[1]=="FS" && num2[1]=="ZS"){
            num1 = num1[0].split("/");
            //num2 = num2[0].split("/");
            int num11 = Integer.parseInt(num1[0]);  //分数分子
            int num12 = Integer.parseInt(num1[1]);  //分数分母
            int num21 = Integer.parseInt(num2[0]);  //整数
            if(flag == 0){
                result = String.valueOf(num11 + (num12 * num21) + "/" + num12);
            }
            else if (flag == 1){
                result = String.valueOf(num11 - (num12 * num21) + "/" + num12);
            }
            else if (flag == 2){
                result = String.valueOf((num11 * num21) + "/" + num12);
            }
            else {
                result = String.valueOf(num11 + "/" + (num12*num21));
            }
        }
        else {
            num1 = num1[0].split("/");
            num2 = num2[0].split("/");
            int num11 = Integer.parseInt(num1[0]);  //分数1分子
            int num12 = Integer.parseInt(num1[1]);  //分数1分母
            int num21 = Integer.parseInt(num2[0]);  //分数2分子
            int num22 = Integer.parseInt(num2[1]);  //分数2分母
            if(flag == 0){
                result = String.valueOf(((num11 * num22) + (num12 * num21)) + "/" + (num12 * num22));
            }
            else if (flag == 1){
                result = String.valueOf(((num11 * num22) - (num12 * num21)) + "/" + (num12 * num22));
            }
            else if (flag == 2){
                result = String.valueOf((num11 * num21) + "/" + (num12 * num22));
            }
            else {
                result = String.valueOf((num11 * num22) + "/" + (num12 * num21));
            }
        }
        if (result.indexOf("/")!= -1) {
            result = huajian(result);
        }
        System.out.println("请输入最简答案:");
        String line = s.nextLine();

        judge(line);  //2017年3月29日20:09:01新增判断

        if (line.compareTo(result) == 0) {
            System.out.println("正确！");
            ture++;
        }
        else{
            System.out.println("错误！答案为" + result + "。");
        }
        all++;
        System.out.println("正确率为" + df.format(ture/all*100) + "%。");
    }

    void judge(String line){  //2017年3月29日20:09:01新增
        while(true){
            int p = 0;
            switch (p){
                case 0:
                    if(line.indexOf("/0") != -1){ //分母输入不能为0
                        System.out.println("你数学老师棺材板我按住了,分母不能为0! 重新答!");
                        line = s.nextLine();
                        break;
                    }
                    else{
                        p++;
                    }
                case 1:
                    if(line.length() == 0){ //必须输入字符
                        System.out.println("你不会你也蒙一个啊! 重新答!");
                        line = s.nextLine();
                        break;
                    }
                    else{
                        p++;
                    }
                case 2:
                    char ch;
                    for (int i = 0; i < line.length(); i++) {   //提取每个字符进行判断
                        ch = line.charAt(i);
                    if((ch < '/' || ch > '9') || //  输入的字符在 / 0 1 2 3 4 5 6 7 8 9 之中
                            line.indexOf("/") == 0 || // 且 / 不在第一位
                            line.indexOf("/") == line.length() - 1 || //也不在最后一位（必须有分母）
                            line.indexOf(" ") != -1){
                        System.out.println("你数学老师棺材板我按不住了,答的是数字吗! 重新答!");
                        line = s.nextLine();
                        for (int j = 0; j < line.length(); j++) {
                            ch = line.charAt(j);
                        }
                        break;
                    }
                    else{
                        p++;
                    }
                }
            }
            if(p==3){
                break;
            }
        /*while (line.indexOf("/0") != -1) { // 分母输入不能为0
            System.out.println("你数学老师棺材板我按住了,分母不能为0! 重新答!");
            line = s.nextLine();
        }
        while (line.length() == 0) {    //必须输入字符
            System.out.println("你不会你也蒙一个啊! 重新答!");
            line = s.nextLine();
        }
        char ch;
        for (int i = 0; i < line.length(); i++) {   //提取每个字符进行判断
            ch = line.charAt(i);
            while ((ch < '/' || ch > '9') || //  输入的字符在 / 0 1 2 3 4 5 6 7 8 9 之中
                    line.indexOf("/") == 0 || // 且 / 不在第一位
                    line.indexOf("/") == line.length() - 1 || //也不在最后一位（必须有分母）
                    line.indexOf(" ") != -1) {  //且不能输入空格
                System.out.println("你数学老师棺材板我按不住了,答的是数字吗! 重新答!");
                line = s.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    ch = line.charAt(j);
                }
            }*/
        }   //2017年3月29日20:09:01新增 判断各种输入结果
    }

    String huajian(String result){
        String s[] = result.split("/"); //获取未化简的答案
        String newresult = "";  //化简的新答案
        int n1 = Math.abs(Integer.parseInt(s[0]));    //分子
        int n2 = Math.abs(Integer.parseInt(s[1]));    //分母
        int maxcommon = 1;  //最大公约数
        if (n1>n2){ //如果分子比分母大
            while(n1 % n2 != 0){
                maxcommon = n1 % n2;
                n1 = n2;
                n2 = maxcommon;
            }
            newresult = String.valueOf((Integer.parseInt(s[0])/maxcommon) + "/" + (Integer.parseInt(s[1])/maxcommon));
        }
        else{   //如果分子比分母小，先交换再计算
            int t = n1;
            n1 = n2;
            n2 = t;
            while(n1 % n2 != 0){
                maxcommon = n1 % n2;
                n1 = n2;
                n2 = maxcommon;
            }
            newresult = String.valueOf((Integer.parseInt(s[0])/maxcommon) + "/" + (Integer.parseInt(s[1])/maxcommon));
        }
        return newresult;   //传回新值
    }
    public static void main(String[] args)
    {
        byytest2 b = new byytest2();
        System.out.println("来做题吧?(输入 exit 退出，按Enter键出题)");
        //String scan = b.s.nextLine();
        while(true) {
            if (b.s.nextLine().equals("exit")){
                break;
            }
            else {
                b.text();
            }
        }
        //String str = "abcdefga";
        //System.out.println(str.indexOf("q"));
    }
}
//基本功能实现 待完善 2017年3月25日04:22:05
//编写的时候遇到的错误 或者想到更好的算法 没有把旧算法del而是备注了所以有点多。。
//任务三功能实现 待完善 2017年4月7日16:40:12 主要添加了 judge 和 repeat 函数