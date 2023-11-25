#!/usr/bin/env bash
BUILD_JAR=$(ls /home/ubuntu/action/build/libs/*.jar)
JAR_NAME=$(basename $BUILD_JAR)
TIME_NOW=$(date +%c)
echo ">>> build 파일명: $JAR_NAME" >> /home/ubuntu/action/deploytest.log

echo ">>> build 파일 복사" >> /home/ubuntu/action/deploytest.log
DEPLOY_PATH=/home/ubuntu/action/
cp $BUILD_JAR $DEPLOY_PATH

echo ">>> 현재 실행중인 애플리케이션 pid 확인" >> /home/ubuntu/action/deploytest.log
CURRENT_PID=$(pgrep -f $JAR_NAME)

if [ -z $CURRENT_PID ]
then
  echo ">>> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다." >> /home/ubuntu/action/deploytest.log
else
  echo ">>> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

DEPLOY_JAR=$DEPLOY_PATH$JAR_NAME
echo "$TIME_NOW>>> DEPLOY_JAR 배포"    >> /home/ubuntu/action/deploytest.log
echo "$TIME_NOWv>>> DEPLOY_JAR 주소 :   $DEPLOY_JAR "  >> /home/ubuntu/action/deploytest.log
nohup java -jar $DEPLOY_JAR >> /home/ubuntu/action/deploytest.log 2>/home/ubuntu/action/deploy_err.log &