#!/bin/bash
#进行ubuntu系统与软件更新
   sudo apt-get  update
   sudo  apt-get upgrade


#建立文件目录进入目录
  mkdir -p /root/alist-tvbox/ && cd /root/alist-tvbox/



#选择github源
  wget https://github.com/power721/alist-tvbox/releases/download/v1.1.1/alist-tvbox-1.0.jar
  
 
#运行
  java -jar alist-tvbox-1.0.jar
