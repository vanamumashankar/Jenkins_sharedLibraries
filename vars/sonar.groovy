def call(String toolname, String name){
  sh """
  echo "sonar project created"
  echo "======================================"
withSonarQubeEnv("${toolname}"){
$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${name} -Dsonar.projectKey=${name}
echo "======================================"
echo "Sonar qube ended"
}
"""
}

