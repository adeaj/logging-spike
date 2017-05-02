FROM registry.nutmeg.co.uk:8443/nutmeg/java:oracle-jre-1.8.0_102-alpine-3.4.0

LABEL APP_NAME=logging-spike


ADD logging-spike-1.0-SNAPSHOT.jar /logging-spike.jar
ADD start.sh /start.sh

RUN chown nutmeg:nutmeg /logging* && chmod u+x /start.sh

ENTRYPOINT	["/start.sh"]
