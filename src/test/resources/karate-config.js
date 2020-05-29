function fn() {    
  var env = karate.env // get system property 'karate.env'
  if (!env) { env = 'test' }
  var config = {
    env: env,
  }
  // Configure reports to not show raw HTTP requests/responses, and to skip non-BDD (asterisk) steps
  karate.configure('report', {showLog: false, showAllSteps: false})
  return config
}
