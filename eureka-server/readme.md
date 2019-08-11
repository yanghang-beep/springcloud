##  Eureka Server的Rest API
###  概念
Eureka Server允许非JAVA语言介入， 所以提供了Rest HTTP来让其他语言介入到服务的注册和发现中。
###  列表

> 懒得码字了， 转载自 https://www.jianshu.com/p/c24e622f3f45

eureka信息查看
get: {ip:port}/eureka/status

注册到eureka的服务信息查看
get: {ip:port}/eureka/apps

注册到eureka的具体的服务查看
get: {ip:port}/eureka/apps/{appname}/{id}
对应eureka源码的：InstanceResource.getInstanceInfo

服务续约
put：{ip:port}/eureka/apps/{appname}/{id}?lastDirtyTimestamp={}&status=up
对应eureka源码的：InstanceResource.renewLease

更改服务状态
put：{ip:port}/eureka/apps/{appname}/{id}/status?lastDirtyTimestamp={}&value={UP/DOWN}
对应eureka源码的：InstanceResource.statusUpdate

删除状态更新
delete：{ip:port}/eureka/apps/{appname}/{id}/status?lastDirtyTimestamp={}&value={UP/DOWN}
对应eureka源码的：InstanceResource.deleteStatusUpdate

删除服务
delete: {ip:port}/eureka/apps/{appname}/{id}
对应eureka源码的：InstanceResource.cancelLease
###  JSON文件

    {
    	"info": {
    		"_postman_id": "2fbb0980-9df7-4a96-963c-309644abfe6d",
    		"name": "Spring Cloud",
    		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
    	},
    	"item": [
    		{
    			"name": "RestApi",
    			"item": [
    				{
    					"name": "查看所有服务",
    					"request": {
    						"method": "GET",
    						"header": [],
    						"url": {
    							"raw": "http://localhost:1001/eureka/apps",
    							"protocol": "http",
    							"host": [
    								"localhost"
    							],
    							"port": "1001",
    							"path": [
    								"eureka",
    								"apps"
    							]
    						}
    					},
    					"response": []
    				},
    				{
    					"name": "向注册中心注册实例",
    					"request": {
    						"method": "POST",
    						"header": [
    							{
    								"key": "Content-Type",
    								"name": "Content-Type",
    								"type": "text",
    								"value": "application/xml"
    							}
    						],
    						"body": {
    							"mode": "raw",
    							"raw": "<instance>\n\t<instanceId>demo-order2:11101</instanceId>\n    <hostName>127.0.0.1</hostName>\n\t<app>DEMO-ORDER2</app>\n    <ipAddr>127.0.0.1</ipAddr>\n\t<status>UP</status>\n\t<overriddenstatus>UNKNOWN</overriddenstatus>\n\t<port enabled=\"true\">11101</port>\n\t<securePort enabled=\"false\">443</securePort>\n\t<countryId>1</countryId>\n\t<dataCenterInfo class=\"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\">\n\t    <name>MyOwn</name>\n\t</dataCenterInfo>\n\t<metadata class=\"java.util.Collections$EmptyMap\"/>\n\t<vipAddress>demo-order2</vipAddress>\n\t<secureVipAddress>demo-order2</secureVipAddress>\n\t<isCoordinatingDiscoveryServer>false</isCoordinatingDiscoveryServer>\n\t<lastUpdatedTimestamp>1540186708769</lastUpdatedTimestamp>\n\t<lastDirtyTimestamp>1540186708747</lastDirtyTimestamp>\n</instance>"
    						},
    						"url": {
    							"raw": "http://localhost:1001/eureka/apps/demo-order2",
    							"protocol": "http",
    							"host": [
    								"localhost"
    							],
    							"port": "1001",
    							"path": [
    								"eureka",
    								"apps",
    								"demo-order2"
    							]
    						}
    					},
    					"response": []
    				},
    				{
    					"name": "删除实例",
    					"request": {
    						"method": "DELETE",
    						"header": [
    							{
    								"key": "Content-Type",
    								"name": "Content-Type",
    								"type": "text",
    								"value": "application/xml"
    							}
    						],
    						"body": {
    							"mode": "raw",
    							"raw": ""
    						},
    						"url": {
    							"raw": "http://localhost:1001/eureka/apps/EUREKA-CLIENT/windows10.microdone.cn:eureka-client:8081",
    							"protocol": "http",
    							"host": [
    								"localhost"
    							],
    							"port": "1001",
    							"path": [
    								"eureka",
    								"apps",
    								"EUREKA-CLIENT",
    								"windows10.microdone.cn:eureka-client:8081"
    							]
    						}
    					},
    					"response": []
    				},
    				{
    					"name": "暂停/下线应用实例",
    					"request": {
    						"method": "PUT",
    						"header": [],
    						"url": {
    							"raw": "http://localhost:1001/eureka/apps/EUREKA-CLIENT/windows10.microdone.cn:eureka-client:8081/status?value=OUT_OF_SERVICE",
    							"protocol": "http",
    							"host": [
    								"localhost"
    							],
    							"port": "1001",
    							"path": [
    								"eureka",
    								"apps",
    								"EUREKA-CLIENT",
    								"windows10.microdone.cn:eureka-client:8081",
    								"status"
    							],
    							"query": [
    								{
    									"key": "value",
    									"value": "OUT_OF_SERVICE"
    								}
    							]
    						}
    					},
    					"response": []
    				},
    				{
    					"name": "恢复应用实例",
    					"request": {
    						"method": "DELETE",
    						"header": [],
    						"url": {
    							"raw": "http://localhost:1001/eureka/apps/EUREKA-CLIENT/windows10.microdone.cn:eureka-client:8081/status?value=UP",
    							"protocol": "http",
    							"host": [
    								"localhost"
    							],
    							"port": "1001",
    							"path": [
    								"eureka",
    								"apps",
    								"EUREKA-CLIENT",
    								"windows10.microdone.cn:eureka-client:8081",
    								"status"
    							],
    							"query": [
    								{
    									"key": "value",
    									"value": "UP"
    								}
    							]
    						}
    					},
    					"response": []
    				},
    				{
    					"name": "应用实例发送心跳",
    					"request": {
    						"method": "PUT",
    						"header": [],
    						"url": {
    							"raw": "http://localhost:1001/eureka/apps/EUREKA-CLIENT/windows10.microdone.cn:eureka-client:8081",
    							"protocol": "http",
    							"host": [
    								"localhost"
    							],
    							"port": "1001",
    							"path": [
    								"eureka",
    								"apps",
    								"EUREKA-CLIENT",
    								"windows10.microdone.cn:eureka-client:8081"
    							]
    						}
    					},
    					"response": []
    				},
    				{
    					"name": "修改元数据",
    					"request": {
    						"method": "PUT",
    						"header": [],
    						"url": {
    							"raw": "http://localhost:1001/eureka/apps/EUREKA-CLIENT/windows10.microdone.cn:eureka-client:8081/metadata?profile=canary",
    							"protocol": "http",
    							"host": [
    								"localhost"
    							],
    							"port": "1001",
    							"path": [
    								"eureka",
    								"apps",
    								"EUREKA-CLIENT",
    								"windows10.microdone.cn:eureka-client:8081",
    								"metadata"
    							],
    							"query": [
    								{
    									"key": "profile",
    									"value": "canary"
    								}
    							]
    						}
    					},
    					"response": []
    				}
    			]
    		}
    	]
    }
## Eureka的实例状态
在InstanceStatus这个枚举类中定义的。实例共有五种状态。

```
        UP, // Ready to receive traffic
        DOWN, // Do not send traffic- healthcheck callback failed
        STARTING, // Just about starting- initializations to be done - do not
        // send traffic
        OUT_OF_SERVICE, // Intentionally shutdown for traffic
        UNKNOWN;
```
##  服务的核心操作
对于服务实例来说，主要有如下几个操作。

 1. 服务注册（register）
 2. 服务下线（cancel）
 3. 服务租约（renew）
 4. 服务剔除（evict）
 
 com.netflix.eureka.lease.LeaseManager，这个接口定义了这几项操作。
 com.netflix.discovery.shared.LookupService ，这个接口定义了Client端从注册中心获取服务列表的方法。
