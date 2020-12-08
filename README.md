<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns="http://www.springframework.org/schema/beans" xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">


<property name="controllerMap" >
            <map>
                <entry key="1" value-ref="balanceController"/>
                <entry key="2" value-ref="newAccountController"/>
                <entry key="3" value-ref="depositController"/>
                <entry key="4" value-ref="withdrawalController"/>
                <entry key="5" value-ref="recipientsController"/>
            </map>
        </property>


