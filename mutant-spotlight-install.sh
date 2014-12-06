#!/bin/sh

TOMCAT_VERSION=7.0.57
MUTANT_SPOTLIGHT_HOME=~/.mutant-spotlight
TOMCAT_HOME=$MUTANT_SPOTLIGHT_HOME/apache-tomcat-$TOMCAT_VERSION
URL=http://localhost:8080/mutant-spotlight

mkdir -p $MUTANT_SPOTLIGHT_HOME

if [ ! -d $TOMCAT_HOME ]; then
    wget http://ftp.unicamp.br/pub/apache/tomcat/tomcat-7/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz -O $TOMCAT_HOME.tar.gz
    tar -zxvf $TOMCAT_HOME.tar.gz -C $MUTANT_SPOTLIGHT_HOME
    rm -f $TOMCAT_HOME.tar.gz
#    wget https://github.com/mc437-g01/mutant-spotlight/raw/master/dist/0.0.1/mutant-spotlight.war
    mv mutant-spotlight.war $TOMCAT_HOME/webapps
fi

case "$1" in
    start)
            echo -n "Starting mutant-spotlight:"
            $TOMCAT_HOME/bin/startup.sh
            echo "Opening mutant-spotlight at $URL..."
            sleep 10
            python -m webbrowser $URL
            ;;
   stop) 
          echo -n "Stopping mutant-spotlight:"
          $TOMCAT_HOME/bin/shutdown.sh
           ;;
   restart)
          echo -n "Stopping mutant-spotlight:"
          $TOMCAT_HOME/bin/shutdown.sh
          sleep 2
          echo -n "Starting mutant-spotlight:"
            $TOMCAT_HOME/bin/startup.sh
            echo "Opening mutant-spotlight at $URL..."
	    sleep 10
            python -m webbrowser $URL
            ;;
        *)
          echo "Usage: mutant-spotlight start|stop|restart"
          exit 1
          ;;
    esac
