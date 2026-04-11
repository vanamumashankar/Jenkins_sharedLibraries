def call(String filename, String toolname){
    echo "Dependency Check started"
    echo "==============================="

    dependencyCheck additionalArguments: '--scan ./', odcInstallation: toolname
    dependencyCheckPublisher pattern: "**/${filename}-report.xml"

    echo "======================================="
    echo "Dependency Check completed"
}
