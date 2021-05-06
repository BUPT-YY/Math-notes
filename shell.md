#！/bin/bash
#1、给定一个文本文件 file.txt，请只打印这个文件中的第十行.
sed -n 10p file.txt

awk 'NR == 10' file.txt

count=`cat file.txt | wc -l`
out=`cat file.txt | head -10 | tail -1
echo $out

#wc -l 是统计行数
#head -10 是打印开头十行
#tail -1 是打印最后一行



#2、统计一个文本文件 words.txt 中每个单词出现的频率
cat words.txt|tr ' ' '\n'|sed '/^$/d'|sort -d|uniq -c|sort -nr|awk '{print $2" "$1}'

#tr ' ' '\n'是把所有的' '替换为'\n'
# sed '/^$/d'是删除空行
# sed "/^#/d"是删除第一个字符是#的行
# sort -d 是对文件的行进行字典序排列
# uniq -c 把文件中重复出现的行筛选并删除显示出现几次在行首
# sort -nr 按照数字排列



#3、有效电话号码
你可以假设一个有效的电话号码必须满足以下两种格式： (xxx) xxx-xxxx 或 xxx-xxx-xxxx。（x 表示一个数字）
grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt
# grep -P 是使用Perl的正则表达式
# \d 表示[0-9]
# 括弧转义字符 \( \)
# ^表示行首，以...开始
# |是或者
# {n}匹配n位
# $：表示行尾，结束


#4、转置文件
输入
name age
alice 21
ryan 30
输出
name alice ryan
age 21 30

transpose=`head -n1 file.txt | wc -w`

for i in `seq 1 $transpose`
do
    echo `cut -d' ' -f$i file.txt`
done

# head -n 10 file.txt是打印前十行, 
# wc -w是显示有几个词
# for i in `seq 1 10`是i循环{1,2,...,10}
# cut -d' '以空格为域分割符, -f$i剪切第$i域
