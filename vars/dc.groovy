def call(String filename, String toolname){
  sh """
  echo "dc check ha been started"
  echo "==============================="
  dependencyCheck additionalArguments: '--scan ./', odcInstallation: '${toolname}'
dependencyCheckPublisher pattern: '**/${filename}-report.xml'
echo "======================================="
echo "dc checked"
"""
}
