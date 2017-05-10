FROM registry.cn-hangzhou.aliyuncs.com/acs/maven
ENV MY_HOME=/usr/src/app
RUN mkdir -p $MY_HOME
WORKDIR $MY_HOME
ADD pom.xml $MY_HOME

# get all the downloads out of the way
RUN ["/usr/local/bin/mvn-entrypoint.sh","mvn","verify","clean","--fail-never"]

# add source
ADD . $MY_HOME

# run maven install
RUN ["/usr/local/bin/mvn-entrypoint.sh","mvn","install"]

ENTRYPOINT  ["java","-jar","/usr/src/app/target/girl-0.0.1-SNAPSHOT.jar"]