# karate-reprex

My Gradle template for reproducing issues in [Karate](https://github.com/intuit/karate).


## Issue

In [Report Verbosity](https://github.com/intuit/karate#report-verbosity), it's noted you can configure a `showLog` property `false` to disable HTTP requests and responses from reports.

This doesn't seem to be effective in 0.9.5. You will get full HTTP logs in the report JSONs even with this property configured false.

It does seem you can prevent these logs from appearing in the JSON if `logback.xml` has package `com.intuit` configured to `OFF`. So, in order to disable the request/response logs in the JSON, I also have to disable them in my console and log files.

From what I can tell based on [this discussion](https://github.com/intuit/karate/issues/397), these should be decoupled now, and how it's currently working is how it operated prior to the showLog configuration property, making this a possible regression.


## Reproduction Steps

Check out the [karate-config.js](src/test/resources/karate-config.js). See that I've configured `showLog` to `false`:

```js
karate.configure('report', {showLog: false, showAllSteps: false})
```

Run the test:

- On Windows
  ```
  gradlew.bat test
  ```
- On OSX/Linux
  ```
  ./gradlew test
  ```
  
  
#### Expected:

HTTP logs aren't embedded into JSON reports because they've been disabled via `showLog: false`


#### Actual:

Inspect the [JSON report](target/surefire-reports/src.test.java.info.treyturner.karate.reprex.PostmanEcho.json), and see the HTTP logs are embedded as a doc_string:
```
"doc_string": {
  "content_type":"",
  "value":"22:21:00.363 request:\n1 > GET https:\/\/postman-echo.com\/get\n1 > Accept-Encoding: gzip,deflate\n1 > Connection: Keep-Alive\n1 > Host: postman-echo.com\n1 > User-Agent: Apache-HttpClient\/4.5.11 (Java\/1.8.0_231)\n\n22:21:00.933 response time in milliseconds: 566.76\n1 < 200\n1 < Connection: keep-alive\n1 < Content-Type: application\/json; charset=utf-8\n1 < Date: Thu, 12 Mar 2020 03:21:00 GMT\n1 < ETag: W\/\"e5-\/auUiuCmPVGrVRYFm\/Zmsg+i6K8\"\n1 < Server: nginx\n1 < Vary: Accept-Encoding\n1 < set-cookie: sails.sid=s%3Ae6GGEM5Sk-VGcK77n_WfMx_ZJ7QcHlDE.hWHS9GWpGXRuBykvYs4vhk6CBnBM9rROALI%2B90WxEpc; Path=\/; HttpOnly\n{\"args\":{},\"headers\":{\"x-forwarded-proto\":\"https\",\"host\":\"postman-echo.com\",\"accept-encoding\":\"gzip,deflate\",\"user-agent\":\"Apache-HttpClient\/4.5.11 (Java\/1.8.0_231)\",\"x-forwarded-port\":\"443\"},\"url\":\"https:\/\/postman-echo.com\/get\"}",
  "line":9}
}
```
