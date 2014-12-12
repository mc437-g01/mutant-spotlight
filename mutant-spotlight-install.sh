#!/bin/bash

TOMCAT_VERSION=7.0.57
MUTANT_SPOTLIGHT_HOME=~/.mutant-spotlight
TOMCAT_HOME=$MUTANT_SPOTLIGHT_HOME/apache-tomcat-$TOMCAT_VERSION
URL=http://localhost:8081/mutant-spotlight

mkdir -p $MUTANT_SPOTLIGHT_HOME > /dev/null 2>&1

echo " - mutant-spotlight -"
echo

if [ ! -d $TOMCAT_HOME ]; then
    echo -n "Installing... "
    curl -L http://ftp.unicamp.br/pub/apache/tomcat/tomcat-7/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz -o $TOMCAT_HOME.tar.gz > /dev/null 2>&1
    tar -zxvf $TOMCAT_HOME.tar.gz -C $MUTANT_SPOTLIGHT_HOME > /dev/null 2>&1
    rm -f $TOMCAT_HOME.tar.gz > /dev/null
    # configuring tomcat to run on port 8081
    sed -e 's/port="8080/port="8081/g' -i.bak $TOMCAT_HOME/conf/server.xml 

    curl -L https://github.com/mc437-g01/mutant-spotlight/raw/master/dist/0.0.1/mutant-spotlight.war -o ~/mutant-spotlight.war > /dev/null 2>&1
    mv ~/mutant-spotlight.war $TOMCAT_HOME/webapps

    echo "OK"
fi

case "$1" in
    start)
            echo -n "Starting... "
            $TOMCAT_HOME/bin/startup.sh > /dev/null 2>&1
            echo "OK"
            echo "Opening at $URL..."
            sleep 10
            python -m webbrowser $URL
            
            ;;
   stop) 
          echo -n "Stopping... "
          $TOMCAT_HOME/bin/shutdown.sh > /dev/null 2>&1
          echo "OK"
           ;;
   restart)
          echo -n "Stopping... "
          $TOMCAT_HOME/bin/shutdown.sh > /dev/null 2>&1
          sleep 2
          echo "OK"
          echo -n "Starting... "
          $TOMCAT_HOME/bin/startup.sh > /dev/null 2>&1
          echo "OK"
          echo "Opening at $URL..."
	  sleep 10
          python -m webbrowser $URL
          ;;
        *)
          echo "Usage: mutant-spotlight start|stop|restart"
          exit 1
          ;;
    esac
