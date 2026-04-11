def call(String toolname, String name){
  sh """
  echo "sonar project created"
  echo "======================================"
withSonarQubeEnv(${toolname}){
sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.ptojrctName=${name} -sonar.projectKey=${name}
echo "======================================"
echo "Sonar qube ended"
}
"""
}

