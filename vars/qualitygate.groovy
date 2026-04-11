def call(){
  sh """
  echo "sonar qube quality gates scanning"
  echo "===================================="
  timeout(time: 2, unit: "MINUTES"){
waitForQualityGate abortPipeline: false
  }
  echo "===================================="
  echo "sonarqube quality gates check completed"
  """
}
