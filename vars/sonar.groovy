def call(String toolname, String name){
    echo "sonar project created"
    echo "======================================"

    withSonarQubeEnv("${toolname}") {
        sh """
        ${SONAR_HOME}/bin/sonar-scanner \
        -Dsonar.projectName=${name} \
        -Dsonar.projectKey=${name}
        """
    }

    echo "======================================"
    echo "Sonar qube ended"
}
