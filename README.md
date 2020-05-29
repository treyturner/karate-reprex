# karate-reprex

My Gradle template for reproducing issues in [Karate](https://github.com/intuit/karate).

## Issue

HTTP requests and responses are not logged to console when `report` configuration has `showLog` set to `false`.

## Details
- In [logback.xml], I have `com.intuit.karate` set to `DEBUG`.  
- In [karate-config.js], I have the following line configuring reports:
  ```
  karate.configure('report', {showLog: false, showAllSteps: false})
  ```
- Whether I run the feature file in IDEA (using Cucumber Java plugin) or via the [KarateRunner.java] JUnit class, no HTTP request/response logs are printed to console with my report configuration active:
  ```
  Testing started at 3:40 PM ...
  "C:\Program Files\Java\jdk1.8.0_231\bin\java.exe" -Dorg.jetbrains.run.directory=C:\dev\karate-reprex\src\test\java\info\treyturner\karate\reprex "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.2.1\lib\idea_rt.jar=31283:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.2.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_231\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\rt.jar;C:\dev\karate-reprex\build\classes\java\test;C:\dev\karate-reprex\build\resources\test;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\com.intuit.karate\karate-junit5\0.9.6.RC2\b648f93c94aedeeb6b64675171cf0a6e153028b7\karate-junit5-0.9.6.RC2.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\com.intuit.karate\karate-apache\0.9.6.RC2\813360b6657b320b30a59c3c1681fa58bb7185c5\karate-apache-0.9.6.RC2.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter\5.6.2\b5c481685b6a8ca91c0d46f28f886a444354daa5\junit-jupiter-5.6.2.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-engine\1.6.2\1752cad2579e20c2b224602fe846fc660fb35805\junit-platform-engine-1.6.2.jar;C:\Users\Turnert\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.slf4j\slf4j-api\1.7.30\b5a4b6d16ab13e34a88fae84c35cd5d68cac922c\slf4j-api-1.7.30.jar;C:\Users\Turnert\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-api\5.6.2\c9ba885abfe975cda123bf6f8f0a69a1b46956d0\junit-jupiter-api-5.6.2.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\com.intuit.karate\karate-core\0.9.6.RC2\ef5ca77966e9f264d3277198796217120460c0f3\karate-core-0.9.6.RC2.jar;C:\Users\Turnert\.m2\repository\org\apache\httpcomponents\httpmime\4.5.12\httpmime-4.5.12.jar;C:\Users\Turnert\.m2\repository\org\apache\httpcomponents\httpclient\4.5.12\httpclient-4.5.12.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-params\5.6.2\f2a64a42cf73077062c2386db0598062b7480d91\junit-jupiter-params-5.6.2.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-commons\1.6.2\7644a14b329e76b5fe487628b50fb5eab6ba7d26\junit-platform-commons-1.6.2.jar;C:\Users\Turnert\.m2\repository\org\apiguardian\apiguardian-api\1.1.0\apiguardian-api-1.1.0.jar;C:\Users\Turnert\.m2\repository\org\opentest4j\opentest4j\1.2.0\opentest4j-1.2.0.jar;C:\Users\Turnert\.m2\repository\com\jayway\jsonpath\json-path\2.4.0\json-path-2.4.0.jar;C:\Users\Turnert\.m2\repository\info\cukes\cucumber-java\1.2.5\cucumber-java-1.2.5.jar;C:\Users\Turnert\.m2\repository\org\yaml\snakeyaml\1.24\snakeyaml-1.24.jar;C:\Users\Turnert\.m2\repository\de\siegmar\fastcsv\1.0.3\fastcsv-1.0.3.jar;C:\Users\Turnert\.m2\repository\info\picocli\picocli\4.0.3\picocli-4.0.3.jar;C:\Users\Turnert\.m2\repository\org\apache\httpcomponents\httpcore\4.4.13\httpcore-4.4.13.jar;C:\Users\Turnert\.m2\repository\commons-codec\commons-codec\1.11\commons-codec-1.11.jar;C:\Users\Turnert\.m2\repository\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;C:\Users\Turnert\.m2\repository\net\minidev\json-smart\2.3\json-smart-2.3.jar;C:\Users\Turnert\.m2\repository\info\cukes\cucumber-core\1.2.5\cucumber-core-1.2.5.jar;C:\Users\Turnert\.m2\repository\net\minidev\accessors-smart\1.2\accessors-smart-1.2.jar;C:\Users\Turnert\.m2\repository\org\ow2\asm\asm\5.0.4\asm-5.0.4.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-engine\5.6.2\c0833bd6de29dd77f8d071025b97b8b434308cd3\junit-jupiter-engine-5.6.2.jar;C:\Users\Turnert\.m2\repository\org\slf4j\jcl-over-slf4j\1.7.25\jcl-over-slf4j-1.7.25.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.2.1\plugins\junit\lib\junit-rt.jar;C:\Users\Turnert\AppData\Roaming\JetBrains\IdeaIC2020.1\plugins\cucumber-java\lib\cucumber-jvmFormatter.jar" cucumber.api.cli.Main --plugin org.jetbrains.plugins.cucumber.java.run.CucumberJvmSMFormatter --monochrome --glue com.intuit.karate C:/dev/karate-reprex/src/test/java/info/treyturner/karate/reprex/PostmanEcho.feature
  command: --plugin org.jetbrains.plugins.cucumber.java.run.CucumberJvmSMFormatter --monochrome --glue com.intuit.karate C:/dev/karate-reprex/src/test/java/info/treyturner/karate/reprex/PostmanEcho.feature
  15:40:02.998 [main] INFO  com.intuit.karate.Runner - waiting for parallel features to complete ...
  15:40:05.292 [pool-1-thread-1] INFO  com.intuit.karate.Runner - <<pass>> feature 1 of 1: src/test/java/info/treyturner/karate/reprex/PostmanEcho.feature
  ---------------------------------------------------------
  feature: src/test/java/info/treyturner/karate/reprex/PostmanEcho.feature
  report: target\surefire-reports\src.test.java.info.treyturner.karate.reprex.PostmanEcho.json
  scenarios:  1 | passed:  1 | failed:  0 | time: 1.9152
  ---------------------------------------------------------
  
  HTML report: (paste into browser to view) | Karate version: 0.9.6.RC2
  file:/C:/dev/karate-reprex/target/surefire-reports/karate-summary.html
  ===================================================================
  
  Karate version: 0.9.6.RC2
  ======================================================
  elapsed:   3.01 | threads:    1 | thread time: 1.92 
  features:     1 | ignored:    0 | efficiency: 0.64
  scenarios:    1 | passed:     1 | failed: 0
  ======================================================
  
  
  HTML report: (paste into browser to view) | Karate version: 0.9.6.RC2
  file:/C:/dev/karate-reprex/target/surefire-reports/karate-summary.html
  ===================================================================
  
  
  Process finished with exit code 0
  ```
- If I comment out the report configuration line in [karate-config.js], HTTP request/response logging is printed to console as expected.
  ```
  Testing started at 3:40 PM ...
  "C:\Program Files\Java\jdk1.8.0_231\bin\java.exe" -Dorg.jetbrains.run.directory=C:\dev\karate-reprex\src\test\java\info\treyturner\karate\reprex "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.2.1\lib\idea_rt.jar=31360:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.2.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_231\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\rt.jar;C:\dev\karate-reprex\build\classes\java\test;C:\dev\karate-reprex\build\resources\test;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\com.intuit.karate\karate-junit5\0.9.6.RC2\b648f93c94aedeeb6b64675171cf0a6e153028b7\karate-junit5-0.9.6.RC2.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\com.intuit.karate\karate-apache\0.9.6.RC2\813360b6657b320b30a59c3c1681fa58bb7185c5\karate-apache-0.9.6.RC2.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter\5.6.2\b5c481685b6a8ca91c0d46f28f886a444354daa5\junit-jupiter-5.6.2.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-engine\1.6.2\1752cad2579e20c2b224602fe846fc660fb35805\junit-platform-engine-1.6.2.jar;C:\Users\Turnert\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.slf4j\slf4j-api\1.7.30\b5a4b6d16ab13e34a88fae84c35cd5d68cac922c\slf4j-api-1.7.30.jar;C:\Users\Turnert\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-api\5.6.2\c9ba885abfe975cda123bf6f8f0a69a1b46956d0\junit-jupiter-api-5.6.2.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\com.intuit.karate\karate-core\0.9.6.RC2\ef5ca77966e9f264d3277198796217120460c0f3\karate-core-0.9.6.RC2.jar;C:\Users\Turnert\.m2\repository\org\apache\httpcomponents\httpmime\4.5.12\httpmime-4.5.12.jar;C:\Users\Turnert\.m2\repository\org\apache\httpcomponents\httpclient\4.5.12\httpclient-4.5.12.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-params\5.6.2\f2a64a42cf73077062c2386db0598062b7480d91\junit-jupiter-params-5.6.2.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-commons\1.6.2\7644a14b329e76b5fe487628b50fb5eab6ba7d26\junit-platform-commons-1.6.2.jar;C:\Users\Turnert\.m2\repository\org\apiguardian\apiguardian-api\1.1.0\apiguardian-api-1.1.0.jar;C:\Users\Turnert\.m2\repository\org\opentest4j\opentest4j\1.2.0\opentest4j-1.2.0.jar;C:\Users\Turnert\.m2\repository\com\jayway\jsonpath\json-path\2.4.0\json-path-2.4.0.jar;C:\Users\Turnert\.m2\repository\info\cukes\cucumber-java\1.2.5\cucumber-java-1.2.5.jar;C:\Users\Turnert\.m2\repository\org\yaml\snakeyaml\1.24\snakeyaml-1.24.jar;C:\Users\Turnert\.m2\repository\de\siegmar\fastcsv\1.0.3\fastcsv-1.0.3.jar;C:\Users\Turnert\.m2\repository\info\picocli\picocli\4.0.3\picocli-4.0.3.jar;C:\Users\Turnert\.m2\repository\org\apache\httpcomponents\httpcore\4.4.13\httpcore-4.4.13.jar;C:\Users\Turnert\.m2\repository\commons-codec\commons-codec\1.11\commons-codec-1.11.jar;C:\Users\Turnert\.m2\repository\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;C:\Users\Turnert\.m2\repository\net\minidev\json-smart\2.3\json-smart-2.3.jar;C:\Users\Turnert\.m2\repository\info\cukes\cucumber-core\1.2.5\cucumber-core-1.2.5.jar;C:\Users\Turnert\.m2\repository\net\minidev\accessors-smart\1.2\accessors-smart-1.2.jar;C:\Users\Turnert\.m2\repository\org\ow2\asm\asm\5.0.4\asm-5.0.4.jar;C:\Users\Turnert\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-engine\5.6.2\c0833bd6de29dd77f8d071025b97b8b434308cd3\junit-jupiter-engine-5.6.2.jar;C:\Users\Turnert\.m2\repository\org\slf4j\jcl-over-slf4j\1.7.25\jcl-over-slf4j-1.7.25.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.2.1\plugins\junit\lib\junit-rt.jar;C:\Users\Turnert\AppData\Roaming\JetBrains\IdeaIC2020.1\plugins\cucumber-java\lib\cucumber-jvmFormatter.jar" cucumber.api.cli.Main --plugin org.jetbrains.plugins.cucumber.java.run.CucumberJvmSMFormatter --monochrome --glue com.intuit.karate C:/dev/karate-reprex/src/test/java/info/treyturner/karate/reprex/PostmanEcho.feature
  command: --plugin org.jetbrains.plugins.cucumber.java.run.CucumberJvmSMFormatter --monochrome --glue com.intuit.karate C:/dev/karate-reprex/src/test/java/info/treyturner/karate/reprex/PostmanEcho.feature
  15:40:52.956 [main] INFO  com.intuit.karate.Runner - waiting for parallel features to complete ...
  15:40:54.700 [ForkJoinPool-1-worker-1] DEBUG com.intuit.karate - request:
  1 > GET https://postman-echo.com/get
  1 > Accept-Encoding: gzip,deflate
  1 > Connection: Keep-Alive
  1 > Host: postman-echo.com
  1 > User-Agent: Apache-HttpClient/4.5.12 (Java/1.8.0_231)
  
  15:40:55.177 [ForkJoinPool-1-worker-1] DEBUG com.intuit.karate - response time in milliseconds: 471.30
  1 < 200
  1 < Connection: keep-alive
  1 < Content-Length: 290
  1 < Content-Type: application/json; charset=utf-8
  1 < Date: Fri, 29 May 2020 20:40:55 GMT
  1 < ETag: W/"122-fGTg57uOeYgr00sV3ls6ZCaNMIc"
  1 < Vary: Accept-Encoding
  1 < set-cookie: sails.sid=s%3ALqVYYXrcbkJJ-VF7KnvXYJMCeMheKIi5.p0k24SMJDnckXmhS7SjkkNywbvYxb60MHzkvrbdpHIk; Path=/; HttpOnly
  {"args":{},"headers":{"x-forwarded-proto":"https","x-forwarded-port":"443","host":"postman-echo.com","x-amzn-trace-id":"Root=1-5ed17357-0928d17f476cd50bb58dde3f","user-agent":"Apache-HttpClient/4.5.12 (Java/1.8.0_231)","accept-encoding":"gzip,deflate"},"url":"https://postman-echo.com/get"}
  
  15:40:55.251 [pool-1-thread-1] INFO  com.intuit.karate.Runner - <<pass>> feature 1 of 1: src/test/java/info/treyturner/karate/reprex/PostmanEcho.feature
  ---------------------------------------------------------
  feature: src/test/java/info/treyturner/karate/reprex/PostmanEcho.feature
  report: target\surefire-reports\src.test.java.info.treyturner.karate.reprex.PostmanEcho.json
  scenarios:  1 | passed:  1 | failed:  0 | time: 1.9782
  ---------------------------------------------------------
  
  HTML report: (paste into browser to view) | Karate version: 0.9.6.RC2
  file:/C:/dev/karate-reprex/target/surefire-reports/karate-summary.html
  ===================================================================
  
  Karate version: 0.9.6.RC2
  ======================================================
  elapsed:   2.89 | threads:    1 | thread time: 1.98 
  features:     1 | ignored:    0 | efficiency: 0.69
  scenarios:    1 | passed:     1 | failed: 0
  ======================================================
  
  
  HTML report: (paste into browser to view) | Karate version: 0.9.6.RC2
  file:/C:/dev/karate-reprex/target/surefire-reports/karate-summary.html
  ===================================================================
  
  
  Process finished with exit code 0
  ```
- Based on my previous [issue #1078](https://github.com/intuit/karate/issues/1078), request/response logging in reports and console should be decoupled, but in addressing the previous former issue, logging to console was also affected.

[KarateRunner.java]: src/test/java/info/treyturner/karate/reprex/KarateRunner.java
[karate-config.js]: src/test/resources/karate-config.js
[logback.xml]: src/test/resources/logback.xml
