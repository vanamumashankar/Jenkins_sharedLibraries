def call(){

    echo "SonarQube Quality Gate check started"
    echo "===================================="

    timeout(time: 2, unit: 'MINUTES') {
        waitForQualityGate abortPipeline: false
    }

    echo "===================================="
    echo "SonarQube Quality Gate check completed"
}
