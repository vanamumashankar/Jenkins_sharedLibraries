def call(String filename, String toolname){

    echo "Dependency Check started"
    echo "==============================="

    dependencyCheck additionalArguments: "--scan ./ --format XML --out .", odcInstallation: toolname

    dependencyCheckPublisher pattern: "**/dependency-check-report.xml"

    echo "======================================="
    echo "Dependency Check completed"
}
